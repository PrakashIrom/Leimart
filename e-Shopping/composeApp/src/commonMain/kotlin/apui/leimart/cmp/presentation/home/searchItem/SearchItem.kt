package apui.leimart.cmp.presentation.home.searchItem

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import apui.leimart.cmp.presentation.theme.appColor.leimartGray
import apui.leimart.cmp.presentation.theme.appColor.primary
import apui.leimart.cmp.presentation.theme.appColor.secondary
import apui.leimart.cmp.utils.uiComponents.LeimartTextField
import e_shopping.composeapp.generated.resources.Res
import e_shopping.composeapp.generated.resources.search
import org.jetbrains.compose.resources.painterResource

@Composable
fun SearchItem() {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value

    LeimartTextField(
        onValueChange = {}, label = "Search", value = "", modifier =
            Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
        shape = RoundedCornerShape(25.dp),
        trailingIcon = {
            Icon(
                painter = painterResource(Res.drawable.search),
                contentDescription = "Search",
                tint = if (isFocused) primary else secondary,
                modifier = Modifier.size(18.dp)
            )
        },
        interactionSource = interactionSource,
        unfocusedBorderColor = secondary
    )
    Spacer(modifier = Modifier.height(10.dp))
}