package app.sopadeletras.core

import org.junit.Assert.assertEquals
import org.junit.Test

class MysteryLetterRevealTest {
    @Test fun uncoversLettersInReadingOrderOnEachFoundWord() {
        assertEquals(listOf(null, null, null, null, null), mysteryLetterSlots("PACTO", 0, false))
        assertEquals(listOf('P', null, null, null, null), mysteryLetterSlots("PACTO", 1, false))
        assertEquals(listOf('P','A','C',null,null), mysteryLetterSlots("PACTO", 3, false))
        assertEquals("PACTO".toList(), mysteryLetterSlots("PACTO", 7, false))
    }
    @Test fun restoringProgressAndVictoryNeverHideEarnedLetters() {
        assertEquals(listOf('A','M',null,null), mysteryLetterSlots("AMOR", 2, false))
        assertEquals("AMOR".toList(), mysteryLetterSlots("AMOR", 0, true))
        assertEquals(listOf(null,null,null,null), mysteryLetterSlots("AMOR", -5, false))
    }
}

