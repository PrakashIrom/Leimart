package apui.leimart.cmp.presentation.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import apui.leimart.cmp.domain.model.pagerItems
import apui.leimart.cmp.presentation.home.HomePage
import apui.leimart.cmp.presentation.login.LoginPage
import apui.leimart.cmp.presentation.registration.SignUpPage

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String,
    paddingValues: PaddingValues,
) {

    val focus = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                focus.clearFocus()
            }) {
        NavHost(navController = navController, startDestination = startDestination) {
            composable(Destination.Login.route) {
                LoginPage(Modifier.fillMaxSize(), navController)
            }
            composable(Destination.SignUp.route) {
                SignUpPage(navController)
            }
            composable(Destination.Home.route) {
                HomePage(pageItems = pagerItems, paddingValues)
            }
        }
    }
}
