package apui.leimart.cmp.utils.uiComponents

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    shape: RoundedCornerShape = RoundedCornerShape(7.dp),
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation? = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    },
    focusedBorderColor: Color = primary,
    unfocusedBorderColor: Color = secondary
) {
    if (visualTransformation != null) {
        OutlinedTextField(
            modifier =
                modifier,
            value = value,
            onValueChange = onValueChange,
            label = {
                LeimartText(
                    label,
                    fontResource = fontResource,
                    color = primary.copy(alpha = 0.8f),
                )
            },
            /*placeholder = {
                LeimartText(
                    label,
                    fontResource = fontResource,
                    color = primary.copy(alpha = 0.7f),
                )
            },*/
            colors =
                OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = focusedBorderColor,
                    unfocusedBorderColor = unfocusedBorderColor,
                ),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            shape = shape,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource
        )
    }
}
