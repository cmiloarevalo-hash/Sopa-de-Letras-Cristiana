package app.sopadeletras.core

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/** Guard the child-friendly visual requirements without changing the puzzle algorithm. */
class StorybookUxTest {
    private fun code(path: String) =
        File("src/main/java/app/sopadeletras/$path").readText(Charsets.UTF_8)

    @Test fun storybookBackgroundHasRealDayAndNightScenery() {
        val source = code("ui/components/AdventureBackdrop.kt")
        for (token in listOf("moon", "sun", "repeat(85)", "mountain(", "hill(", "path", "drawCircle")) {
            assertTrue("Missing storybook feature: $token", source.contains(token))
        }
        assertTrue(source.contains("val night = LocalSopaColors.current.bg == TokyoNight.bg"))
    }

    @Test fun allScreensUseTheLandscapeInsteadOfOpaqueBase() {
        val activity = code("MainActivity.kt")
        assertTrue(activity.contains("AdventureBackdrop(modifier = androidx.compose.ui.Modifier.fillMaxSize())"))
        assertTrue(activity.contains("theme == \"AUTO\" && isSystemInDarkTheme()"))
        for (screen in listOf(
            "cover/CoverScreen.kt", "home/HomeScreen.kt", "campaign/CampaignScreen.kt", "settings/SettingsScreen.kt",
            "setup/NewGameScreen.kt", "bible/BibleScreen.kt", "album/AlbumScreen.kt", "stats/StatsScreen.kt"
        )) {
            val source = code("ui/$screen")
            assertTrue("$screen hides the landscape", source.contains(".background(androidx.compose.ui.graphics.Color.Transparent)"))
        }
    }

    @Test fun starsAreBigAndTheGameSelectionPaletteIsPreserved() {
        val source = code("ui/game/WinOverlay.kt")
        assertTrue(source.contains("fontSize = 60.sp"))
        assertTrue(source.contains("VictoryConfetti"))
        assertTrue(source.contains("¡MISIÓN CUMPLIDA!"))
        val colors = code("ui/theme/Color.kt")
        for (originalColor in listOf("0xFFF2C45B", "0xFF35BFC3", "0xFFA99BEF", "0xFF9CDAA2", "0xFFF4AAC4")) {
            assertTrue("Selection palette changed: $originalColor", colors.contains(originalColor))
        }
        assertTrue(code("ui/game/MysteryScreen.kt").contains("WinOverlay("))
        assertFalse(code("ui/game/MysteryScreen.kt").contains("StarsRow(stars = stars)"))
    }

    @Test fun autoThemeIsSupportedInSettingsAndPersisted() {
        val store = code("data/SettingsStore.kt")
        val settings = code("ui/settings/SettingsScreen.kt")
        assertTrue(store.contains("?: \"AUTO\""))
        assertTrue(settings.contains("Seguir el modo día/noche del teléfono"))
        assertTrue(settings.contains("Noche estrellada"))
        assertTrue(settings.contains("Día soleado"))
    }
}
