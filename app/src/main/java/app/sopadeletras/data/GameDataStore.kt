package app.sopadeletras.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import app.sopadeletras.core.updateStreak
import app.sopadeletras.sync.LevelBackup
import app.sopadeletras.sync.ProgressBackup
import app.sopadeletras.sync.ProgressMerge
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.gameStore by preferencesDataStore(name = "game")

data class SavedGameData(
    val language: String,
    val level: Int,
    val foundWords: List<String>,
    val elapsed: Int,
    val hints: Int,
)

data class DailyData(
    val lastDay: Long,
    val streak: Int,
    val resultDay: Long?,
    val resultSeconds: Int,
    val resultStars: Int,
)

class GameDataStore(context: Context) {
    private val store = context.applicationContext.gameStore

    /** Only an optional local nickname; no login, email, or network access. */
    val nicknameFlow: Flow<String> = store.data.map {
        it[stringPreferencesKey("profile_nickname")] ?: ""
    }

    suspend fun saveNickname(value: String) {
        val clean = value.trim().replace('\n', ' ').replace('\r', ' ').take(24)
        store.edit { prefs ->
            val key = stringPreferencesKey("profile_nickname")
            if (clean.isEmpty()) prefs.remove(key) else prefs[key] = clean
        }
    }

    fun progressFlow(language: String): Flow<Map<Int, Int>> = store.data.map { prefs ->
        (1..300).mapNotNull { level ->
            prefs[intPreferencesKey(progressStarsKey(language, level))]?.let { stars -> level to stars }
        }.toMap()
    }

    suspend fun recordWin(language: String, level: Int, stars: Int, seconds: Int) {
        require(level in 1..300 && stars in 1..3 && seconds >= 0)
        store.edit { prefs ->
            val starsKey = intPreferencesKey(progressStarsKey(language, level))
            val secondsKey = intPreferencesKey(progressSecondsKey(language, level))
            val previous = prefs[starsKey] ?: 0
            if (stars > previous) {
                prefs[starsKey] = stars
                prefs[secondsKey] = seconds
            } else if (stars == previous) {
                val best = prefs[secondsKey]
                if (best == null || seconds < best) prefs[secondsKey] = seconds
            }
        }
    }


    /**
     * Bind this local progress to ONE Google account after the player expressly
     * chooses to save there. Refuse a different account: never silently upload
     * the previous player's stars to another person's private Drive folder.
     * This guard does not prevent offline gameplay.
     */
    suspend fun associateGoogleAccount(uniqueId: String, playerConfirmed: Boolean): Boolean {
        if (uniqueId.isBlank() || !playerConfirmed) return false
        val digest = java.security.MessageDigest.getInstance("SHA-256")
            .digest(uniqueId.toByteArray(Charsets.UTF_8))
            .joinToString("") { "%02x".format(it) }
        val key = stringPreferencesKey("sync_account_hash")
        var permitted = false
        store.edit { prefs ->
            val current = prefs[key]
            if (current == null || current == digest) {
                prefs[key] = digest
                permitted = true
            }
        }
        return permitted
    }

    /** Snapshot requested only after choosing a Google account.
     * Contains no email or tokens and uses the same local DataStore as gameplay.
     */
    suspend fun exportProgressBackup(): ProgressBackup = backupFrom(store.data.first())

    /**
     * This is atomic with local victories, so a concurrent local game update
     * cannot be overwritten by an older cloud snapshot.
     *
     * Caller must first verify the selected account and explicit guest-to-
     * account consent. Different Google accounts must use separate profiles.
     */
    suspend fun mergeAuthorizedBackup(remote: ProgressBackup): ProgressBackup {
        var merged: ProgressBackup? = null
        store.edit { prefs ->
            val result = ProgressMerge.combine(backupFrom(prefs), remote)
            for ((level, entry) in result.levels) {
                prefs[intPreferencesKey(progressStarsKey("es-ES", level))] = entry.stars
                prefs[intPreferencesKey(progressSecondsKey("es-ES", level))] = entry.bestSeconds
            }
            if (result.nickname.isNotBlank()) {
                prefs[stringPreferencesKey("profile_nickname")] = result.nickname
            }
            merged = result
        }
        return requireNotNull(merged)
    }

    private fun backupFrom(prefs: androidx.datastore.preferences.core.Preferences): ProgressBackup {
        val levels = (1..300).mapNotNull { level ->
            val stars = prefs[intPreferencesKey(progressStarsKey("es-ES", level))] ?: return@mapNotNull null
            val seconds = prefs[intPreferencesKey(progressSecondsKey("es-ES", level))] ?: 0
            if (stars !in 1..3 || seconds < 0) return@mapNotNull null
            level to LevelBackup(stars, seconds)
        }.toMap()
        return ProgressBackup(
            nickname = prefs[stringPreferencesKey("profile_nickname")] ?: "",
            levels = levels,
        )
    }

    fun savedGameFlow(): Flow<SavedGameData?> = store.data.map { prefs ->
        if ((prefs[intPreferencesKey("sg_present")] ?: 0) != 1) return@map null
        SavedGameData(
            language = prefs[stringPreferencesKey("sg_language")] ?: return@map null,
            level = prefs[intPreferencesKey("sg_level")] ?: return@map null,
            foundWords = decodeFound(prefs[stringPreferencesKey("sg_words")] ?: ""),
            elapsed = prefs[intPreferencesKey("sg_elapsed")] ?: 0,
            hints = prefs[intPreferencesKey("sg_hints")] ?: 0,
        )
    }

    suspend fun saveGame(data: SavedGameData) {
        store.edit { prefs ->
            prefs[intPreferencesKey("sg_present")] = 1
            prefs[stringPreferencesKey("sg_language")] = data.language
            prefs[intPreferencesKey("sg_level")] = data.level
            prefs[stringPreferencesKey("sg_words")] = encodeFound(data.foundWords)
            prefs[intPreferencesKey("sg_elapsed")] = data.elapsed
            prefs[intPreferencesKey("sg_hints")] = data.hints
        }
    }

    suspend fun clearSavedGame() {
        store.edit { prefs ->
            prefs[intPreferencesKey("sg_present")] = 0
            prefs.remove(stringPreferencesKey("sg_language"))
            prefs.remove(intPreferencesKey("sg_level"))
            prefs.remove(stringPreferencesKey("sg_words"))
            prefs.remove(intPreferencesKey("sg_elapsed"))
            prefs.remove(intPreferencesKey("sg_hints"))
        }
    }

    fun resultsFlow(): Flow<List<StoredResult>> = store.data.map { prefs ->
        (prefs[stringSetPreferencesKey("results")] ?: emptySet()).map(::decodeResult)
    }

    fun dailyFlow(): Flow<DailyData?> = store.data.map { prefs ->
        val lastDay = prefs[longPreferencesKey("dy_last")] ?: return@map null
        DailyData(
            lastDay = lastDay,
            streak = prefs[intPreferencesKey("dy_streak")] ?: 0,
            resultDay = prefs[longPreferencesKey("dy_result_day")],
            resultSeconds = prefs[intPreferencesKey("dy_result_sec")] ?: 0,
            resultStars = prefs[intPreferencesKey("dy_result_stars")] ?: 0,
        )
    }

    suspend fun recordDaily(today: Long, seconds: Int, stars: Int) {
        store.edit { prefs ->
            if (prefs[longPreferencesKey("dy_result_day")] == today) return@edit
            val lastDay = prefs[longPreferencesKey("dy_last")]
            val streak = prefs[intPreferencesKey("dy_streak")] ?: 0
            val next = if (lastDay == null) 1 else updateStreak(lastDay, today, streak)
            prefs[longPreferencesKey("dy_last")] = today
            prefs[intPreferencesKey("dy_streak")] = next
            prefs[longPreferencesKey("dy_result_day")] = today
            prefs[intPreferencesKey("dy_result_sec")] = seconds
            prefs[intPreferencesKey("dy_result_stars")] = stars
        }
    }

    suspend fun addResult(row: StoredResult) {
        val current = resultsFlow().first().map(::encodeResult).toMutableSet()
        current.add(encodeResult(row))
        while (current.size > 1000) {
            val oldest = current.minByOrNull { decodeResult(it).finishedAt } ?: break
            current.remove(oldest)
        }
        store.edit { prefs ->
            prefs[stringSetPreferencesKey("results")] = current
        }
    }
}
