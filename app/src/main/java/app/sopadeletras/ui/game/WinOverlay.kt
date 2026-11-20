package app.sopadeletras.ui.game

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.sopadeletras.ui.components.PrimaryButton
import app.sopadeletras.ui.components.SecondaryButton
import app.sopadeletras.ui.theme.Bricolage
import app.sopadeletras.ui.theme.Figtree
import app.sopadeletras.ui.theme.LocalSopaColors

/** Three BIG animated gold stars, visible even on narrow phones. */
@Composable
fun StarsRow(stars: Int, modifier: Modifier = Modifier) {
    val scales = remember(stars) { List(3) { Animatable(0f) } }
    LaunchedEffect(stars) {
        scales.forEach { anim ->
            anim.animateTo(1f, spring(dampingRatio = .52f, stiffness = Spring.StiffnessLow))
        }
    }
    Row(
        horizontalArrangement = Arrangement.spacedBy(3.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        repeat(3) { index ->
            val achieved = index < stars
            Box(contentAlignment = Alignment.Center, modifier = Modifier.size(71.dp)) {
                if (achieved) {
                    Text(
                        "✦",
                        fontSize = 38.sp,
                        color = Color(0x99FFF2A4),
                        modifier = Modifier.graphicsLayer {
                            scaleX = scales[index].value * 1.65f
                            scaleY = scales[index].value * 1.65f
                        },
                    )
                }
                Text(
                    "★",
                    fontFamily = Bricolage,
                    fontSize = 60.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (achieved) Color(0xFFFFD54D) else Color(0xFFAFB7C7),
                    style = TextStyle(
                        shadow = Shadow(
                            color = if (achieved) Color(0xDDF09000) else Color(0x660B1E39),
                            offset = Offset(0f, 5f),
                            blurRadius = if (achieved) 13f else 4f,
                        ),
                    ),
                    modifier = Modifier.graphicsLayer {
                        scaleX = scales[index].value
                        scaleY = scales[index].value
                    },
                )
            }
        }
    }
}

/** A small static celebration layer, no extra permissions, videos or looping animation. */
@Composable
private fun VictoryConfetti(modifier: Modifier = Modifier) {
    Canvas(modifier) {
        val tones = listOf(
            Color(0xFFFFDE64), Color(0xFF6DE4E4), Color(0xFFFF8AB9),
            Color(0xFFBC9AFF), Color(0xFF96E48B),
        )
        repeat(85) { i ->
            val x = ((i * 37 + 9) % 101) / 101f * size.width
            val y = ((i * 53 + 19) % 109) / 109f * size.height
            // Leave room for the center card; confetti around its edges.
            if (x > size.width * .17f && x < size.width * .83f &&
                y > size.height * .24f && y < size.height * .78f) return@repeat
            val color = tones[i % tones.size].copy(alpha = .80f)
            if (i % 3 == 0) {
                drawLine(
                    color = color, start = Offset(x - 3f, y - 5f),
                    end = Offset(x + 3f, y + 5f), strokeWidth = 4f,
                )
            } else {
                drawCircle(color, radius = (size.width * .006f).coerceAtLeast(2f), center = Offset(x, y))
            }
        }
        // Two large firework rings in the upper corners.
        drawCircle(Color(0x88FFE58B), radius = size.width * .115f,
            center = Offset(size.width * .04f, size.height * .16f),
            style = Stroke(width = 3f))
        drawCircle(Color(0x88A3DDFF), radius = size.width * .095f,
            center = Offset(size.width * .94f, size.height * .24f),
            style = Stroke(width = 3f))
    }
}

@Composable
fun WinOverlay(
    title: String,
    stars: Int,
    summary: String,
    primaryLabel: String,
    onPrimary: () -> Unit,
    secondaryLabel: String?,
    onSecondary: () -> Unit,
    modifier: Modifier = Modifier,
    extraLine: String? = null,
    extraContent: (@Composable () -> Unit)? = null,
) {
    val colors = LocalSopaColors.current
    val completed = stars > 0
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xD5122347))
            .padding(horizontal = 17.dp),
        contentAlignment = Alignment.Center,
    ) {
        if (completed) VictoryConfetti(Modifier.fillMaxSize())
        Column(
            verticalArrangement = Arrangement.spacedBy(13.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(
                            if (completed) Color(0xFFFFF0B0) else colors.surface,
                            if (completed) Color(0xFFFFF9E5) else colors.surface,
                        ),
                    ),
                )
                .border(3.dp, if (completed) Color(0xFFFFD35A) else colors.cell, RoundedCornerShape(30.dp))
                .padding(horizontal = 13.dp, vertical = 24.dp),
        ) {
            if (completed) {
                Text(
                    "✨ ¡MISIÓN CUMPLIDA! ✨",
                    fontFamily = Figtree,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF9B4E16),
                    textAlign = TextAlign.Center,
                )
            }
            Text(
                text = title,
                fontFamily = Bricolage,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                lineHeight = 34.sp,
                textAlign = TextAlign.Center,
                color = if (completed) Color(0xFF17315B) else colors.text,
            )
            if (completed) {
                StarsRow(stars)
            }
            Text(
                text = summary,
                fontFamily = Figtree,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (completed) Color(0xFF294464) else colors.text,
                textAlign = TextAlign.Center,
            )
            extraContent?.invoke()
            if (extraLine != null) {
                Text(
                    text = extraLine,
                    fontFamily = Figtree,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Center,
                    color = if (completed) Color(0xFF294464) else colors.text,
                )
            }
            PrimaryButton(text = primaryLabel, onClick = onPrimary)
            if (secondaryLabel != null) {
                SecondaryButton(text = secondaryLabel, onClick = onSecondary)
            }
        }
    }
}
