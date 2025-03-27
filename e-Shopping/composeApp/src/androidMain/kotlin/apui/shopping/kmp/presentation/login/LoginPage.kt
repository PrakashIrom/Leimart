package apui.shopping.kmp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import apui.shopping.kmp.R
import apui.shopping.kmp.utils.ui.TransparentBox

@Composable
fun LoginPage(modifier: Modifier) {
    val focusManager = LocalFocusManager.current
    Box(
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                focusManager.clearFocus() // Clear focus when tapping outside
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.background_image),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer { alpha = 0.6f },
            contentScale = ContentScale.Crop
        )
        TransparentBox(alpha = 0.05f) { LoginContent() }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowLoginPage() {
    MaterialTheme {
        LoginPage(Modifier.fillMaxSize())
    }
}