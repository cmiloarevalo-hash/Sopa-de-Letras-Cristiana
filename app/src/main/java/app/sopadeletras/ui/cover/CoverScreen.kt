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
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Brush.verticalGradient(listOf(
                Color(0xFF142446), Color(0xFF3477B8), Color(0xFFB8EDF2),
            )))
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .padding(horizontal = 24.dp, vertical = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("✦ AVENTURA BÍBLICA ✦", fontFamily = Figtree,
                fontSize = 15.sp, color = Color(0xFFF2C45B), fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))
            Text("Sopa de Letras\nCristiana", fontFamily = Bricolage,
                fontWeight = FontWeight.ExtraBold, fontSize = 39.sp,
                color = Color.White, textAlign = TextAlign.Center, lineHeight = 42.sp)
            Spacer(Modifier.height(14.dp))
            Text("300 niveles · 10 mundos", fontFamily = Figtree,
                color = Color.White, fontSize = 17.sp)
        }
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(Color(0xFFF8F6EE), RoundedCornerShape(28.dp))
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text("🧭  🌿  📖", fontSize = 45.sp)
            Text("Explora las historias de la Biblia", fontFamily = Bricolage,
                fontSize = 23.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF142446), textAlign = TextAlign.Center)
            Text("Jesús nos acompaña como guía de aprendizaje. Encuentra palabras, descubre y sigue tu camino.",
                fontFamily = Figtree, fontSize = 15.sp, color = Color(0xFF405878),
                textAlign = TextAlign.Center)
        }
        PrimaryButton(text = "Comenzar la aventura", onClick = onStart)
    }
}
