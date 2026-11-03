package app.sopadeletras.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class SopaColors(
    val bg: Color,
    val surface: Color,
    val cell: Color,
    val text: Color,
    val mute: Color,
    val accent: Color,
    val onAccent: Color,
    val found: List<Color>,
)

val TintaAmbar = SopaColors(
    // Aventura Bíblica Moderna: marfil, azul, violeta, turquesa y dorado.
    bg = Color(0xFFE6F3FC),
    surface = Color(0xFFF8F6EE),
    cell = Color(0xFFCFDFEE),
    text = Color(0xFF142446),
    mute = Color(0xFF405878),
    accent = Color(0xFFF2C45B),
    onAccent = Color(0xFF142446),
    found = listOf(
        Color(0xFFF2C45B),
        Color(0xFF35BFC3),
        Color(0xFFA99BEF),
        Color(0xFF9CDAA2),
        Color(0xFFF4AAC4),
    ),
)

val TokyoNight = SopaColors(
    bg = Color(0xFF1A1B26),
    surface = Color(0xFF24283B),
    cell = Color(0xFF292E42),
    text = Color(0xFFC0CAF5),
    mute = Color(0xFF7982B4),
    accent = Color(0xFF7AA2F7),
    onAccent = Color(0xFF16161E),
    found = listOf(
        Color(0xFF7AA2F7),
        Color(0xFFBB9AF7),
        Color(0xFF9ECE6A),
        Color(0xFFFF9E64),
        Color(0xFFF7768E),
    ),
)
