package apui.shopping.kmp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import apui.shopping.kmp.presentation.login.LoginPage
import apui.shopping.kmp.presentation.registration.SignUpPage

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Destination.Login.route) {
            LoginPage(modifier = Modifier.fillMaxSize(), navController)
        }
        composable(Destination.SignUp.route) {
            SignUpPage(modifier = Modifier.fillMaxSize(), navController)
        }
    }
}