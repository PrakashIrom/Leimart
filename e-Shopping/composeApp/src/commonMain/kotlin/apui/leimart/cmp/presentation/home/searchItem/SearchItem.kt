package apui.leimart.cmp.presentation.home.searchItem

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import apui.leimart.cmp.utils.uiComponents.LeimartTextField

@Composable
fun SearchItem() {
    LeimartTextField(
        onValueChange = {}, label = "", value = "", modifier =
            Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
    )
    Spacer(modifier = Modifier.height(10.dp))
}