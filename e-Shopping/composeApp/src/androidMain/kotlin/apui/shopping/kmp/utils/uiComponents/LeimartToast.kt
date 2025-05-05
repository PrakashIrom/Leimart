package apui.shopping.kmp.utils.uiComponents

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun LeimartToast(
    toastMessage: String,
    duration: Int = Toast.LENGTH_SHORT,
    context: Context,
) {
    Box(contentAlignment = Alignment.Center) {
        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
    }
}
