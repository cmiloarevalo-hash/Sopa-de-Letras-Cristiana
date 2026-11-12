package app.sopadeletras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.sopadeletras.core.BoardConfig
import app.sopadeletras.core.Difficulty
import app.sopadeletras.core.GenParams
import app.sopadeletras.core.Language
import app.sopadeletras.core.LEVELS_PER_WORLD
import app.sopadeletras.core.LevelKind
import app.sopadeletras.core.WORLDS
import app.sopadeletras.core.campaignSeed
import app.sopadeletras.core.dailyCategoryIndex
import app.sopadeletras.core.dailySeedNumber
import app.sopadeletras.core.diffParams
import app.sopadeletras.core.displayedStreak
import app.sopadeletras.core.levelInfo
import app.sopadeletras.core.levelParams
import app.sopadeletras.data.CAMPAIGN_BANK_IDS
import app.sopadeletras.data.SavedGameData
import app.sopadeletras.data.StartupSnapshot
import app.sopadeletras.data.StoredResult
import app.sopadeletras.ui.album.AlbumScreen
import app.sopadeletras.ui.bible.BibleScreen
import app.sopadeletras.data.BibleRepository
import app.sopadeletras.ui.cover.CoverScreen
import app.sopadeletras.ui.campaign.CampaignScreen
import app.sopadeletras.ui.game.GameScreen
import app.sopadeletras.ui.game.GameViewModel
import app.sopadeletras.ui.game.GameViewModelFactory
import app.sopadeletras.ui.game.MysteryScreen
import app.sopadeletras.ui.game.MysteryViewModelFactory
import app.sopadeletras.ui.game.SavedPlayState
import app.sopadeletras.ui.game.timedLimit
import app.sopadeletras.ui.home.HomeScreen
import app.sopadeletras.ui.settings.SettingsScreen
import app.sopadeletras.ui.setup.NewGameScreen
import app.sopadeletras.ui.setup.SetupMode
import app.sopadeletras.ui.stats.StatsScreen
import app.sopadeletras.ui.theme.SopaTheme
import app.sopadeletras.ui.theme.TintaAmbar
import app.sopadeletras.ui.theme.TokyoNight
import app.sopadeletras.ui.timeattack.TimeAttackScreen
import app.sopadeletras.ui.timeattack.TimeAttackViewModel
import app.sopadeletras.ui.timeattack.TimeAttackViewModelFactory
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val container = (application as SopaApp).container
            // Synchronous first read so the first frame already uses the saved
            // theme/language (no Tinta flash). Bounded: falls back to defaults.
            val startup = runBlocking {
                withTimeoutOrNull(800) { container.settings.snapshot() }
            } ?: StartupSnapshot(
                language = Language.ES_CODE,
                theme = "TINTA",
                assist = true,
                haptics = true,
                letterScale = 1f,
                colorblind = false,
            )
            val theme by container.settings.theme.collectAsState(initial = startup.theme)
            val lang = Language.ES_CODE
            val haptics by container.settings.haptics.collectAsState(initial = startup.haptics)
            val letterScale by container.settings.letterScale.collectAsState(initial = startup.letterScale)
            val colorblind by container.settings.colorblind.collectAsState(initial = startup.colorblind)
            val sound by container.settings.sound.collectAsState(initial = true)
            SopaTheme(colors = if (theme == "TOKYO") TokyoNight else TintaAmbar) {
                val nav = rememberNavController()
                val bibleRepository = remember { BibleRepository(applicationContext) }
                val openBible: (String) -> Unit = { ref ->
                    val loc = bibleRepository.locationFor(ref)
                    nav.navigate("bible/" + loc.bookId + "/" + loc.chapter + "/" + loc.verse)
                }
                val bankBible: (String) -> app.sopadeletras.data.CampaignLevelData = { id ->
                    val index = CAMPAIGN_BANK_IDS.indexOf(id).coerceAtLeast(0)
                    container.words.loadCampaignLevel(index * 30 + 1)
                }
                val scope = rememberCoroutineScope()
                androidx.compose.animation.Crossfade(
                    targetState = theme,
                    animationSpec = tween(350),
                    label = "theme",
                ) {
                NavHost(navController = nav, startDestination = "cover") {
                    composable("cover") {
                        CoverScreen(onStart = { nav.navigate("home") {
                            popUpTo("cover") { inclusive = true }
                        } })
                    }
                    composable("home") {
                        HomeScreen(
                            container = container,
                            language = lang,
                            onCampaign = { nav.navigate("campaign") },
                            onResume = { level -> nav.navigate("gameCampaign/$level?resume=true") },
                            onFreeGame = { nav.navigate("newGame/FREE") },
                            onTimeGame = { nav.navigate("newGame/TIME") },
                            onMysteryGame = { nav.navigate("newGame/MYSTERY") },
                            onDaily = { nav.navigate("gameDaily") },
                            onAlbum = { nav.navigate("album") },
                            onStats = { nav.navigate("stats") },
                            onSettings = { nav.navigate("settings") },
                            onBible = { nav.navigate("bible/GEN/1/1") },
                        )
                    }
                    composable("campaign") {
                        CampaignScreen(
                            container = container,
                            language = lang,
                            onBack = { nav.popBackStack() },
                            onPlayLevel = { level -> nav.navigate("gameCampaign/$level") },
                        )
                    }
                    composable(
                        route = "bible/{book}/{chapter}/{verse}",
                        arguments = listOf(
                            navArgument("book") { type = NavType.StringType },
                            navArgument("chapter") { type = NavType.IntType },
                            navArgument("verse") { type = NavType.IntType },
                        ),
                    ) { entry ->
                        BibleScreen(
                            onBack = { nav.popBackStack() },
                            initialBook = entry.arguments?.getString("book") ?: "GEN",
                            initialChapter = entry.arguments?.getInt("chapter") ?: 1,
                            initialVerse = entry.arguments?.getInt("verse") ?: 1,
                        )
                    }
                    composable("settings") {
                        SettingsScreen(container = container, onBack = { nav.popBackStack() })
                    }
                    composable(
                        route = "newGame/{mode}",
                        arguments = listOf(navArgument("mode") { type = NavType.StringType }),
                    ) { entry ->
                        val mode = runCatching {
                            SetupMode.valueOf(entry.arguments?.getString("mode") ?: "FREE")
                        }.getOrDefault(SetupMode.FREE)
                        val categories = remember { container.words.availableCategories(lang) }
                        NewGameScreen(
                            container = container,
                            categories = categories,
                            mode = mode,
                            onBack = { nav.popBackStack() },
                            onStartFree = { size, category, difficulty ->
                                nav.navigate("gameFree/$size/$category/${difficulty.name}")
                            },
                            onStartTime = { size, category, duration ->
                                nav.navigate("gameTime/$size/$category/$duration")
                            },
                            onStartMystery = { size, category ->
                                nav.navigate("gameMystery/$size/$category")
                            },
                        )
                    }
                    composable("album") {
                        AlbumScreen(container = container, onBack = { nav.popBackStack() })
                    }
                    composable("stats") {
                        StatsScreen(container = container, language = lang, onBack = { nav.popBackStack() })
                    }
                    composable("gameDaily") {
                        val date = java.time.LocalDate.now()
                        val today = date.toEpochDay()
                        val bankId = CAMPAIGN_BANK_IDS[dailyCategoryIndex(date.year, date.monthValue, date.dayOfMonth)]
                        val assist by container.settings.directionAssist.collectAsState(initial = true)
                        val daily by container.gameData.dailyFlow().collectAsState(initial = null)
                        val bank = remember(bankId) { container.words.loadCategory(lang, bankId) }
                        val seed = remember(today) { dailySeedNumber(date.year, date.monthValue, date.dayOfMonth) }
                        val params = remember {
                            GenParams(10, BoardConfig.baseWords(10), BoardConfig.normalDirs(10), 0.2)
                        }
                        val vm: GameViewModel = viewModel(
                            key = "daily-$today",
                            factory = GameViewModelFactory(bank.words, params, seed, Language.fillFor(lang), assist),
                        )
                        val streakLine = daily?.let {
                            if (displayedStreak(it.lastDay, today, it.streak) > 0) {
                                "🔥 ${displayedStreak(it.lastDay, today, it.streak)} días seguidos"
                            } else {
                                null
                            }
                        }
                        GameScreen(
                            viewModel = vm,
                            title = "Desafío diario",
                            subtitle = "${bank.name} · 10×10",
                            winTitle = "¡Nivel completado!",
                            winPrimaryLabel = "Inicio",
                            winSecondaryLabel = null,
                            winExtraLine = streakLine,
                            onExit = { nav.popBackStack() },
                            onNext = { nav.popBackStack() },
                            onWin = { stars, seconds ->
                                scope.launch {
                                    container.gameData.recordDaily(today, seconds, stars)
                                    container.gameData.addResult(
                                        StoredResult(
                                            mode = "DAILY", language = lang, difficulty = "",
                                            level = null, n = 10, category = bankId,
                                            seconds = seconds, hints = vm.state.value.hintsUsed,
                                            stars = stars, score = 0, words = params.words,
                                            finishedAt = System.currentTimeMillis(),
                                        ),
                                    )
                                }
                            },
                            haptics = haptics,
                            letterScale = letterScale,
                            colorblind = colorblind,
                            sounds = container.sounds,
                            sound = sound,
                            bibleHint = bankBible(bankId).bibleHint,
                            bibleReference = bankBible(bankId).reference,
                            onReadBible = openBible,
                        )
                    }
                    composable(
                        route = "gameTime/{size}/{category}/{duration}",
                        arguments = listOf(
                            navArgument("size") { type = NavType.IntType },
                            navArgument("category") { type = NavType.StringType },
                            navArgument("duration") { type = NavType.IntType },
                        ),
                    ) { entry ->
                        val size = entry.arguments?.getInt("size") ?: 8
                        val category = entry.arguments?.getString("category").orEmpty()
                        val duration = entry.arguments?.getInt("duration") ?: 180
                        val assist by container.settings.directionAssist.collectAsState(initial = true)
                        val results by container.gameData.resultsFlow().collectAsState(initial = emptyList())
                        val record = results.filter { it.mode == "TIME" }.maxOfOrNull { it.score } ?: 0
                        val bank = remember(category) { container.words.loadCategory(lang, category) }
                        val params = remember(size) {
                            GenParams(size, BoardConfig.baseWords(size), BoardConfig.normalDirs(size), 0.2)
                        }
                        var round by remember { mutableIntStateOf(0) }
                        val seed = remember(round) { Random.nextLong() }
                        val vm: TimeAttackViewModel = viewModel(
                            key = "time-$size-$category-$duration-$round",
                            factory = TimeAttackViewModelFactory(bank.words, params, seed, Language.fillFor(lang), duration, assist),
                        )
                        TimeAttackScreen(
                            viewModel = vm,
                            boardSize = size,
                            categoryName = bank.name,
                            duration = duration,
                            record = record,
                            onExit = { nav.popBackStack() },
                            onReplay = { round++ },
                            onFinish = {
                                scope.launch {
                                    container.gameData.addResult(
                                        StoredResult(
                                            mode = "TIME", language = lang, difficulty = "",
                                            level = null, n = size, category = category,
                                            seconds = duration, hints = 0,
                                            stars = 0, score = vm.state.value.points,
                                            words = vm.state.value.totalWords,
                                            finishedAt = System.currentTimeMillis(),
                                        ),
                                    )
                                }
                            },
                            haptics = haptics,
                            letterScale = letterScale,
                            colorblind = colorblind,
                            sounds = container.sounds,
                            sound = sound,
                            bibleHint = bankBible(category).bibleHint,
                            bibleReference = bankBible(category).reference,
                            onReadBible = openBible,
                        )
                    }
                    composable(
                        route = "gameMystery/{size}/{category}",
                        arguments = listOf(
                            navArgument("size") { type = NavType.IntType },
                            navArgument("category") { type = NavType.StringType },
                        ),
                    ) { entry ->
                        val size = entry.arguments?.getInt("size") ?: 8
                        val category = entry.arguments?.getString("category").orEmpty()
                        val assist by container.settings.directionAssist.collectAsState(initial = true)
                        val bank = remember(category) { container.words.loadCategory(lang, category) }
                        var round by remember { mutableIntStateOf(0) }
                        val seed = remember(round) { Random.nextLong() }
                        val vm: app.sopadeletras.ui.game.MysteryViewModel = viewModel(
                            key = "freemys-$size-$category-$round",
                            factory = MysteryViewModelFactory(bank.words, bank.mysteries, size, seed, Language.fillFor(lang), assist),
                        )
                        MysteryScreen(
                            viewModel = vm,
                            title = "Palabra misteriosa",
                            subtitle = "${bank.name} · $size×$size",
                            winPrimaryLabel = "Siguiente",
                            winSecondaryLabel = "Inicio",
                            onExit = { nav.popBackStack() },
                            onNext = { round++ },
                            onWin = { stars, seconds ->
                                scope.launch {
                                    container.gameData.addResult(
                                        StoredResult(
                                            mode = "MYSTERY", language = lang, difficulty = "",
                                            level = null, n = size, category = category,
                                            seconds = seconds, hints = vm.state.value.hintsUsed,
                                            stars = stars, score = 0, words = vm.state.value.found.size,
                                            finishedAt = System.currentTimeMillis(),
                                        ),
                                    )
                                }
                            },
                            haptics = haptics,
                            letterScale = letterScale,
                            colorblind = colorblind,
                            sounds = container.sounds,
                            sound = sound,
                            bibleReference = bankBible(category).reference,
                            onReadBible = openBible,
                        )
                    }
                    composable(
                        route = "gameFree/{size}/{category}/{difficulty}",
                        arguments = listOf(
                            navArgument("size") { type = NavType.IntType },
                            navArgument("category") { type = NavType.StringType },
                            navArgument("difficulty") { type = NavType.StringType },
                        ),
                    ) { entry ->
                        val size = entry.arguments?.getInt("size") ?: 8
                        val category = entry.arguments?.getString("category").orEmpty()
                        val difficulty = runCatching {
                            Difficulty.valueOf(entry.arguments?.getString("difficulty") ?: "NORMAL")
                        }.getOrDefault(Difficulty.NORMAL)
                        val assist by container.settings.directionAssist.collectAsState(initial = true)
                        val bank = remember(category) { container.words.loadCategory(lang, category) }
                        val params = remember(size, difficulty) { diffParams(size, difficulty) }
                        var round by remember { mutableIntStateOf(0) }
                        val seed = remember(round) { Random.nextLong() }
                        val vm: GameViewModel = viewModel(
                            key = "free-$size-$category-${difficulty.name}-$round",
                            factory = GameViewModelFactory(bank.words, params, seed, Language.fillFor(lang), assist),
                        )
                        GameScreen(
                            viewModel = vm,
                            title = bank.name,
                            subtitle = "Juego libre · $size×$size · ${difficultyLabel(difficulty)}",
                            onExit = { nav.popBackStack() },
                            onNext = { round++ },
                            onWin = { stars, seconds ->
                                scope.launch {
                                    container.gameData.addResult(
                                        StoredResult(
                                            mode = "FREE", language = lang, difficulty = difficulty.name,
                                            level = null, n = size, category = category, seconds = seconds,
                                            hints = vm.state.value.hintsUsed, stars = stars, score = 0,
                                            words = params.words, finishedAt = System.currentTimeMillis(),
                                        ),
                                    )
                                }
                            },
                            haptics = haptics,
                            letterScale = letterScale,
                            colorblind = colorblind,
                            sounds = container.sounds,
                            sound = sound,
                            bibleHint = bankBible(category).bibleHint,
                            bibleReference = bankBible(category).reference,
                            onReadBible = openBible,
                        )
                    }
                    composable(
                        route = "gameCampaign/{level}?resume={resume}",
                        arguments = listOf(
                            navArgument("level") { type = NavType.IntType },
                            navArgument("resume") { type = NavType.BoolType; defaultValue = false },
                        ),
                    ) { entry ->
                        val level = entry.arguments?.getInt("level") ?: 1
                        val resume = entry.arguments?.getBoolean("resume") ?: false
                        val campaignLevel = remember(level) { container.words.loadCampaignLevel(level) }
                        val info = remember(level) {
                            levelInfo(level).copy(
                                n = campaignLevel.boardSize,
                                words = campaignLevel.words.size,
                            )
                        }
                        val bankId = CAMPAIGN_BANK_IDS[info.category]
                        val assist by container.settings.directionAssist.collectAsState(initial = true)
                        val seen by container.settings.tutorialSeen.collectAsState(initial = emptySet())
                        val saved by container.gameData.savedGameFlow().collectAsState(initial = null)
                        val seed = remember(level) { campaignSeed(level, lang) }
                        val tip = tutorialTip(level, seen)
                        val dismissTip = {
                            if (tip != null) scope.launch { container.settings.markTutorialSeen(tipKey(level)) }
                        }
                        val suffix = when (info.kind) {
                            LevelKind.TIMED -> " · Cronometrado"
                            LevelKind.MYSTERY -> " · Misteriosa"
                            LevelKind.BOSS -> " · Final"
                            LevelKind.NORMAL -> ""
                        }
                        val subtitle = "Nivel $level · ${campaignLevel.topic} · ${info.n}×${info.n}$suffix"
                        val worldName = WORLDS[info.world].name

                        if (info.kind == LevelKind.MYSTERY) {
                            val initial = savedInitial(saved, level)
                            val vm: app.sopadeletras.ui.game.MysteryViewModel = viewModel(
                                key = "mys-$level-$resume",
                                factory = MysteryViewModelFactory(
                                    campaignLevel.words, emptyMap(), campaignLevel.boardSize, seed,
                                    Language.ES_FILL, assist, initial, campaignLevel.mystery,
                                ),
                            )
                            MysteryScreen(
                                viewModel = vm,
                                title = worldName,
                                subtitle = subtitle,
                                onExit = {
                                    val current = vm.state.value
                                    scope.launch {
                                        if (!current.victory && current.found.isNotEmpty()) {
                                            container.gameData.saveGame(
                                                SavedGameData(
                                                    language = lang, level = level,
                                                    foundWords = current.found.keys.toList(),
                                                    elapsed = current.elapsed, hints = current.hintsUsed,
                                                ),
                                            )
                                        }
                                        nav.popBackStack()
                                    }
                                },
                                onNext = { nextCampaign(nav, level) },
                                onWin = { stars, seconds ->
                                    scope.launch {
                                        container.gameData.recordWin(lang, level, stars, seconds)
                                        container.gameData.clearSavedGame()
                                        container.gameData.addResult(
                                            StoredResult(
                                                mode = "MYSTERY", language = lang, difficulty = "",
                                                level = level, n = campaignLevel.boardSize, category = bankId,
                                                seconds = seconds, hints = vm.state.value.hintsUsed,
                                                stars = stars, score = 0, words = vm.state.value.found.size,
                                                finishedAt = System.currentTimeMillis(),
                                            ),
                                        )
                                    }
                                },
                                haptics = haptics,
                                letterScale = letterScale,
                                colorblind = colorblind,
                            sounds = container.sounds,
                            sound = sound,
                                bibleReference = campaignLevel.reference,
                                onReadBible = openBible,
                            )
                        } else {
                            val params = remember(level) { levelParams(info) }
                            val limit = remember(level) {
                                if (info.kind == LevelKind.TIMED) timedLimit(info.words, info.n) else null
                            }
                            val initial = savedInitial(saved, level)
                            val vm: GameViewModel = viewModel(
                                key = "camp-$level-$resume",
                                factory = GameViewModelFactory(
                                    campaignLevel.words, params, seed, Language.ES_FILL, assist, limit, initial,
                                ),
                            )
                            val isLast = level >= 300
                            GameScreen(
                                viewModel = vm,
                                title = worldName,
                                subtitle = subtitle,
                                winTitle = if (info.num == LEVELS_PER_WORLD) "¡Mundo ${info.world + 1} completado!" else "¡Nivel completado!",
                                winPrimaryLabel = when {
                                    isLast -> "Mapa"
                                    info.num == LEVELS_PER_WORLD -> "Siguiente mundo"
                                    else -> "Siguiente nivel"
                                },
                                winSecondaryLabel = "Mapa",
                                winExtraLine = "${campaignLevel.learningMessage}\n${campaignLevel.reference} · RV1909",
                                timeoutExitLabel = "Mapa",
                                tutorialTip = tip,
                                onTutorialAction = { dismissTip() },
                                onExit = {
                                    val current = vm.state.value
                                    scope.launch {
                                        if (!current.victory && current.found.isNotEmpty()) {
                                            container.gameData.saveGame(
                                                SavedGameData(
                                                    language = lang, level = level,
                                                    foundWords = current.found.keys.toList(),
                                                    elapsed = current.elapsed, hints = current.hintsUsed,
                                                ),
                                            )
                                        }
                                        nav.popBackStack()
                                    }
                                },
                                onNext = {
                                    if (isLast) nav.popBackStack() else nextCampaign(nav, level)
                                },
                                onWin = { stars, seconds ->
                                    scope.launch {
                                        container.gameData.recordWin(lang, level, stars, seconds)
                                        container.gameData.clearSavedGame()
                                        container.gameData.addResult(
                                            StoredResult(
                                                mode = "CAMPAIGN", language = lang, difficulty = "",
                                                level = level, n = info.n, category = bankId,
                                                seconds = seconds, hints = vm.state.value.hintsUsed,
                                                stars = stars, score = 0, words = info.words,
                                                finishedAt = System.currentTimeMillis(),
                                            ),
                                        )
                                    }
                                },
                                haptics = haptics,
                                letterScale = letterScale,
                                colorblind = colorblind,
                            sounds = container.sounds,
                            sound = sound,
                                bibleHint = campaignLevel.bibleHint,
                                bibleReference = campaignLevel.reference,
                                onReadBible = openBible,
                            )
                        }
                    }
                }
                }
            }
        }
    }

    private fun nextCampaign(nav: androidx.navigation.NavController, level: Int) {
        nav.navigate("gameCampaign/${level + 1}") {
            popUpTo("gameCampaign/$level") { inclusive = true }
        }
    }

    private fun savedInitial(saved: SavedGameData?, level: Int): SavedPlayState? {
        if (saved == null || saved.level != level) return null
        return SavedPlayState(foundWords = saved.foundWords, elapsed = saved.elapsed, hints = saved.hints)
    }

    private fun difficultyLabel(difficulty: Difficulty): String = when (difficulty) {
        Difficulty.EASY -> "Fácil"
        Difficulty.NORMAL -> "Normal"
        Difficulty.HARD -> "Difícil"
    }

    private fun tipKey(level: Int): String = "tip$level"

    private fun tutorialTip(level: Int, seen: Set<String>): String? {
        if (level != 1 && level != 3 && level != 11) return null
        if ("tip$level" in seen) return null
        return when (level) {
            1 -> "Desliza el dedo por las letras de una palabra."
            3 -> "Para aprender, toca Pista y descubre un pasaje bíblico."
            else -> "Lee la palabra completa antes de confirmar."
        }
    }
}
