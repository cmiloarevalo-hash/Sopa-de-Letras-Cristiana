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
    bg = Color(0xFF83CCFA),
    surface = Color(0xFFFFF9EB),
    cell = Color(0xFFDCEBFC),
    text = Color(0xFF142446),
    mute = Color(0xFF385477),
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
    bg = Color(0xFF071935),
    surface = Color(0xFF163460),
    cell = Color(0xFF244775),
    text = Color(0xFFF2F7FF),
    mute = Color(0xFFC2D8F3),
    accent = Color(0xFFFFD66D),
    onAccent = Color(0xFF122444),
    found = listOf(
        Color(0xFF7AA2F7),
        Color(0xFFBB9AF7),
        Color(0xFF9ECE6A),
        Color(0xFFFF9E64),
        Color(0xFFF7768E),
    ),
)
