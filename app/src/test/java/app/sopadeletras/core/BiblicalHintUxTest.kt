package app.sopadeletras.core

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class BiblicalHintUxTest {
    @Test fun mysteryCardUsesDirectBibleLinkAndResponsiveSlots() {
        val source = File("src/main/java/app/sopadeletras/ui/game/MysteryScreen.kt")
            .readText(Charsets.UTF_8)
        assertTrue(source.contains(".clickable(role = Role.Button, onClick = onReadBible)"))
        assertTrue(source.contains("onReadBible = { viewModel.pause(); onReadBible(mysteryReference) }"))
        assertFalse(source.contains("Leer pista y Biblia RV1909"))
        assertTrue(source.contains("if (answerLength >= 8) 26.dp else 30.dp"))
        assertTrue(source.contains(".clickable(role = Role.Button) { onDismiss(); onReadBible() }"))
    }

    @Test fun verseReferenceIsAnActionNotJustYellowText() {
        val file = File("src/main/java/app/sopadeletras/ui/components/BiblicalHintDialog.kt")
        val source = file.readText(Charsets.UTF_8)
        assertTrue("Reference needs an accessible clickable action", source.contains(".clickable(role = Role.Button, onClick = onRead)"))
        assertTrue("Show the exact requested action next to the reference", source.contains("Leer la Biblia"))
        assertTrue("Reference must be visible and underlined", source.contains("textDecoration = TextDecoration.Underline"))
        assertFalse("Do not narrate the illuminated cell", source.contains("Ya iluminamos una casilla"))
        assertFalse("Do not add unnecessary scoring explanations", source.contains("no consume pistas ni quita estrellas"))
        assertFalse("One compact verse action replaces the extra Bible button", source.contains("Leer en Biblia RV1909"))
    }
}
