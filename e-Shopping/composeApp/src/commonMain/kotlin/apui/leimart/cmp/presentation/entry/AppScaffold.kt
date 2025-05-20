package apui.leimart.cmp.presentation.entry

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import apui.leimart.cmp.presentation.navigation.AppNavHost
import apui.leimart.cmp.presentation.navigation.Destination
import apui.leimart.cmp.utils.uiComponents.LeimartBottomBar
import apui.leimart.cmp.utils.uiComponents.LeimartTopBar

@Composable
fun AppScaffold(navController: NavHostController) {
    Scaffold(
        topBar = { LeimartTopBar(navController) },
        bottomBar = { LeimartBottomBar(navController) },
    ) { paddingValues ->
        AppNavHost(
            navController = navController,
            startDestination = Destination.Home.route,
            paddingValues = paddingValues
        )
    }
}
