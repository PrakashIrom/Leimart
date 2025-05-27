package apui.leimart.cmp.utils.uiComponents

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import apui.leimart.cmp.presentation.theme.appColor.primary
import apui.leimart.cmp.presentation.theme.appColor.secondary
import apui.leimart.cmp.presentation.theme.typography.GetBodyResource
import org.jetbrains.compose.resources.FontResource

@Composable
fun SolidButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier,
    fontResource: FontResource = GetBodyResource.regularInter,
    fontSize: TextUnit = 18.sp,
    buttonColor: Color = primary,
    textColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(buttonColor),
    ) {
        LeimartText(
            fontResource = fontResource,
            text = text,
            fontSize = fontSize,
            color = textColor
        )
    }
}
