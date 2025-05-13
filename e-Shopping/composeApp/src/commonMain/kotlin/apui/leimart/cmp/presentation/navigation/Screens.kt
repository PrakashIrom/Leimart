package apui.leimart.cmp.presentation.navigation

import e_shopping.composeapp.generated.resources.Res
import e_shopping.composeapp.generated.resources.home
import e_shopping.composeapp.generated.resources.login
import e_shopping.composeapp.generated.resources.sign_up
import org.jetbrains.compose.resources.StringResource

enum class Screens(
    val title: StringResource = Res.string.home,
) {
    LOGIN(Res.string.login),
    SIGN_UP(Res.string.sign_up),
}
