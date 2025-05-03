package apui.shopping.kmp.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import apui.shopping.kmp.R
import apui.shopping.kmp.presentation.theme.font.headerFontFamily
import apui.shopping.kmp.utils.ui.LeimartText
import apui.shopping.kmp.utils.ui.LeimartTextField
import apui.shopping.kmp.utils.ui.SolidButton
import apui.shopping.kmp.presentation.theme.appColor.leimartBlue
import apui.shopping.kmp.presentation.theme.appColor.primary
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginContent(viewModel: LoginViewModel = koinViewModel()) {
    val formState = viewModel.formState

    val userMailNo = formState.value.emailOrPhone
    val userPassword = formState.value.password
    val onEmailOrPhoneChange: (String) -> Unit = { newValue ->
        viewModel.onEmailOrPhoneChange(newValue)
    }
    val onPasswordChange: (String) -> Unit = { newValue ->
        viewModel.onPasswordChange(newValue)
    }

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        LeimartText(
            text = stringResource(R.string.login),
            fontFamily = headerFontFamily,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        LoginForm(userMailNo, userPassword, onEmailOrPhoneChange, onPasswordChange)
        Spacer(Modifier.height(16.dp))
        LoginActions()
    }
}

@Composable
fun LoginForm(
    userMailNo: String,
    userPassword: String,
    onEmailOrPhoneChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    Column {
        LeimartTextField(
            value = userMailNo,
            onValueChange = onEmailOrPhoneChange,
            label = stringResource(R.string.email) + '/' + stringResource(R.string.phone_no)
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordTextField(userPassword, onPasswordChange)
    }
}

@Composable
fun PasswordTextField(userPassword: String, onPasswordChange: (String) -> Unit) {
    val isPasswordVisible = remember { mutableStateOf(false) }

    LeimartTextField(
        value = userPassword,
        onValueChange = onPasswordChange,
        label = stringResource(R.string.password),
        trailingIcon = {
            Icon(
                painter = painterResource(
                    if (isPasswordVisible.value) R.drawable.show_password
                    else R.drawable.hide_password
                ),
                contentDescription = if (isPasswordVisible.value) "Hide Password" else "Show Password",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { isPasswordVisible.value = !isPasswordVisible.value }
            )
        },
        visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun LoginActions() {
    Column {
        SolidButton(
            {}, stringResource(R.string.submit),
            modifier = Modifier
                .fillMaxWidth()
                .height(63.dp)
        )
        Spacer(Modifier.height(6.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            LeimartText(
                text = "Forgot Password?",
                color = leimartBlue,
                fontSize = 13.sp
            )
        }
    }
}
