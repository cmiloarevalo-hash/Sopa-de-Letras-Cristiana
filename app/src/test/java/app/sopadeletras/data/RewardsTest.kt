package app.sopadeletras.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RewardsTest {
    @Test fun `album unlocks only fully completed worlds`() {
        assertEquals(10, albumForProgress(emptyMap()).size)
        assertFalse(albumForProgress(mapOf(30 to 3))[0].unlocked)
        val first = (1..30).associateWith { 1 }
        assertTrue(albumForProgress(first)[0].unlocked)
        assertFalse(albumForProgress(first)[1].unlocked)
    }

    @Test fun `badge achievements derive from saved stars`() {
        assertFalse(badgesForProgress(emptyMap())[0].earned)
        assertTrue(badgesForProgress(mapOf(1 to 1))[0].earned)
        assertTrue(badgesForProgress((1..300).associateWith { 3 }).all { it.earned })
    }
}
