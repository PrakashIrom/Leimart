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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import apui.leimart.cmp.presentation.navigation.Destination
import apui.leimart.cmp.presentation.theme.appColor.primary
import e_shopping.composeapp.generated.resources.Res
import e_shopping.composeapp.generated.resources.home_page
import e_shopping.composeapp.generated.resources.search
import e_shopping.composeapp.generated.resources.user
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun LeimartBottomBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute =
        navBackStackEntry
            ?.destination
            ?.route
    println("Current Route: $currentRoute")

    if (currentRoute != Destination.Login.route && currentRoute != Destination.SignUp.route)
        BottomAppBar(
            backgroundColor = MaterialTheme.colors.background,
            contentPadding = PaddingValues(10.dp),
            elevation = 0.dp
        ) {
            /*SpaceBetween: Puts equal space between items (none at start/end)
              SpaceAround: Puts equal space around items (half at start/end)
              SpaceEvenly: Puts equal space everywhere (including start/end)*/
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalIconResourceBottom(Res.drawable.home_page, "Home")
                HorizontalIconResourceBottom(Res.drawable.search, "Notification")
                HorizontalIconResourceBottom(Res.drawable.user, "Ringing")
            }
        }
}

@Composable
fun HorizontalIconResourceBottom(resource: DrawableResource, contentDescription: String) {
    Icon(
        painter = painterResource(resource),
        contentDescription = contentDescription,
        modifier = Modifier.size(25.dp).clickable { },
        tint = primary,
    )
}