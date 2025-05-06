package apui.shopping.kmp.utils.uiComponents

import android.content.Context
import android.widget.Toast

fun LeimartToast(
    toastMessage: String,
    duration: Int = Toast.LENGTH_SHORT,
    context: Context,
) {
    Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
}
