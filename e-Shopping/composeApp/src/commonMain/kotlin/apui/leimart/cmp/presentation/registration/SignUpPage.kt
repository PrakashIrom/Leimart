package apui.leimart.cmp.presentation.registration

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavHostController

@Composable
fun SignUpPage(navController: NavHostController) {
    val focusManager = LocalFocusManager.current
    Box(
        modifier =
            Modifier
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                ) {
                    focusManager.clearFocus()
                }.fillMaxHeight(),
        contentAlignment = Alignment.Center,
    ) {
        /*Image(
            painter = painterResource(Res.drawable.background_image),
            contentDescription = "Background Image",
            modifier =
                Modifier
                    .fillMaxSize()
                    .graphicsLayer { alpha = 0.6f },
            contentScale = ContentScale.Crop,
        )*/
        // TransparentBox(alpha = 0.05f) {
        SignUpPageContent(navController = navController) // }
    }
}
