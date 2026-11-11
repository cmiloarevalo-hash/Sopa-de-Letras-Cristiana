package app.sopadeletras.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Real-content campaign contract: the APK must use all 300 FIXED editorial
 * vocabulary lists rather than selecting random words from old world banks.
 */
class FixedCampaignBoardsTest {
    private fun intField(text: String, name: String): Int =
        Regex("\"$name\"\\s*:\\s*(\\d+)").find(text)
            ?.groupValues?.get(1)?.toInt()
            ?: error("Missing integer $name")

    private fun stringField(text: String, name: String): String =
        Regex("\"$name\"\\s*:\\s*\"([^\"]+)\"").find(text)
            ?.groupValues?.get(1)
            ?: error("Missing string $name")

    @Test fun all300FixedLevelsAreExactSolvableAndDeterministic() {
        val source = File("src/main/assets/campaign/es-ES/levels-v1.json")
        assertTrue("Missing shipped fixed campaign asset", source.isFile)
        val blocks = source.readText(Charsets.UTF_8).replace("\r\n", "\n")
            .substringAfter("\"levels\": [")
            .split("\n    {\n")
            .drop(1)
        assertEquals("Campaign must have exactly 300 entries", 300, blocks.size)
        var mysteries = 0
        for ((index, block) in blocks.withIndex()) {
            val level = intField(block, "level")
            val boardSize = intField(block, "boardSize")
            val kind = stringField(block, "kind")
            val wordCount = intField(block, "wordCount")
            val words = Regex("\"([A-ZÑ]+)\"")
                .findAll(block.substringAfter("\"words\": [").substringBefore("]"))
                .map { it.groupValues[1] }.toList()
            assertEquals("L$level level number", index + 1, level)
            assertEquals("L$level exactly selected word count", wordCount, words.size)
            assertEquals("L$level no duplicate words", words.size, words.toSet().size)
            assertTrue("L$level word too long", words.all { it.length in 3..boardSize })
            val info = levelInfo(level).copy(n = boardSize, words = words.size)
            val seed = campaignSeed(level, Language.ES_CODE)
            val puzzle = if (kind == "MISTERIOSO") {
                val secret = block.substringAfter("\"mystery\":")
                val answer = MysteryEntry(
                    stringField(secret, "word"),
                    stringField(secret, "clue"),
                )
                mysteries++
                PuzzleGenerator.genCampaignMystery(
                    boardSize, words, answer, seed, Language.ES_FILL,
                )
            } else {
                PuzzleGenerator.generate(
                    levelParams(info), words, seed, Language.ES_FILL,
                )
            }
            assertEquals("L$level board size", boardSize, puzzle.n)
            assertEquals("L$level exact visible words", words.toSet(), puzzle.words.map { it.word }.toSet())
            assertEquals("L$level visible number", words.size, puzzle.words.size)
            assertTrue("L$level alphabet", puzzle.letters.all { it == 'Ñ' || it in 'A'..'Z' })
            for (word in puzzle.words) {
                assertEquals("L$level found word letters ${word.word}",
                    word.word, word.cells.map { puzzle.letters[it] }.joinToString(""))
                assertEquals("L$level repeated path for ${word.word}",
                    1, PuzzleGenerator.countOccurrences(puzzle.letters, puzzle.n, word.word))
            }
            if (kind == "MISTERIOSO") {
                val secret = puzzle.mystery
                assertNotNull("L$level must have mystery", secret)
                requireNotNull(secret)
                val covered = puzzle.words.flatMap { it.cells }.toSet()
                assertTrue("L$level hidden cells overlap visible paths",
                    secret.cells.none { it in covered })
                assertEquals("L$level secret letters",
                    secret.word, secret.cells.map { puzzle.letters[it] }.joinToString(""))
                val other = PuzzleGenerator.genCampaignMystery(
                    boardSize, words, MysteryEntry(secret.word, secret.clue),
                    seed, Language.ES_FILL,
                )
                assertEquals("L$level deterministic mystery", puzzle, other)
            } else {
                assertTrue("L$level unexpectedly has mystery", puzzle.mystery == null)
            }
        }
        assertEquals("One special mystery per world", 10, mysteries)
    }

    @Test fun geometricCountDoesNotDoublePalindromePaths() {
        // ANA is a biblical name in Luke 2 and must not be excluded.
        val board = listOf(
            'A', 'N', 'A',
            'Q', 'W', 'E',
            'R', 'T', 'Y',
        )
        assertEquals(1, PuzzleGenerator.countOccurrences(board, 3, "ANA"))
    }
}
