package apui.leimart.cmp.presentation.home.horizontalPager

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AutoHorizontalPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    loopedItems: List<DrawableResource>
) {

    val pageInteractionSource = remember { MutableInteractionSource() }
    val pagerIsDragged = pageInteractionSource.collectIsDraggedAsState().value
    val pagerIsPressed = pageInteractionSource.collectIsPressedAsState().value
    //val autoSwipe = !pagerIsDragged && !pagerIsPressed

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)

            val isDragged = pagerIsDragged
            val isPressed = pagerIsPressed
            if (!isDragged && !isPressed) {
                val nextPage = pagerState.currentPage + 1
                pagerState.animateScrollToPage(
                    page = nextPage,
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = LinearEasing
                    )
                )
            }
        }
    }

    HorizontalPager(
        state = pagerState,
        //beyondViewportPageCount = 1
    ) { page ->
        HorizontalPagerItem(page, pageInteractionSource, loopedItems, modifier)
    }

}

@Composable
fun HorizontalPagerItem(
    page: Int,
    pageInteractionSource: MutableInteractionSource,
    pageItems: List<DrawableResource>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 5.dp)
            .size(height = 200.dp, width = 300.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Image(
            painter = painterResource(pageItems[page]),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = modifier.clickable(
                indication = LocalIndication.current,
                interactionSource = pageInteractionSource
            ) { }
        )
    }
}