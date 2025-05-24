package apui.leimart.cmp.presentation.home.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import apui.leimart.cmp.domain.model.Section
import apui.leimart.cmp.domain.model.bestOffers
import apui.leimart.cmp.domain.model.bestSellers
import apui.leimart.cmp.domain.model.newArrivals
import apui.leimart.cmp.domain.model.topBrands
import apui.leimart.cmp.presentation.theme.typography.GetBodyResource
import apui.leimart.cmp.utils.uiComponents.LeimartText

@Composable
fun Sections() {
    Column(modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 10.dp)) {
        VerticalValues("Best Offers", bestOffers)
        Spacer(modifier = Modifier.height(15.dp))
        VerticalValues("Best Sellers", bestSellers)
        Spacer(modifier = Modifier.height(15.dp))
        VerticalValues("New Arrivals", newArrivals)
        Spacer(modifier = Modifier.height(15.dp))
        VerticalValues("Top Brands", topBrands)
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
fun VerticalValues(title: String, items: List<Section>) {
    Column {
        LeimartText(title, fontResource = GetBodyResource.extraBoldItalicInter, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(3.dp))
        HorizontalItems(items)
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Composable
fun HorizontalItems(items: List<Section>) {
    LazyRow  {
        items(items.size) {
            HorizontalItem(items[it])
        }
    }
}