package apui.leimart.cmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import apui.leimart.cmp.presentation.navigation.AppNavHost
import apui.leimart.cmp.presentation.navigation.Destination

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                AppNavHost(
                    navController = navController,
                    startDestination = Destination.SignUp.route,
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}
