package apui.leimart.cmp.utils.uiComponents

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import apui.leimart.cmp.presentation.theme.appColor.secondary
import apui.leimart.cmp.presentation.theme.typography.GetBodyResource

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
            fontResource = GetBodyResource.blackInter,
            text = text,
            fontSize = 18.sp,
        )
    }
}
