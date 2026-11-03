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
    World("La Creación", category = 0, n = 6, minWords = 3, maxWords = 4, dirsCount = 2, decoy = 0),
    World("Los primeros tiempos", category = 1, n = 8, minWords = 4, maxWords = 6, dirsCount = 3, decoy = 0),
    World("Noé y el Diluvio", category = 2, n = 8, minWords = 5, maxWords = 7, dirsCount = 5, decoy = 0.1),
    World("Patriarcas y promesas", category = 3, n = 10, minWords = 5, maxWords = 8, dirsCount = 3, decoy = 0.15),
    World("Moisés, reyes y profetas", category = 4, n = 10, minWords = 6, maxWords = 9, dirsCount = 5, decoy = 0.2),
    World("Jesús, su infancia y familia", category = 5, n = 10, minWords = 7, maxWords = 10, dirsCount = 8, decoy = 0.25),
    World("Jesús crece y enseña", category = 6, n = 12, minWords = 7, maxWords = 10, dirsCount = 5, decoy = 0.3),
    World("Jesús, sus amigos y apóstoles", category = 7, n = 12, minWords = 8, maxWords = 11, dirsCount = 8, decoy = 0.35),
    World("Redención, resurrección y salvación", category = 8, n = 12, minWords = 8, maxWords = 11, dirsCount = 8, decoy = 0.35),
    World("Comunidad y valores cristianos", category = 9, n = 12, minWords = 9, maxWords = 12, dirsCount = 8, decoy = 0.4),
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
    if (num == 20) {
        kind = LevelKind.MYSTERY
        n = minOf(n, 10)
    }
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
    GenParams(n = info.n, words = info.words, dirs = info.dirs, decoy = info.decoy)

fun campaignSeed(level: Int, languageCode: String): Long =
    level * 7919L + if (languageCode == Language.EN_CODE) 1L else 0L

fun isLevelUnlocked(level: Int, completed: Set<Int>): Boolean =
    level == 1 || (level - 1) in completed

fun isWorldUnlocked(world: Int, completed: Set<Int>): Boolean =
    world == 0 || (world * LEVELS_PER_WORLD) in completed

fun bestStars(current: Int, new: Int): Int = maxOf(current, new)
