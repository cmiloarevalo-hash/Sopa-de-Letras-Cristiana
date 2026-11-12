package app.sopadeletras.core

/**
 * Posiciones del misterio: cada palabra encontrada revela una letra, de
 * izquierda a derecha. No hay azar ni coste extra y funciona al reanudar.
 */
fun mysteryLetterSlots(answer: String, solvedWords: Int, completed: Boolean): List<Char?> =
    answer.mapIndexed { position, letter ->
        if (completed || position < solvedWords.coerceAtLeast(0)) letter else null
    }

/** The found word reveals the initial at its fixed index, regardless of discovery order. */
fun mysteryLetterSlots(
    answer: String,
    foundWords: Set<String>,
    orderedWords: List<String>,
    completed: Boolean,
): List<Char?> {
    if (orderedWords.isEmpty()) return mysteryLetterSlots(answer, foundWords.size, completed)
    require(orderedWords.size == answer.length)
    require(orderedWords.joinToString("") { it.first().toString() } == answer)
    return answer.mapIndexed { position, letter ->
        if (completed || orderedWords[position] in foundWords) letter else null
    }
}

