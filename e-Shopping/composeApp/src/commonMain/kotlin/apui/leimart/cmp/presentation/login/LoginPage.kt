package apui.leimart.cmp.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavHostController
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LoginPage(
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
                    focusManager.clearFocus() // Clear focus when tapping outside
                },
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
        /*TransparentBox(alpha = 0.05f) { */LoginContent(navController = navController) //}
    }
}

@Preview
@Composable
fun ShowLoginPage() {
    MaterialTheme {
        // LoginPage(Modifier.fillMaxSize(), NavHostController(LocalContext.current))
    }
}
