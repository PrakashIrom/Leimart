package apui.leimart.cmp.utils.uiComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import apui.leimart.cmp.presentation.navigation.Screens
import e_shopping.composeapp.generated.resources.Res
import e_shopping.composeapp.generated.resources.home
import org.jetbrains.compose.resources.stringResource

@Composable
fun LeimartTopBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute =
        navBackStackEntry
            ?.destination
            ?.route
    val screenTitle = Screens.entries.find { it.name == currentRoute }?.title ?: Res.string.home

    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        title = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 26.dp),
            ) { LeimartText(stringResource(screenTitle)) }
        },
        elevation = 0.dp,
        modifier = Modifier.height(80.dp),
    )
}
