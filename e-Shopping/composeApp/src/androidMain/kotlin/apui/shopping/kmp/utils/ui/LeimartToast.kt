package apui.shopping.kmp.utils.ui

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun LeimartToast(
    toastMessage: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    val context = LocalContext.current
    Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()

}