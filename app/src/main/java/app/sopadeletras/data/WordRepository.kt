package app.sopadeletras.data

import android.content.Context
import app.sopadeletras.core.MysteryEntry
import org.json.JSONArray
import org.json.JSONObject

data class WordCategoryData(
    val id: String,
    val name: String,
    val words: List<String>,
    val mysteries: Map<Int, MysteryEntry>,
)

/** V1: fixed editorial content for one of the 300 campaign levels. */
data class CampaignLevelData(
    val level: Int,
    val world: Int,
    val title: String,
    val topic: String,
    val reference: String,
    val value: String,
    val learningMessage: String,
    val bibleHint: String,
    val boardSize: Int,
    val words: List<String>,
    val mystery: MysteryEntry?,
)

class WordRepository(private val context: Context) {
    private val campaignLevels: Map<Int, CampaignLevelData> by lazy {
        val json = context.assets.open("campaign/es-ES/levels-v1.json")
            .bufferedReader(Charsets.UTF_8).use { it.readText() }
        val levels = JSONObject(json).getJSONArray("levels")
        (0 until levels.length()).map { i ->
            val row = levels.getJSONObject(i)
            val hidden = row.optJSONObject("mystery")
            CampaignLevelData(
                level = row.getInt("level"),
                world = row.getInt("world"),
                title = row.getString("title"),
                topic = row.getString("topic"),
                reference = row.getString("reference"),
                value = row.getString("value"),
                learningMessage = row.getString("learningMessage"),
                bibleHint = row.optString("bibleHint", row.getString("learningMessage")),
                boardSize = row.getInt("boardSize"),
                words = row.getJSONArray("words").toStringList(),
                mystery = hidden?.let { MysteryEntry(it.getString("word"), it.getString("clue"), it.optString("reference")) },
            )
        }.associateBy { it.level }.also { require(it.size == 300) }
    }

    fun loadCampaignLevel(level: Int): CampaignLevelData =
        requireNotNull(campaignLevels[level]) { "Nivel fuera del catálogo: $level" }

    fun loadCategory(language: String, id: String): WordCategoryData {
        val text = context.assets.open("words/$language/$id.json").bufferedReader().use { it.readText() }
        return parseCategory(text)
    }

    fun availableCategories(language: String): List<WordCategoryData> =
        context.assets.list("words/$language").orEmpty()
            .filter { it.endsWith(".json") }
            .map { loadCategory(language, it.removeSuffix(".json")) }
            .sortedBy { CAMPAIGN_BANK_IDS.indexOf(it.id).let { index -> if (index < 0) Int.MAX_VALUE else index } }

    internal fun parseCategory(text: String): WordCategoryData {
        val root = JSONObject(text)
        val words = root.getJSONArray("words").toStringList()
        val mysteries = mutableMapOf<Int, MysteryEntry>()
        val array: JSONArray = root.optJSONArray("mystery") ?: JSONArray()
        for (i in 0 until array.length()) {
            val entry = array.getJSONObject(i)
            val word = entry.getString("word")
            mysteries[word.length] = MysteryEntry(word, entry.getString("clue"), entry.optString("reference"))
        }
        return WordCategoryData(
            id = root.getString("id"),
            name = root.getString("name"),
            words = words,
            mysteries = mysteries,
        )
    }

    private fun JSONArray.toStringList(): List<String> =
        (0 until length()).map { getString(it) }
}
