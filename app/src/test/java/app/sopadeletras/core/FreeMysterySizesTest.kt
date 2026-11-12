package app.sopadeletras.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class FreeMysterySizesTest {
    private fun textField(text: String, name: String): String =
        Regex("\"$name\"\\s*:\\s*\"([^\"]+)\"").find(text)?.groupValues?.get(1)
            ?: error("Missing $name in $text")

    private fun intField(text: String, name: String): Int =
        Regex("\"$name\"\\s*:\\s*(\\d+)").find(text)?.groupValues?.get(1)?.toInt()
            ?: error("Missing $name in $text")

    @Test fun allThirtyFreeMysteriesKeepTheChosenBoardSizeAndRealAcrostic() {
        val file = File("src/main/assets/campaign/es-ES/free_mystery_sizes_v1.json")
        assertTrue("Missing 6x6 / 8x8 / 10x10 mystery catalog", file.isFile)
        val entries = file.readText(Charsets.UTF_8)
            .replace("\r\n", "\n")
            .substringAfter("\"layouts\": [")
            .split("\n    {")
            .drop(1)
        assertEquals("Ten worlds, three user-selectable sizes each", 30, entries.size)
        val categories = mutableMapOf<String, MutableSet<Int>>()
        for ((index, entry) in entries.withIndex()) {
            val category = textField(entry, "categoryId")
            val n = intField(entry, "size")
            assertTrue("$category $n is not selectable", n in listOf(6, 8, 10))
            categories.getOrPut(category) { mutableSetOf() }.add(n)
            val words = Regex("\"([A-ZÑ]+)\"")
                .findAll(entry.substringAfter("\"words\": [").substringBefore("]"))
                .map { it.groupValues[1] }.toList()
            val answer = textField(entry.substringAfter("\"mystery\": {"), "word")
            assertEquals("$category must have one initial per letter", answer.length, words.size)
            assertEquals("$category initials", answer, words.joinToString("") { it.first().toString() })
            assertEquals("$category repeated word", words.size, words.toSet().size)
            assertTrue("$category contains a word longer than $n", words.all { it.length in 3..n })
            val entryReference = textField(entry.substringAfter("\"mystery\": {"), "reference")
            assertTrue("$category mystery lacks a Bible reference", entryReference.isNotBlank())
            val puzzle = PuzzleGenerator.genCampaignMystery(
                n, words, MysteryEntry(answer, "Pista bíblica"), 20261112L + index * 1049L,
                Language.ES_FILL,
            )
            assertEquals("$category selection $n must stay $n×$n", n, puzzle.n)
            assertEquals("$category changed user-selected words", words.toSet(), puzzle.words.map { it.word }.toSet())
            assertEquals("$category lost its mystery", answer, puzzle.mystery?.word)
        }
        assertEquals(10, categories.size)
        assertTrue(categories.values.all { it == setOf(6, 8, 10) })
    }

    @Test fun developerInfoAndRelatedPastoralGuideAreVisible() {
        val values = File("src/main/res/values/strings.xml").readText(Charsets.UTF_8)
        assertTrue(values.contains("apkcristiana@gmail.com"))
        assertTrue(values.contains("Camilo Arévalo"))
        assertTrue(values.contains("Guía pastoral - Biblia"))
        val settings = File("src/main/java/app/sopadeletras/ui/settings/SettingsScreen.kt")
            .readText(Charsets.UTF_8)
        assertTrue(settings.contains("R.string.related_app_name"))
        assertTrue(settings.contains("mailto:apkcristiana@gmail.com"))
    }
}

