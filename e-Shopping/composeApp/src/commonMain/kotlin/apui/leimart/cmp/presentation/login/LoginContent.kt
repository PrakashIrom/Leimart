package apui.leimart.cmp.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import apui.leimart.cmp.presentation.theme.appColor.leimartBlue
import apui.leimart.cmp.presentation.theme.appColor.primary
import apui.leimart.cmp.presentation.theme.typography.GetBodyResource
import apui.leimart.cmp.presentation.theme.typography.GetHeaderResource
import apui.leimart.cmp.utils.uiComponents.LeimartText
import apui.leimart.cmp.utils.uiComponents.LeimartTextField
import apui.leimart.cmp.utils.uiComponents.SolidButton
import e_shopping.composeapp.generated.resources.Res
import e_shopping.composeapp.generated.resources.email
import e_shopping.composeapp.generated.resources.hide_password
import e_shopping.composeapp.generated.resources.login
import e_shopping.composeapp.generated.resources.password
import e_shopping.composeapp.generated.resources.phone_no
import e_shopping.composeapp.generated.resources.show_password
import e_shopping.composeapp.generated.resources.submit
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginContent(
    viewModel: LoginViewModel = koinViewModel(),
    navController: NavHostController,
) {
    val formState = viewModel.formState

    val userMailNo = formState.value.emailOrPhone
    val userPassword = formState.value.password
    val onEmailOrPhoneChange: (String) -> Unit = { newValue ->
        viewModel.onEmailOrPhoneChange(newValue)
    }
    val onPasswordChange: (String) -> Unit = { newValue ->
        viewModel.onPasswordChange(newValue)
    }

    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LeimartText(
            modifier =
                Modifier
                    .height(70.dp)
                    .width(310.dp),
            text = stringResource(Res.string.login),
            fontResource = GetHeaderResource.playfairDisplayBold,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = primary,
        )
        Spacer(modifier = Modifier.height(16.dp))
        LoginForm(userMailNo, userPassword, onEmailOrPhoneChange, onPasswordChange)
        Spacer(Modifier.height(16.dp))
        LoginActions(navController)
    }
}

@Composable
fun LoginForm(
    userMailNo: String,
    userPassword: String,
    onEmailOrPhoneChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {
    Column {
        LeimartTextField(
            modifier =
                Modifier
                    .height(70.dp)
                    .width(310.dp),
            value = userMailNo,
            onValueChange = onEmailOrPhoneChange,
            label = stringResource(Res.string.email) + '/' + stringResource(Res.string.phone_no),
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordTextField(userPassword, onPasswordChange)
    }
}

@Composable
fun PasswordTextField(
    userPassword: String,
    onPasswordChange: (String) -> Unit,
) {
    val isPasswordVisible = remember { mutableStateOf(false) }

    LeimartTextField(
        modifier =
            Modifier
                .height(70.dp)
                .width(310.dp),
        value = userPassword,
        onValueChange = onPasswordChange,
        label = stringResource(Res.string.password),
        trailingIcon = {
            Icon(
                painter =
                    painterResource(
                        if (isPasswordVisible.value) {
                            Res.drawable.show_password
                        } else {
                            Res.drawable.hide_password
                        },
                    ),
                contentDescription = if (isPasswordVisible.value) "Hide Password" else "Show Password",
                modifier =
                    Modifier
                        .size(30.dp)
                        .clickable { isPasswordVisible.value = !isPasswordVisible.value },
            )
        },
        visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
    )
}

@Composable
fun LoginActions(navController: NavHostController) {
    Column {
        SolidButton(
            {},
            stringResource(Res.string.submit),
            modifier =
                Modifier
                    .height(70.dp)
                    .width(311.dp),
        )
        Spacer(Modifier.height(6.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            LeimartText(
                fontResource = GetBodyResource.regularInter,
                text = "Forgot Password?",
                color = leimartBlue,
                fontSize = 13.sp,
                modifier = Modifier.clickable {},
            )
        }
    }
}
