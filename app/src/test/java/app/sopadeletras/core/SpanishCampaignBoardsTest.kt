package app.sopadeletras.core

import app.sopadeletras.data.CAMPAIGN_BANK_IDS
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/** A2 gate: exercise real shipped es-ES banks, not just world metadata. */
class SpanishCampaignBoardsTest {
    private companion object {
        const val SPANISH_FILL = "AAAEEEIIOOOSSNNRRLLTTCCDDMPUÑBG"
    }

    private data class Bank(val words: List<String>, val mysteries: Map<Int, MysteryEntry>)

    private fun loadBank(id: String): Bank {
        val file = File("src/main/assets/words/es-ES/$id.json")
        assertTrue("missing es-ES bank: ${file.path}", file.isFile)
        val text = file.readText(Charsets.UTF_8)
        val wordsSection = text.substringAfter("\"words\":").substringBefore("]")
        val words = Regex("\"([A-ZÑ]+)\"").findAll(wordsSection)
            .map { it.groupValues[1] }.toList()
        assertTrue("$id has no normal words", words.isNotEmpty())

        // Match the production repository's last-entry-per-length behavior.
        val mysteries = mutableMapOf<Int, MysteryEntry>()
        val mysterySection = text.substringAfter("\"mystery\":")
        val entryRe = Regex("""\{[^{}]*\}""")
        val wordRe = Regex(""""word"\s*:\s*"([A-ZÑ]+)"""")
        val clueRe = Regex(""""clue"\s*:\s*"([^"]+)"""")
        for (entry in entryRe.findAll(mysterySection)) {
            val word = wordRe.find(entry.value)?.groupValues?.get(1) ?: continue
            val clue = clueRe.find(entry.value)?.groupValues?.get(1) ?: continue
            mysteries[word.length] = MysteryEntry(word, clue)
        }
        assertTrue("$id has no mysteries", mysteries.isNotEmpty())
        return Bank(words, mysteries)
    }

    @Test fun allSpanishLevelsGenerateDeterministicSolvableBoards() {
        assertEquals(10, CAMPAIGN_BANK_IDS.size)
        val banks = CAMPAIGN_BANK_IDS.map(::loadBank)
        val sizesSeen = mutableSetOf<Int>()
        for (level in 1..300) {
            val info = levelInfo(level)
            val bank = banks[info.category]
            val seed = campaignSeed(level, "es-ES")
            val size = if (info.kind == LevelKind.MYSTERY) minOf(info.n, 10) else info.n
            val puzzle = makeBoard(info, bank, seed)
            val again = makeBoard(info, bank, seed)
            val context = "L$level ${CAMPAIGN_BANK_IDS[info.category]} n=$size seed=$seed"
            assertEquals("$context deterministic", puzzle, again)
            assertEquals("$context board size", size, puzzle.n)
            assertEquals("$context cell count", size * size, puzzle.letters.size)
            assertTrue("$context alphabet", puzzle.letters.all { it in 'A'..'Z' || it == 'Ñ' })
            sizesSeen.add(puzzle.n)

            val allowed = if (info.kind == LevelKind.MYSTERY)
                BoardConfig.normalDirs(size) else info.dirs
            val usedWords = mutableSetOf<String>()
            for (word in puzzle.words) {
                assertTrue("$context unknown ${word.word}", word.word in bank.words)
                assertTrue("$context duplicate ${word.word}", usedWords.add(word.word))
                assertEquals("$context ${word.word} path length", word.word.length, word.cells.size)
                assertTrue("$context ${word.word} outside board",
                    word.cells.all { it in puzzle.letters.indices })
                assertEquals("$context ${word.word} repeated cells",
                    word.cells.size, word.cells.distinct().size)
                assertEquals("$context ${word.word} not readable",
                    word.word, word.cells.map { puzzle.letters[it] }.joinToString(""))
                if (word.cells.size > 1) {
                    val dir = Dir(word.cells[1] / size - word.cells[0] / size,
                        word.cells[1] % size - word.cells[0] % size)
                    assertTrue("$context ${word.word} wrong direction", dir in allowed)
                    for (i in 1 until word.cells.size) {
                        val prev = word.cells[i - 1]
                        val next = word.cells[i]
                        assertEquals("$context ${word.word} noncontiguous path",
                            (prev / size + dir.dr) * size + prev % size + dir.dc, next)
                    }
                }
            }
            if (info.kind == LevelKind.MYSTERY) {
                val mystery = puzzle.mystery
                assertNotNull("$context fell back to normal puzzle", mystery)
                requireNotNull(mystery)
                assertTrue("$context empty mystery clue", mystery.clue.isNotBlank())
                assertEquals("$context mystery length", mystery.word.length, mystery.cells.size)
                assertEquals("$context mystery unreadable", mystery.word,
                    mystery.cells.map { puzzle.letters[it] }.joinToString(""))
                val covered = puzzle.words.flatMap { it.cells }.toSet()
                assertEquals("$context incorrect mystery cells",
                    puzzle.letters.indices.filter { it !in covered }, mystery.cells)
            } else {
                assertEquals("$context incomplete board", info.words, puzzle.words.size)
                assertTrue("$context unexpectedly has mystery", puzzle.mystery == null)
                for (word in puzzle.words) {
                    assertEquals("$context non-unique ${word.word}", 1,
                        PuzzleGenerator.countOccurrences(puzzle.letters, size, word.word))
                }
            }
        }
        assertEquals("All campaign board sizes must be exercised",
            setOf(6, 8, 10, 12), sizesSeen)
    }

    private fun makeBoard(info: LevelInfo, bank: Bank, seed: Long): Puzzle =
        if (info.kind == LevelKind.MYSTERY) {
            PuzzleGenerator.genMystery(minOf(info.n, 10), bank.words,
                bank.mysteries, seed, SPANISH_FILL)
        } else {
            PuzzleGenerator.generate(levelParams(info), bank.words, seed, SPANISH_FILL)
        }
}
