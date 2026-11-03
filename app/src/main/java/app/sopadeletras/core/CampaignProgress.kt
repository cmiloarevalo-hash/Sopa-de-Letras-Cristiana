package app.sopadeletras.core

/**
 * Pure campaign/progress contract, shared by content, storage and UI.
 * A level is completed only after earning at least one star, and no result
 * contributes more than three stars to the 900-star campaign maximum.
 */
data class CampaignSummary(
    val completedLevels: Int,
    val earnedStars: Int,
    val nextLevel: Int,
    val completedWorlds: Int,
)

fun campaignSummary(starsByLevel: Map<Int, Int>): CampaignSummary {
    val completed = starsByLevel.filter { (level, stars) ->
        level in 1..TOTAL_LEVELS && stars in 1..3
    }
    val next = (1..TOTAL_LEVELS).firstOrNull { it !in completed } ?: TOTAL_LEVELS
    return CampaignSummary(
        completedLevels = completed.size,
        earnedStars = completed.values.sum(),
        nextLevel = next,
        completedWorlds = (1..WORLDS.size).count { world ->
            (world * LEVELS_PER_WORLD) in completed
        },
    )
}
