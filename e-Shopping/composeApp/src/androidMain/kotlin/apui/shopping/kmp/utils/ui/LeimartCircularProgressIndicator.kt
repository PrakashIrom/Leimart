package apui.shopping.kmp.utils.ui

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import apui.shopping.kmp.presentation.theme.appColor.leimartBlue

@Composable
fun LeimartCircularProgressIndicator() {
    CircularProgressIndicator(
        color = leimartBlue,
        strokeWidth = 12.dp,
        strokeCap = StrokeCap.Butt
    )
}