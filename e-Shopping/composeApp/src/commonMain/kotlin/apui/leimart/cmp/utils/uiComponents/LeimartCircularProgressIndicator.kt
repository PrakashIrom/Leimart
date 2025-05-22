package apui.leimart.cmp.utils.uiComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import apui.leimart.cmp.presentation.theme.appColor.secondary

@Composable
fun LeimartCircularProgressIndicator() {
    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = secondary,
            strokeWidth = 6.dp,
            strokeCap = StrokeCap.Round,
            modifier =
                Modifier
                    .align(Alignment.Center)
                    .matchParentSize(),
        )
    }
}
