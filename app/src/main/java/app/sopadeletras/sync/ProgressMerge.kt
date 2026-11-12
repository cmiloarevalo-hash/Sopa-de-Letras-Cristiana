package app.sopadeletras.sync

/**
 * Data kept in the user's own account backup (Drive appDataFolder, once enabled).
 * No email, Google token, device ID or personal analytics belong in this record.
 */
data class LevelBackup(val stars: Int, val bestSeconds: Int) {
    init {
        require(stars in 1..3)
        require(bestSeconds >= 0)
    }
}

data class ProgressBackup(
    val schemaVersion: Int = 1,
    val language: String = "es-ES",
    val nickname: String = "",
    val levels: Map<Int, LevelBackup> = emptyMap(),
) {
    init {
        require(schemaVersion == 1)
        require(language == "es-ES")
        require(levels.keys.all { it in 1..300 })
    }
}

/**
 * Keep the user's highest stars. For the SAME stars keep the fastest time.
 * Time recorded with fewer stars must not overwrite the winning result.
 *
 * Merging a backup requires an explicitly selected Google account.
 * Authentication and Drive authorization are intentionally handled elsewhere.
 */
object ProgressMerge {
    fun combine(local: ProgressBackup, remote: ProgressBackup): ProgressBackup {
        require(local.schemaVersion == remote.schemaVersion)
        require(local.language == remote.language)
        val keys = local.levels.keys + remote.levels.keys
        val levels = keys.associateWith { level ->
            val a = local.levels[level]
            val b = remote.levels[level]
            when {
                a == null -> requireNotNull(b)
                b == null -> a
                a.stars > b.stars -> a
                b.stars > a.stars -> b
                else -> LevelBackup(a.stars, minOf(a.bestSeconds, b.bestSeconds))
            }
        }
        return ProgressBackup(
            schemaVersion = 1,
            language = "es-ES",
            nickname = local.nickname.ifBlank { remote.nickname }.take(24),
            levels = levels,
        )
    }
}
