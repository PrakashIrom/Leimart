package apui.leimart.cmp.utils.uiComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import apui.leimart.cmp.presentation.theme.appColor.primary
import apui.leimart.cmp.presentation.theme.appColor.secondary
import apui.leimart.cmp.presentation.theme.typography.GetBodyResource
import org.jetbrains.compose.resources.FontResource

@Composable
fun LeimartTextField(
    fontResource: FontResource = GetBodyResource.regularInter,
    onValueChange: (String) -> Unit,
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation? = VisualTransformation.None,
) {
    if (visualTransformation != null) {
        OutlinedTextField(
            modifier =
                modifier
                    .fillMaxWidth()
                    .height(70.dp),
            value = value,
            onValueChange = onValueChange,
            label = {
                LeimartText(
                    label,
                    fontResource = fontResource,
                    color = primary.copy(alpha = 0.7f),
                )
            },
            colors =
                TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = primary,
                    unfocusedBorderColor = secondary,
                ),
            trailingIcon = trailingIcon,
            shape = RoundedCornerShape(7.dp),
            visualTransformation = visualTransformation,
        )
    }
}
