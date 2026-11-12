package app.sopadeletras.data

import android.content.Context
import app.sopadeletras.core.MysteryEntry
import org.json.JSONArray
import org.json.JSONObject

data class WordCategoryData(
    val id: String,
    val name: String,
    val words: List<String>,
    val mysteries: Map<Int, MysteryEntry>,
)

/** Association between a playable word and its own biblical verse. */
data class BiblicalWordHint(
    val word: String,
    val clue: String,
    val reference: String,
)

data class FreeMysteryChallenge(
    val boardSize: Int,
    val words: List<String>,
    val mystery: MysteryEntry,
)

data class CampaignLevelData(
    val level: Int,
    val world: Int,
    val title: String,
    val topic: String,
    val reference: String,
    val value: String,
    val learningMessage: String,
    val bibleHint: String,
    val boardSize: Int,
    val words: List<String>,
    val wordHints: Map<String, BiblicalWordHint>,
    val mystery: MysteryEntry?,
)

class WordRepository(private val context: Context) {
    private val campaignLevels: Map<Int, CampaignLevelData> by lazy {
        val json = context.assets.open("campaign/es-ES/levels-v1.json")
            .bufferedReader(Charsets.UTF_8).use { it.readText() }
        val levels = JSONObject(json).getJSONArray("levels")
        (0 until levels.length()).map { i ->
            val row = levels.getJSONObject(i)
            val hidden = row.optJSONObject("mystery")
            CampaignLevelData(
                level = row.getInt("level"),
                world = row.getInt("world"),
                title = row.getString("title"),
                topic = row.getString("topic"),
                reference = row.getString("reference"),
                value = row.getString("value"),
                learningMessage = row.getString("learningMessage"),
                bibleHint = row.optString("bibleHint", row.getString("learningMessage")),
                boardSize = row.getInt("boardSize"),
                words = row.getJSONArray("words").toStringList(),
                wordHints = row.optJSONArray("wordHints")?.let { entries ->
                    (0 until entries.length()).map { entry ->
                        val item = entries.getJSONObject(entry)
                        val hint = BiblicalWordHint(
                            item.getString("word"), item.getString("clue"), item.getString("reference"),
                        )
                        hint.word to hint
                    }.toMap()
                }.orEmpty(),
                mystery = hidden?.let { MysteryEntry(it.getString("word"), it.getString("clue"), it.optString("reference")) },
            )
        }.associateBy { it.level }.also { require(it.size == 300) }
    }

    private val freeMysteryLayouts: Map<Pair<String, Int>, FreeMysteryChallenge> by lazy {
        val text = context.assets.open("campaign/es-ES/free_mystery_sizes_v1.json")
            .bufferedReader(Charsets.UTF_8).use { it.readText() }
        val layouts = JSONObject(text).getJSONArray("layouts")
        (0 until layouts.length()).associate { i ->
            val row = layouts.getJSONObject(i)
            val size = row.getInt("size")
            val hidden = row.getJSONObject("mystery")
            val words = row.getJSONArray("words").toStringList()
            val mystery = MysteryEntry(
                hidden.getString("word"), hidden.getString("clue"), hidden.getString("reference"),
            )
            require(words.size == mystery.word.length)
            require(words.joinToString("") { it.first().toString() } == mystery.word)
            require(words.all { it.length in 3..size })
            (row.getString("categoryId") to size) to FreeMysteryChallenge(size, words, mystery)
        }.also { require(it.size == CAMPAIGN_BANK_IDS.size * 3) }
    }

    fun loadFreeMystery(category: String, size: Int): FreeMysteryChallenge =
        requireNotNull(freeMysteryLayouts[category to size]) {
            "No existe el misterio $size×$size para esta categoría"
        }

    fun loadCampaignLevel(level: Int): CampaignLevelData =
        requireNotNull(campaignLevels[level]) { "Nivel fuera del catálogo: $level" }

    /** All free-play words come from the documented campaign word-reference matrix. */
    fun campaignWordsForCategory(category: String): List<String> {
        val world = CAMPAIGN_BANK_IDS.indexOf(category).coerceAtLeast(0)
        return ((world * 30 + 1)..((world + 1) * 30))
            .flatMap { requireNotNull(campaignLevels[it]).words }
            .distinct()
    }

    fun wordHintsForCategory(category: String): Map<String, BiblicalWordHint> {
        val index = CAMPAIGN_BANK_IDS.indexOf(category)
        val levels = if (index >= 0)
            ((index * 30 + 1)..((index + 1) * 30)).mapNotNull(campaignLevels::get)
        else campaignLevels.values.toList()
        return levels.flatMap { it.wordHints.values }.associateBy { it.word }
    }

    fun loadCategory(language: String, id: String): WordCategoryData {
        val text = context.assets.open("words/$language/$id.json").bufferedReader().use { it.readText() }
        return parseCategory(text)
    }

    fun availableCategories(language: String): List<WordCategoryData> =
        context.assets.list("words/$language").orEmpty()
            .filter { it.endsWith(".json") }
            .map { loadCategory(language, it.removeSuffix(".json")) }
            .sortedBy { CAMPAIGN_BANK_IDS.indexOf(it.id).let { index -> if (index < 0) Int.MAX_VALUE else index } }

    internal fun parseCategory(text: String): WordCategoryData {
        val root = JSONObject(text)
        val words = root.getJSONArray("words").toStringList()
        val mysteries = mutableMapOf<Int, MysteryEntry>()
        val array: JSONArray = root.optJSONArray("mystery") ?: JSONArray()
        for (i in 0 until array.length()) {
            val entry = array.getJSONObject(i)
            val word = entry.getString("word")
            mysteries[word.length] = MysteryEntry(word, entry.getString("clue"), entry.optString("reference"))
        }
        return WordCategoryData(
            id = root.getString("id"),
            name = root.getString("name"),
            words = words,
            mysteries = mysteries,
        )
    }

    private fun JSONArray.toStringList(): List<String> =
        (0 until length()).map { getString(it) }
}
