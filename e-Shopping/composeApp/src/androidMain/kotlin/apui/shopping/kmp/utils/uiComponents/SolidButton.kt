package apui.shopping.kmp.utils.uiComponents

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import apui.shopping.kmp.presentation.theme.appColor.secondary

@Composable
fun SolidButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = secondary),
    ) {
        LeimartText(
            text,
            fontSize = 17.sp,
        )
    }
}
