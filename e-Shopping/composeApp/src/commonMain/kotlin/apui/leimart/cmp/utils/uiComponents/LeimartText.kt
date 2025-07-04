package apui.leimart.cmp.utils.uiComponents

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import apui.leimart.cmp.presentation.theme.appColor.primary
// import apui.leimart.cmp.presentation.theme.font.bodyFontFamily

@Composable
fun LeimartText(
    text: String,
    // fontFamily: FontFamily = bodyFontFamily,
    fontWeight: FontWeight = FontWeight.W500,
    fontSize: TextUnit = TextUnit.Unspecified,
    color: Color = primary,
    modifier: Modifier = Modifier,
) {
    Text(
        text,
        // fontFamily = fontFamily,
        fontWeight = fontWeight,
        color = color,
        fontSize = fontSize,
        modifier = modifier,
    )
}
