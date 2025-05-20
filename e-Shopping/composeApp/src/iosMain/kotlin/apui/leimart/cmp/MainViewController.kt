package apui.leimart.cmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import androidx.navigation.compose.rememberNavController
import apui.leimart.cmp.presentation.entry.AppScaffold
import apui.leimart.cmp.presentation.navigation.Destination

fun MainViewController() =
    ComposeUIViewController {
        val navController = rememberNavController()
        AppScaffold(
            navController = navController,
        )
    }
