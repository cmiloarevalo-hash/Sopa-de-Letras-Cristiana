package app.sopadeletras.core

import kotlin.math.round

enum class LevelKind {
    NORMAL,
    TIMED,
    MYSTERY,
    BOSS,
}

data class World(
    val name: String,
    val category: Int,
    val n: Int,
    val minWords: Int,
    val maxWords: Int,
    val dirsCount: Int,
    val decoy: Double,
)

data class LevelInfo(
    val level: Int,
    val world: Int,
    val num: Int,
    val kind: LevelKind,
    val n: Int,
    val words: Int,
    val dirs: List<Dir>,
    val dirsCount: Int,
    val decoy: Double,
    val category: Int,
    val seed: Long,
)

const val LEVELS_PER_WORLD = 30
const val TOTAL_LEVELS = 300

val WORLDS = listOf(
    World("La creación y la vida", category = 0, n = 6, minWords = 3, maxWords = 4, dirsCount = 2, decoy = 0.0),
    World("Las primeras familias", category = 1, n = 8, minWords = 4, maxWords = 6, dirsCount = 3, decoy = 0.0),
    World("Noé y la esperanza", category = 2, n = 8, minWords = 6, maxWords = 8, dirsCount = 5, decoy = 0.2),
    World("Abraham y las promesas", category = 3, n = 10, minWords = 6, maxWords = 9, dirsCount = 3, decoy = 0.2),
    World("Moisés, libertad y justicia", category = 4, n = 10, minWords = 8, maxWords = 11, dirsCount = 5, decoy = 0.4),
    World("Jesús y su familia", category = 5, n = 10, minWords = 10, maxWords = 12, dirsCount = 8, decoy = 0.5),
    World("Jesús nos enseña a amar", category = 6, n = 12, minWords = 8, maxWords = 12, dirsCount = 5, decoy = 0.5),
    World("Jesús y sus amigos", category = 7, n = 12, minWords = 10, maxWords = 14, dirsCount = 8, decoy = 0.6),
    World("Jesús vive: amor y esperanza", category = 8, n = 12, minWords = 12, maxWords = 16, dirsCount = 8, decoy = 0.8),
    World("Una comunidad que comparte", category = 9, n = 12, minWords = 14, maxWords = 18, dirsCount = 8, decoy = 1.0),
)

private fun dirsForCount(count: Int): List<Dir> = when (count) {
    2 -> BoardConfig.D2
    3 -> BoardConfig.D3
    5 -> BoardConfig.D5
    else -> BoardConfig.D8
}

fun levelInfo(level: Int): LevelInfo {
    require(level in 1..TOTAL_LEVELS)
    val world = (level - 1) / LEVELS_PER_WORLD
    val pos = (level - 1) % LEVELS_PER_WORLD
    val num = pos + 1
    val def = WORLDS[world]
    var n = def.n
    var words = round(def.minWords + (def.maxWords - def.minWords) * pos / (LEVELS_PER_WORLD - 1).toDouble()).toInt()
    var dirsCount = def.dirsCount
    var kind = LevelKind.NORMAL
    if (num == 10) kind = LevelKind.TIMED
    if (num == 20) kind = LevelKind.MYSTERY
    if (num == 30) {
        kind = LevelKind.BOSS
        words = minOf(BoardConfig.maxWords(n), def.maxWords + 2)
        dirsCount = 8
    }
    words = minOf(words, BoardConfig.maxWords(n))
    return LevelInfo(
        level = level,
        world = world,
        num = num,
        kind = kind,
        n = n,
        words = words,
        dirs = dirsForCount(dirsCount),
        dirsCount = dirsCount,
        decoy = def.decoy,
        category = def.category,
        seed = level * 7919L,
    )
}

fun levelParams(info: LevelInfo): GenParams =
    GenParams(n = info.n, words = info.words, dirs = info.dirs, decoy = info.decoy, requireCrossing = info.n >= 10 && info.words >= 8 && info.kind != LevelKind.MYSTERY)

fun campaignSeed(level: Int, languageCode: String): Long =
    level * 7919L + if (languageCode == Language.EN_CODE) 1L else 0L

fun isLevelUnlocked(level: Int, completed: Set<Int>): Boolean =
    level == 1 || (level - 1) in completed

fun isWorldUnlocked(world: Int, completed: Set<Int>): Boolean =
    world == 0 || (world * LEVELS_PER_WORLD) in completed

fun bestStars(current: Int, new: Int): Int = maxOf(current, new)
