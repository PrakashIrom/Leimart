package apui.leimart.cmp.utils.uiComponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import apui.leimart.cmp.presentation.theme.appColor.primary
import apui.leimart.cmp.presentation.theme.typography.GetBodyResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource

@Composable
fun LeimartText(
    text: String,
    fontResource: FontResource = GetBodyResource.regularInter,
    fontWeight: FontWeight = FontWeight.W500,
    fontSize: TextUnit = TextUnit.Unspecified,
    color: Color = primary,
    modifier: Modifier = Modifier,
) {
    Text(
        text,
        fontFamily = FontFamily(Font(fontResource)),
        fontWeight = fontWeight,
        color = color,
        fontSize = fontSize,
        modifier = modifier,
    )
}
