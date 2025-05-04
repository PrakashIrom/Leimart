package apui.shopping.kmp.presentation.navigation

sealed class Destination(val route: String) {
    data object Login : Destination(Screens.LOGIN.name)
    data object SignUp : Destination(Screens.SIGN_UP.name)
}