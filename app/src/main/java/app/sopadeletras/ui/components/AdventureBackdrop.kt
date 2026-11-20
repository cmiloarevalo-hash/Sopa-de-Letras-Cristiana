package app.sopadeletras.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import app.sopadeletras.ui.theme.LocalSopaColors
import app.sopadeletras.ui.theme.TokyoNight
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

/**
 * Lightweight screen-wide illustrated landscape for a children's Bible game.
 * Vector art: no internet, no GPS, no moving particles or image library.
 * System/manual dark mode switches the full scenery (sun <-> starry night).
 * Interactive puzzle cells remain opaque and retain their existing found colors.
 */
@Composable
fun AdventureBackdrop(modifier: Modifier = Modifier) {
    val night = LocalSopaColors.current.bg == TokyoNight.bg
    Canvas(modifier) {
        drawStorybookLandscape(night)
    }
}

private fun DrawScope.drawStorybookLandscape(night: Boolean) {
    val w = size.width
    val h = size.height
    if (w <= 1f || h <= 1f) return

    val sky = if (night)
        listOf(Color(0xFF06132E), Color(0xFF112D71), Color(0xFF28549D))
    else
        listOf(Color(0xFF1675E1), Color(0xFF40B9F6), Color(0xFFACEBFF))

    drawRect(brush = Brush.verticalGradient(sky, startY = 0f, endY = h * 0.80f))

    if (night) {
        // Moon halo and crisp star field; different star radii add depth.
        val moon = Offset(w * .78f, h * .14f)
        drawCircle(
            Brush.radialGradient(
                listOf(Color(0x66FFF9C7), Color(0x00FFF9C7)),
                center = moon,
                radius = w * .23f,
            ),
            radius = w * .23f,
            center = moon,
        )
        drawCircle(Color(0xFFFFF1BD), radius = w * .067f, center = moon)
        drawCircle(Color(0xFF112653), radius = w * .062f, center = Offset(moon.x + w * .028f, moon.y - w * .019f))
        repeat(85) { i ->
            val fx = ((i * 67 + 19) % 101) / 101f
            val fy = ((i * 43 + 11) % 97) / 97f * .69f
            val r = if (i % 11 == 0) w * .0033f else w * .0015f
            drawCircle(
                Color.White.copy(alpha = if (i % 5 == 0) .97f else .64f),
                radius = r.coerceAtLeast(.65f),
                center = Offset(w * fx, h * fy),
            )
            if (i % 17 == 0) {
                val p = Offset(w * fx, h * fy)
                drawLine(Color(0xAAFFEEC6), Offset(p.x - r * 3, p.y), Offset(p.x + r * 3, p.y), strokeWidth = 1.6f)
                drawLine(Color(0xAAFFEEC6), Offset(p.x, p.y - r * 3), Offset(p.x, p.y + r * 3), strokeWidth = 1.6f)
            }
        }
    } else {
        val sun = Offset(w * .78f, h * .14f)
        drawCircle(
            brush = Brush.radialGradient(
                listOf(Color(0xAAFFF4A8), Color(0x00FFF4A8)),
                center = sun, radius = w * .29f
            ), radius = w * .29f, center = sun,
        )
        for (ray in 0 until 12) {
            val angle = (ray * 30f * PI / 180f).toFloat()
            val inner = w * .078f
            val outer = w * .112f
            drawLine(
                color = Color(0xFFEFFFA1),
                start = Offset(sun.x + cos(angle) * inner, sun.y + sin(angle) * inner),
                end = Offset(sun.x + cos(angle) * outer, sun.y + sin(angle) * outer),
                strokeWidth = (w * .008f).coerceAtLeast(2f),
            )
        }
        drawCircle(Color(0xFFFFEE65), radius = w * .061f, center = sun)
        // Big rounded clouds create a playful fairy-tale depth.
        for (i in 0 until 4) {
            val x = (i * 0.32f - .11f) * w
            val y = (.23f + (i % 3) * .105f) * h
            drawOval(Color.White.copy(alpha = .80f), topLeft = Offset(x, y),
                size = Size(w * .29f, h * .039f))
            drawCircle(Color.White.copy(alpha = .86f), radius = w * .048f, center = Offset(x + w * .11f, y + h * .005f))
            drawCircle(Color.White.copy(alpha = .79f), radius = w * .038f, center = Offset(x + w * .19f, y + h * .012f))
        }
    }

    // Far mountains, second mountain layer and green foot-hills.
    fun mountain(points: List<Pair<Float, Float>>, top: Color, bottom: Color) {
        val path = Path().apply {
            moveTo(points.first().first * w, points.first().second * h)
            for (i in 1 until points.size) {
                lineTo(points[i].first * w, points[i].second * h)
            }
            close()
        }
        drawPath(path, Brush.verticalGradient(listOf(top, bottom), startY = h * .47f, endY = h * .84f))
    }

    mountain(
        listOf(0f to .76f, .23f to .55f, .40f to .73f, .66f to .50f, 1f to .78f, 1f to 1f, 0f to 1f),
        top = if (night) Color(0xFF2856A5) else Color(0xFF91A4EA),
        bottom = if (night) Color(0xFF102B64) else Color(0xFF669BC5),
    )
    mountain(
        listOf(0f to .81f, .12f to .68f, .35f to .79f, .73f to .64f, 1f to .85f, 1f to 1f, 0f to 1f),
        top = if (night) Color(0xFF164786) else Color(0xFF53A5D4),
        bottom = if (night) Color(0xFF0B3058) else Color(0xFF4F9C92),
    )

    fun hill(y0: Float, bend: Float, upper: Color, lower: Color) {
        val path = Path().apply {
            moveTo(-w * .1f, h * y0)
            cubicTo(w * .2f, h * (y0 - bend), w * .57f, h * (y0 + bend), w * 1.1f, h * (y0 - bend * .6f))
            lineTo(w * 1.1f, h)
            lineTo(-w * .1f, h)
            close()
        }
        drawPath(path, Brush.verticalGradient(listOf(upper, lower), startY = h * y0, endY = h))
    }

    if (night) {
        hill(.76f, .047f, Color(0xFF1F896F), Color(0xFF064E62))
        hill(.87f, .044f, Color(0xFF1E755C), Color(0xFF07364B))
    } else {
        hill(.76f, .047f, Color(0xFF96DA4F), Color(0xFF39B861))
        hill(.87f, .044f, Color(0xFF5ACE42), Color(0xFF178F58))
    }

    // A winding path towards the mountains, with warm daytime / slate nighttime stones.
    val path = Path().apply {
        moveTo(w * .19f, h)
        cubicTo(w * .43f, h * .94f, w * .67f, h * .90f, w * .49f, h * .82f)
        cubicTo(w * .42f, h * .77f, w * .55f, h * .73f, w * .61f, h * .70f)
        lineTo(w * .655f, h * .70f)
        cubicTo(w * .58f, h * .76f, w * .54f, h * .79f, w * .64f, h * .83f)
        cubicTo(w * .81f, h * .94f, w * .52f, h * .98f, w * .41f, h)
        close()
    }
    drawPath(
        path,
        Brush.verticalGradient(
            if (night) listOf(Color(0xFF8194A4), Color(0xFF6F777E))
            else listOf(Color(0xFFFFDE94), Color(0xFFF0A95D)),
            startY = h * .72f, endY = h,
        ),
    )

    // Sparse decorative trees and flowers along lower edges.
    repeat(10) { index ->
        val x = w * (index + .22f) / 10.3f
        val y = h * (.78f + ((index * 7) % 11) * .013f)
        val radius = (w * .022f + w * (index % 3) * .005f)
        drawLine(
            if (night) Color(0xFF173C42) else Color(0xFF7F643F),
            start = Offset(x, y + radius), end = Offset(x, y - radius * .9f),
            strokeWidth = (w * .010f).coerceAtLeast(1.7f),
        )
        drawCircle(if (night) Color(0xFF177A70) else Color(0xFF32B95D),
            radius = radius, center = Offset(x, y - radius))
        drawCircle(if (night) Color(0xFF249A8E) else Color(0xFF63CF55),
            radius = radius * .62f, center = Offset(x - radius * .35f, y - radius * 1.3f))
    }

    repeat(24) { index ->
        val leftSide = index % 2 == 0
        val fx = if (leftSide) ((index * 17) % 30) / 100f
                 else .72f + ((index * 11) % 28) / 100f
        val fy = .86f + (index * 13 % 14) / 100f
        val center = Offset(w * fx, h * fy)
        val bloom = if (night) listOf(Color(0xFF9CE9F6), Color(0xFFCB8FEF), Color(0xFFFFD471))
                    else listOf(Color(0xFFFF57A3), Color(0xFF974AE7), Color(0xFFFFE969))
        drawCircle(bloom[index % bloom.size].copy(alpha = if (night) .77f else .99f),
            radius = (w * .0045f).coerceAtLeast(1.5f), center = center)
        drawCircle(Color(0xFFFFF2B1), radius = (w * .0019f).coerceAtLeast(.7f), center = center)
    }
}
