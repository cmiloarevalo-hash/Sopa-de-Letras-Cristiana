package app.sopadeletras.data

import app.sopadeletras.core.LEVELS_PER_WORLD
import app.sopadeletras.core.campaignSummary

/** Generated from persistent level stars, so offline album state survives restarts. */
data class AlbumDiscovery(
    val world: Int,
    val title: String,
    val description: String,
    val reference: String,
    val unlocked: Boolean,
)

data class CampaignBadge(val name: String, val earned: Boolean)

fun albumForProgress(starsByLevel: Map<Int, Int>): List<AlbumDiscovery> =
    CAMPAIGN_GUIDES.mapIndexed { index, guide ->
        val first = index * LEVELS_PER_WORLD + 1
        val completedWorld = (first until first + LEVELS_PER_WORLD).all {
            (starsByLevel[it] ?: 0) in 1..3
        }
        AlbumDiscovery(
            world = index + 1,
            title = guide.name,
            description = guide.introduction,
            reference = guide.reference,
            unlocked = completedWorld,
        )
    }

fun badgesForProgress(starsByLevel: Map<Int, Int>): List<CampaignBadge> {
    val progress = campaignSummary(starsByLevel)
    return listOf(
        CampaignBadge("Primer paso", progress.completedLevels >= 1),
        CampaignBadge("Mundo explorado", progress.completedWorlds >= 1),
        CampaignBadge("Mitad del camino", progress.completedLevels >= 150),
        CampaignBadge("La gran aventura", progress.completedLevels == 300),
        CampaignBadge("Coleccionista de estrellas", progress.earnedStars >= 600),
    )
}
