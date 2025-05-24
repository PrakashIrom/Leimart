package apui.leimart.cmp.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import apui.leimart.cmp.presentation.home.horizontalPager.AutoHorizontalPager
import apui.leimart.cmp.presentation.home.horizontalPager.PageIndicator
import apui.leimart.cmp.presentation.home.sections.Sections

@Composable
fun HomePage(pageItems: List<String>, paddingValues: PaddingValues) {
    val loopedItems = remember { List(1000) { pageItems[it % pageItems.size] } }
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { loopedItems.size })

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(paddingValues),
        // verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            AutoHorizontalPager(
                pagerState = pagerState,
                modifier = Modifier.fillMaxWidth(),
                loopedItems = loopedItems
            )
        }
        item {
            PageIndicator(
                modifier = Modifier,
                pageCount = pageItems.size,
                currentPageIndex = pagerState.currentPage % pageItems.size
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        item{
            Sections()
        }
    }
}