package apui.leimart.cmp.utils.uiComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import apui.leimart.cmp.presentation.navigation.Screens
import apui.leimart.cmp.presentation.theme.appColor.primary
import apui.leimart.cmp.presentation.theme.typography.GetHeaderResource
import e_shopping.composeapp.generated.resources.Res
import e_shopping.composeapp.generated.resources.home
import e_shopping.composeapp.generated.resources.home_page
import e_shopping.composeapp.generated.resources.notification_bell
import e_shopping.composeapp.generated.resources.ringing
import e_shopping.composeapp.generated.resources.shopping_bag
import e_shopping.composeapp.generated.resources.show_password
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LeimartTopBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute =
        navBackStackEntry
            ?.destination
            ?.route
    val screenTitle = Screens.entries.find { it.name == currentRoute }?.title ?: Res.string.home

    TopAppBar(
        navigationIcon = {
            /*Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {*/
                LeimartText(
                    stringResource(screenTitle),
                    fontResource = GetHeaderResource.playfairDisplaySemiBoldItalic,
                    fontSize = 20.sp
                )
           /* }*/
        },
        backgroundColor = MaterialTheme.colors.background,
        title = {

        },
        actions = {

            HorizontalIconResourceTop(Res.drawable.notification_bell, "Notification")
            HorizontalIconResourceTop(Res.drawable.shopping_bag, "Shopping bag")
        },
        elevation = 0.dp,
        modifier = Modifier.height(80.dp).padding(top = 26.dp, start = 16.dp),
    )
}

@Composable
fun HorizontalIconResourceTop(resource: DrawableResource, contentDescription: String) {
    Icon(
        painter = painterResource(resource),
        contentDescription = contentDescription,
        modifier = Modifier.size(24.dp).clickable { },
        tint = primary
    )
    Spacer(modifier = Modifier.width(16.dp))
}
