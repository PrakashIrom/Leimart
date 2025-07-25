package apui.leimart.cmp.presentation.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavHostController
import apui.leimart.cmp.utils.uiComponents.TransparentBox
import e_shopping.composeapp.generated.resources.Res
import e_shopping.composeapp.generated.resources.background_image
import org.jetbrains.compose.resources.painterResource

@Composable
fun SignUpPage(
    modifier: Modifier,
    navController: NavHostController,
) {
    val focusManager = LocalFocusManager.current
    Box(
        modifier =
            modifier
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                ) {
                    focusManager.clearFocus()
                },
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(Res.drawable.background_image),
            contentDescription = "Background Image",
            modifier =
                Modifier
                    .fillMaxSize()
                    .graphicsLayer { alpha = 0.6f },
            contentScale = ContentScale.Crop,
        )
        TransparentBox(alpha = 0.05f) { SignUpPageContent(navController = navController) }
    }
}
