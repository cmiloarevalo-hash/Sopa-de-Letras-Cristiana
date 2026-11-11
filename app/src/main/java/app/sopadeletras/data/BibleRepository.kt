package app.sopadeletras.data

import android.content.Context
import org.json.JSONObject
import java.text.Normalizer
import java.util.Locale

data class BibleBook(val id: String, val name: String, val chapters: Int)
data class BibleVerse(val number: Int, val text: String)
data class BibleLocation(val bookId: String, val chapter: Int, val verse: Int = 1)

/** Texto original de dominio público RV1909, paquete offline desde eBible.org. */
class BibleRepository(private val context: Context) {
    val books: List<BibleBook> by lazy {
        val rows = JSONObject(read("bible/rv1909/index.json")).getJSONArray("books")
        (0 until rows.length()).map {
            val row = rows.getJSONObject(it)
            BibleBook(row.getString("id"), row.getString("name"), row.getInt("chapterCount"))
        }
    }
    private val cache = mutableMapOf<String, JSONObject>()

    private fun read(file: String) = context.assets.open(file)
        .bufferedReader(Charsets.UTF_8).use { it.readText() }

    fun verses(bookId: String, chapter: Int): List<BibleVerse> {
        require(books.any { it.id == bookId && chapter in 1..it.chapters })
        val chapters = cache.getOrPut(bookId) {
            JSONObject(read("bible/rv1909/$bookId.json")).getJSONObject("chapters")
        }
        val verses = chapters.getJSONObject(chapter.toString())
        return verses.keys().asSequence().mapNotNull(String::toIntOrNull).sorted()
            .map { BibleVerse(it, verses.getString(it.toString())) }.toList()
    }

    fun locationFor(reference: String?): BibleLocation {
        if (reference.isNullOrBlank()) return BibleLocation("GEN", 1)
        val match = Regex("""^(.+?)\s+(\d+)(?::(\d+))?""")
            .find(reference.substringBefore(';').trim()) ?: return BibleLocation("GEN", 1)
        val requested = normalize(match.groupValues[1])
        val book = books.firstOrNull {
            val name = normalize(it.name)
            name == requested || name.removePrefix("san ") == requested
        } ?: return BibleLocation("GEN", 1)
        return BibleLocation(book.id, (match.groupValues[2].toIntOrNull() ?: 1).coerceIn(1, book.chapters), (match.groupValues[3].toIntOrNull() ?: 1).coerceAtLeast(1))
    }

    private fun normalize(text: String): String =
        Normalizer.normalize(text.lowercase(Locale.ROOT), Normalizer.Form.NFD)
            .replace(Regex("\\p{M}+"), "").replace(Regex("\\s+"), " ").trim()
}

