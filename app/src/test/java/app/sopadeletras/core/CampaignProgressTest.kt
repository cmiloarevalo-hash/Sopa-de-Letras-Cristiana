package app.sopadeletras.core

import org.junit.Assert.assertEquals
import org.junit.Test

class CampaignProgressTest {
    @Test fun `new campaign starts with first unlocked level`() {
        assertEquals(CampaignSummary(0, 0, 1, 0), campaignSummary(emptyMap()))
    }

    @Test fun `full campaign never exceeds 900 stars`() {
        assertEquals(
            CampaignSummary(300, 900, 300, 10),
            campaignSummary((1..300).associateWith { 3 }),
        )
    }

    @Test fun `invalid results cannot unlock worlds or inflate total`() {
        assertEquals(
            CampaignSummary(2, 4, 2, 0),
            campaignSummary(mapOf(1 to 1, 30 to 3, 31 to 0, 301 to 3, -1 to 9)),
        )
    }
}
