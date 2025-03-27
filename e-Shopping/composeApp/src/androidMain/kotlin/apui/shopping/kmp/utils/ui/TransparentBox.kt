package apui.shopping.kmp.utils.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import apui.shopping.kmp.presentation.theme.appColor.leimartBlue
import apui.shopping.kmp.presentation.theme.appColor.leimartGray
import apui.shopping.kmp.presentation.theme.appColor.leimartGreen
import apui.shopping.kmp.presentation.theme.appColor.primary
import apui.shopping.kmp.presentation.theme.appColor.secondary

@Composable
fun TransparentBox(
    alpha: Float = 0.6f, content: @Composable () -> Unit,
) {
    /*Blur is GPU-accelerated, and there's a limit to how much blur can be applied efficiently.
    The blur() effect works on pixels, and beyond 25.dp - 30.dp, the difference becomes negligible.
    */
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .width(310.dp)
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(16.dp))
                .background(primary.copy(alpha = alpha))
                .blur(30.dp)
        )
        content()
    }
}