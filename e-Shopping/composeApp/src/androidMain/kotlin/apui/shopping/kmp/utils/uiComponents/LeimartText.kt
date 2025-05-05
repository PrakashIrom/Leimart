package apui.shopping.kmp.utils.uiComponents

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import apui.shopping.kmp.presentation.theme.appColor.primary
import apui.shopping.kmp.presentation.theme.font.bodyFontFamily

@Composable
fun LeimartText(
    text: String,
    fontFamily: FontFamily = bodyFontFamily,
    fontWeight: FontWeight = FontWeight.W500,
    fontSize: TextUnit = TextUnit.Unspecified,
    color: Color = primary,
    modifier: Modifier = Modifier,
) {
    Text(
        text,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        color = color,
        fontSize = fontSize,
        modifier = modifier,
    )
}
