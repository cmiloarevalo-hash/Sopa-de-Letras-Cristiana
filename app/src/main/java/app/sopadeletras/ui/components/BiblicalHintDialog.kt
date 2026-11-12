package app.sopadeletras.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.sopadeletras.ui.theme.Bricolage
import app.sopadeletras.ui.theme.Figtree
import app.sopadeletras.ui.theme.LocalSopaColors

/** Leer una pista bíblica es gratuito. Solo iluminar una casilla consume una ayuda. */
@Composable
fun BiblicalHintDialog(
    clue: String,
    reference: String,
    remaining: Int,
    onRead: () -> Unit,
    onReveal: () -> Unit,
    onDismiss: () -> Unit,
) {
    val colors = LocalSopaColors.current
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Pista bíblica", fontFamily = Bricolage,
                fontWeight = FontWeight.Bold, fontSize = 22.sp, color = colors.text)
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(11.dp)) {
                Text(clue, fontFamily = Figtree, fontSize = 16.sp,
                    lineHeight = 22.sp, color = colors.text)
                Text("Encuentra el relato en:", fontFamily = Figtree,
                    fontSize = 13.sp, color = colors.mute)
                Text(reference, fontFamily = Bricolage,
                    fontWeight = FontWeight.Bold, fontSize = 15.sp, color = colors.accent)
                Text("Leer la Biblia no consume pistas ni quita estrellas.",
                    fontFamily = Figtree, fontSize = 13.sp, color = colors.mute)
            }
        },
        confirmButton = {
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Button(onClick = onRead, modifier = Modifier.fillMaxWidth()) {
                    Text("Leer en Biblia RV1909")
                }
                OutlinedButton(
                    onClick = onReveal, enabled = remaining > 0,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = colors.text, disabledContentColor = colors.mute),
                ) {
                    Text("Iluminar una casilla · quedan " + remaining)
                }
                TextButton(onClick = onDismiss, modifier = Modifier.fillMaxWidth()) {
                    Text("Seguir jugando")
                }
            }
        },
        containerColor = colors.surface,
    )
}

