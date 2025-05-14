package apui.leimart.cmp.utils.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import e_shopping.composeapp.generated.resources.Res
import e_shopping.composeapp.generated.resources.home_page
import e_shopping.composeapp.generated.resources.notification_bell
import e_shopping.composeapp.generated.resources.ringing
import e_shopping.composeapp.generated.resources.show_password
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun LeimartBottomBar() {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.background,
        contentPadding = PaddingValues(10.dp),
        elevation = 10.dp,
    ) {
        /*SpaceBetween: Puts equal space between items (none at start/end)
          SpaceAround: Puts equal space around items (half at start/end)
          SpaceEvenly: Puts equal space everywhere (including start/end)*/
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalIconResource(Res.drawable.notification_bell, "Notification")
            HorizontalIconResource(Res.drawable.ringing, "Ringing")
            HorizontalIconResource(Res.drawable.home_page, "Home")
            HorizontalIconResource(Res.drawable.show_password, "Show Password")
        }
    }
}

@Composable
fun HorizontalIconResource(resource: DrawableResource, contentDescription: String) {
    Icon(
        painter = painterResource(resource),
        contentDescription = contentDescription,
        modifier = Modifier.size(30.dp).clickable { }
    )
}