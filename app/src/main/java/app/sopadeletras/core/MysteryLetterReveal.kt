package app.sopadeletras.core

/**
 * Posiciones del misterio: cada palabra encontrada revela una letra, de
 * izquierda a derecha. No hay azar ni coste extra y funciona al reanudar.
 */
fun mysteryLetterSlots(answer: String, solvedWords: Int, completed: Boolean): List<Char?> =
    answer.mapIndexed { position, letter ->
        if (completed || position < solvedWords.coerceAtLeast(0)) letter else null
    }

