package app.sopadeletras.sync

import org.json.JSONObject

/**
 * Strictly versioned 300-level backup. No passwords, ID tokens, email or
 * personal details beyond the optional user-chosen nickname.
 */
object ProgressBackupJson {
    fun encode(value: ProgressBackup): String {
        val levels = JSONObject()
        value.levels.toSortedMap().forEach { (index, progress) ->
            levels.put(index.toString(), JSONObject()
                .put("stars", progress.stars)
                .put("bestSeconds", progress.bestSeconds))
        }
        return JSONObject()
            .put("schemaVersion", value.schemaVersion)
            .put("game", "sopa-de-letras-cristiana")
            .put("language", value.language)
            .put("nickname", value.nickname.take(24))
            .put("levels", levels)
            .toString()
    }

    fun decode(payload: String): ProgressBackup {
        require(payload.length <= 100_000) { "Copia de progreso demasiado grande" }
        val root = JSONObject(payload)
        require(root.getString("game") == "sopa-de-letras-cristiana")
        require(root.getInt("schemaVersion") == 1)
        require(root.getString("language") == "es-ES")
        val rows = root.getJSONObject("levels")
        require(rows.length() <= 300)
        val levels = mutableMapOf<Int, LevelBackup>()
        val keys = rows.keys()
        while (keys.hasNext()) {
            val key = keys.next()
            val number = key.toIntOrNull() ?: error("Nivel de respaldo inválido")
            require(number in 1..300)
            val entry = rows.getJSONObject(key)
            levels[number] = LevelBackup(
                stars = entry.getInt("stars"),
                bestSeconds = entry.getInt("bestSeconds"),
            )
        }
        return ProgressBackup(nickname = root.optString("nickname", "").take(24), levels = levels)
    }
}
