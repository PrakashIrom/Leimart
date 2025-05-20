package apui.leimart.cmp.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import apui.leimart.cmp.presentation.home.horizontalPager.AutoHorizontalPager
import apui.leimart.cmp.presentation.home.horizontalPager.PageIndicator
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun HomePage(pageItems: List<String>) {
    val loopedItems = remember { List(1000) { pageItems[it % pageItems.size] } }
    val pagerState = rememberPagerState(initialPage = 500, pageCount = { loopedItems.size })
    /*Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().height(250.dp)
    ) {
        AutoHorizontalPager(
            pagerState = pagerState,
            modifier = Modifier.fillMaxWidth(),
            loopedItems = loopedItems
        )
        PageIndicator(
            modifier = Modifier.align(Alignment.BottomCenter),
            pageCount = pageItems.size,
            currentPageIndex = pagerState.currentPage % pageItems.size
        )
    }*/

    Column(modifier = Modifier.fillMaxSize(),
       // verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AutoHorizontalPager(
            pagerState = pagerState,
            modifier = Modifier.fillMaxWidth(),
            loopedItems = loopedItems
        )
        PageIndicator(
            modifier = Modifier,
            pageCount = pageItems.size,
            currentPageIndex = pagerState.currentPage % pageItems.size
        )
    }
}