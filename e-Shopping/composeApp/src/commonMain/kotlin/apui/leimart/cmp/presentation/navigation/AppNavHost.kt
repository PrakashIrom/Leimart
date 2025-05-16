package apui.leimart.cmp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import apui.leimart.cmp.presentation.home.HomePage
import apui.leimart.cmp.presentation.home.horizontalPager.pagerItems
import apui.leimart.cmp.presentation.login.LoginPage
import apui.leimart.cmp.presentation.registration.SignUpPage

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Destination.Login.route) {
            LoginPage(Modifier.fillMaxSize(), navController)
        }
        composable(Destination.SignUp.route) {
            SignUpPage(navController)
        }
        composable(Destination.Home.route) {
            HomePage(pageItems = pagerItems)
        }
    }
}
