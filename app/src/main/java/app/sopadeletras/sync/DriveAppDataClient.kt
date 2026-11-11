package app.sopadeletras.sync

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

/**
 * Minimal Google Drive v3 transport. Call only with an ACCESS token obtained
 * from Google AuthorizationClient after the user grants drive.appdata.
 * Never pass an ID token or a long-lived credential.
 */
class DriveAppDataClient {
    companion object {
        const val SCOPE = "https://www.googleapis.com/auth/drive.appdata"
        private const val FILE_NAME = "sopa-cristiana-progress-v1.json"
        private const val DRIVE = "https://www.googleapis.com/drive/v3/files"
        private const val UPLOAD = "https://www.googleapis.com/upload/drive/v3/files"
    }

    suspend fun download(accessToken: String): ProgressBackup? = withContext(Dispatchers.IO) {
        val fileId = locate(accessToken) ?: return@withContext null
        val payload = request(
            "GET", "$DRIVE/$fileId?alt=media", accessToken,
        )
        ProgressBackupJson.decode(payload)
    }

    suspend fun upload(accessToken: String, backup: ProgressBackup) = withContext(Dispatchers.IO) {
        val json = ProgressBackupJson.encode(backup)
        val fileId = locate(accessToken)
        if (fileId != null) {
            request(
                "PATCH", "$UPLOAD/$fileId?uploadType=media", accessToken,
                "application/json; charset=UTF-8", json.toByteArray(Charsets.UTF_8),
            )
        } else {
            val boundary = "slc-backup-v1"
            val metadata = JSONObject()
                .put("name", FILE_NAME)
                .put("mimeType", "application/json")
                .put("parents", org.json.JSONArray().put("appDataFolder"))
                .toString()
            val body = (
                "--$boundary\r\n" +
                "Content-Type: application/json; charset=UTF-8\r\n\r\n" +
                metadata + "\r\n" +
                "--$boundary\r\n" +
                "Content-Type: application/json; charset=UTF-8\r\n\r\n" +
                json + "\r\n" +
                "--$boundary--\r\n"
            ).toByteArray(Charsets.UTF_8)
            request(
                "POST", "$UPLOAD?uploadType=multipart&fields=id", accessToken,
                "multipart/related; boundary=$boundary", body,
            )
        }
    }

    private fun locate(accessToken: String): String? {
        val url = "$DRIVE?spaces=appDataFolder&fields=nextPageToken,files(id,name)&pageSize=100"
        val files = JSONObject(request("GET", url, accessToken)).getJSONArray("files")
        for (i in 0 until files.length()) {
            val file = files.getJSONObject(i)
            if (file.getString("name") == FILE_NAME) return file.getString("id")
        }
        return null
    }

    private fun request(
        method: String,
        url: String,
        accessToken: String,
        contentType: String? = null,
        body: ByteArray? = null,
    ): String {
        require(accessToken.isNotBlank())
        val connection = URL(url).openConnection() as HttpURLConnection
        try {
            connection.requestMethod = method
            connection.connectTimeout = 12_000
            connection.readTimeout = 15_000
            connection.setRequestProperty("Authorization", "Bearer $accessToken")
            connection.setRequestProperty("Accept", "application/json")
            if (body != null) {
                connection.doOutput = true
                connection.setRequestProperty("Content-Type", requireNotNull(contentType))
                connection.outputStream.use { it.write(body) }
            }
            val code = connection.responseCode
            // Do not log server error bodies: they may contain account information.
            if (code !in 200..299) throw IllegalStateException("Google Drive HTTP $code")
            return connection.inputStream.bufferedReader(Charsets.UTF_8).use { it.readText() }
        } finally {
            connection.disconnect()
        }
    }
}
