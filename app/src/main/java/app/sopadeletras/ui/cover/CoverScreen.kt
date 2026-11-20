package app.sopadeletras.ui.cover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.sopadeletras.ui.components.PrimaryButton
import app.sopadeletras.ui.theme.Bricolage
import app.sopadeletras.ui.theme.Figtree

/** Original Compose interpretation, not a copy of the private concept PNG. */
@Composable
fun CoverScreen(onStart: () -> Unit) {
    val colors = app.sopadeletras.ui.theme.LocalSopaColors.current
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Transparent)
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .padding(horizontal = 24.dp, vertical = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("✦ AVENTURA BÍBLICA ✦", fontFamily = Figtree,
                fontSize = 15.sp, color = colors.accent, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))
            Text("Sopa de letras\n-Biblia Rv-1909", fontFamily = Bricolage,
                fontWeight = FontWeight.ExtraBold, fontSize = 39.sp,
                color = colors.text, textAlign = TextAlign.Center, lineHeight = 42.sp)
            Spacer(Modifier.height(14.dp))
            Text("300 niveles · 10 mundos", fontFamily = Figtree,
                color = colors.text, fontSize = 17.sp)
        }
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(colors.surface, RoundedCornerShape(28.dp))
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text("🧭  🌿  📖", fontSize = 45.sp)
            Text("Explora las historias de la Biblia", fontFamily = Bricolage,
                fontSize = 23.sp, fontWeight = FontWeight.Bold,
                color = colors.text, textAlign = TextAlign.Center)
            Text("Jesús nos acompaña como guía de aprendizaje. Encuentra palabras, descubre y sigue tu camino.",
                fontFamily = Figtree, fontSize = 15.sp, color = colors.mute,
                textAlign = TextAlign.Center)
        }
        PrimaryButton(text = "Comenzar la aventura", onClick = onStart)
    }
}
