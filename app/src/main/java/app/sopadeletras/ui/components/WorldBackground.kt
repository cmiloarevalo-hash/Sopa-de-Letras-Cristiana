package app.sopadeletras.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import app.sopadeletras.R

/**
 * Ten ultra-light scenic world images. Decorative only: the board and dialogs
 * remain on solid panels with their existing high-contrast colors.
 */
@Composable
fun WorldBackground(worldIndex: Int, modifier: Modifier = Modifier, alpha: Float = 0.24f) {
    val imageId = when (worldIndex.coerceIn(0, 9)) {
        0 -> R.drawable.world_01
        1 -> R.drawable.world_02
        2 -> R.drawable.world_03
        3 -> R.drawable.world_04
        4 -> R.drawable.world_05
        5 -> R.drawable.world_06
        6 -> R.drawable.world_07
        7 -> R.drawable.world_08
        8 -> R.drawable.world_09
        else -> R.drawable.world_10
    }
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.alpha(alpha),
    )
}

