package app.sopadeletras.ui.album

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.sopadeletras.AppContainer
import app.sopadeletras.core.Language
import app.sopadeletras.data.albumForProgress
import app.sopadeletras.data.badgesForProgress
import app.sopadeletras.ui.theme.LocalSopaColors
import kotlinx.coroutines.launch

@Composable
fun AlbumScreen(container: AppContainer, onBack: () -> Unit) {
    val colors = LocalSopaColors.current
    val progress by container.gameData.progressFlow(Language.ES_CODE).collectAsState(initial = emptyMap())
    val nickname by container.gameData.nicknameFlow.collectAsState(initial = "")
    var edited by remember(nickname) { mutableStateOf(nickname) }
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize().background(colors.bg)
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        Text("← Volver", modifier = Modifier.clickable { onBack() }, color = colors.accent)
        Text("Mi álbum bíblico", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = colors.text)
        Text("Descubrimientos, medallas y avance guardados en este dispositivo, sin conexión.", color = colors.mute)
        OutlinedTextField(
            value = edited,
            onValueChange = { edited = it.take(24) },
            label = { Text("Apodo opcional") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )
        Text("Usa un apodo, no tu nombre completo ni correo.", color = colors.mute, fontSize = 12.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(onClick = { scope.launch { container.gameData.saveNickname(edited) } }) {
                Text("Guardar apodo")
            }
            TextButton(onClick = { edited = ""; scope.launch { container.gameData.saveNickname("") } }) {
                Text("Borrar")
            }
        }
        Text("Insignias", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = colors.text)
        badgesForProgress(progress).forEach { badge ->
            Text(
                (if (badge.earned) "★ " else "☆ ") + badge.name,
                color = if (badge.earned) colors.accent else colors.mute,
            )
        }
        Text("Mundos y descubrimientos", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = colors.text)
        albumForProgress(progress).forEach { item ->
            Column(
                modifier = Modifier.fillMaxWidth()
                    .background(colors.surface, RoundedCornerShape(18.dp))
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Text("Mundo ${item.world} · ${item.title}",
                    fontWeight = FontWeight.Bold, color = colors.text)
                if (item.unlocked) {
                    Text(item.description, color = colors.text)
                    Text("Referencia: ${item.reference} · RV1909", color = colors.mute)
                } else {
                    Text("Completa los 30 niveles del mundo para descubrir esta ficha.", color = colors.mute)
                }
            }
        }
    }
}
