package apui.leimart.cmp.presentation.home.horizontalPager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import apui.leimart.cmp.presentation.theme.appColor.leimartGray
import apui.leimart.cmp.presentation.theme.appColor.primary

@Composable
fun PageIndicator(pageCount: Int, currentPageIndex: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { iteration ->
            val color = if (currentPageIndex == iteration) primary else Color.LightGray
            Box(
                modifier = modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp)
            )
        }
    }
}