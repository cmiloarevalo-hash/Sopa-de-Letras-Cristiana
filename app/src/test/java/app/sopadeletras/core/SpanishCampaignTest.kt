package app.sopadeletras.core

import app.sopadeletras.data.CAMPAIGN_BANK_IDS
import app.sopadeletras.data.CAMPAIGN_GUIDES
import app.sopadeletras.data.APP_LANGUAGE
import app.sopadeletras.data.guideForLevel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SpanishCampaignTest {
    @Test fun `ten worlds cover exactly 300 Spanish levels`() {
        assertEquals("es-ES", APP_LANGUAGE)
        assertEquals(10, WORLDS.size)
        assertEquals(10, CAMPAIGN_BANK_IDS.size)
        assertEquals(10, CAMPAIGN_GUIDES.size)
        assertEquals("diluvio", CAMPAIGN_BANK_IDS[2])
        assertTrue(WORLDS[2].name.contains("Diluvio"))
        for (level in 1..300) {
            val info = levelInfo(level)
            assertEquals((level - 1) / 30, info.world)
            assertTrue(guideForLevel(level).reference.isNotBlank())
            assertTrue(info.words <= BoardConfig.maxWords(info.n))
        }
    }
}
