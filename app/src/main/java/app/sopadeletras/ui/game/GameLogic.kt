package app.sopadeletras.ui.game

import app.sopadeletras.core.PlacedWord
import app.sopadeletras.core.parSeconds

fun formatElapsed(totalSeconds: Int): String {
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return "%02d:%02d".format(minutes, seconds)
}

fun victorySummary(words: Int, seconds: Int): String {
    val noun = if (words == 1) "1 palavra" else "$words palavras"
    return "$noun em ${seconds / 60}m %02dS".format(seconds % 60).lowercase()
}

fun hintTarget(words: List<PlacedWord>, foundWords: Set<String>, hintIndex: Int = 0): Int? {
    val cells = words.firstOrNull { it.word !in foundWords }?.cells ?: return null
    val index = when (hintIndex.coerceIn(0, 2)) {
        0 -> 0
        1 -> cells.lastIndex / 2
        else -> cells.lastIndex
    }
    return cells.getOrNull(index)
}

fun timedLimit(words: Int, n: Int): Int = (parSeconds(words, n) * 1.3).toInt()

fun remainingSeconds(limit: Int, elapsed: Int): Int = maxOf(0, limit - elapsed)
