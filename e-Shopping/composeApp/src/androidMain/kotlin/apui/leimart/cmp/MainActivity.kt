package apui.leimart.cmp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.MaterialTheme
import androidx.navigation.compose.rememberNavController
import apui.leimart.cmp.presentation.entry.AppScaffold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Needs to implement this separately for IOS
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.auto(Color.TRANSPARENT, Color.TRANSPARENT))
        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                AppScaffold(
                    navController = navController,
                )
            }
        }
    }
}
