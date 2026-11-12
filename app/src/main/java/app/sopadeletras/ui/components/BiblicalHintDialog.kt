package app.sopadeletras.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.sopadeletras.ui.theme.Bricolage
import app.sopadeletras.ui.theme.Figtree
import app.sopadeletras.ui.theme.LocalSopaColors
import app.sopadeletras.ui.theme.TokyoNight

/** A short biblical clue: the highlighted verse reference is the Bible action. */
@Composable
fun BiblicalHintDialog(
    clue: String,
    reference: String,
    onRead: () -> Unit,
    onDismiss: () -> Unit,
) {
    val colors = LocalSopaColors.current
    // Amber that stays readable against ivory. Preserve the existing board/highlight palette.
    val verseLinkColor = if (colors.bg == TokyoNight.bg) colors.accent else Color(0xFF94600C)
    val shortClue = clue
        .removePrefix("En la RV1909, completa la expresión de este pasaje: ")
        .removePrefix("En la RV1909, completa la palabra de este pasaje: ")
        .trim()
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                "Pista bíblica",
                fontFamily = Bricolage,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = colors.text,
            )
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                Text(
                    shortClue,
                    fontFamily = Figtree,
                    fontSize = 15.sp,
                    lineHeight = 21.sp,
                    color = colors.text,
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(colors.cell.copy(alpha = 0.42f))
                        .clickable(role = Role.Button, onClick = onRead)
                        .padding(horizontal = 10.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Text(
                        reference,
                        modifier = Modifier.weight(1f),
                        fontFamily = Bricolage,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = verseLinkColor,
                        textDecoration = TextDecoration.Underline,
                    )
                    Text(
                        "Leer la Biblia",
                        fontFamily = Figtree,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.sp,
                        color = verseLinkColor,
                    )
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Seguir jugando", color = colors.text)
            }
        },
        containerColor = colors.surface,
    )
}
