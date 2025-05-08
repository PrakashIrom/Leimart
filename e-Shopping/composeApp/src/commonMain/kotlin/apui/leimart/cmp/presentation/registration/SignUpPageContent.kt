package apui.leimart.cmp.presentation.registration

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import apui.leimart.cmp.presentation.navigation.Destination
import apui.leimart.cmp.utils.uiComponents.LeimartCircularProgressIndicator
import apui.leimart.cmp.utils.uiComponents.LeimartText
import apui.leimart.cmp.utils.uiComponents.LeimartTextField
import apui.leimart.cmp.utils.uiComponents.LeimartToast
import apui.leimart.cmp.utils.uiComponents.SolidButton
import apui.shopping.kmp.presentation.theme.appColor.primary
import apui.shopping.kmp.presentation.theme.font.headerFontFamily
import e_shopping.composeapp.generated.resources.Res
import e_shopping.composeapp.generated.resources.confirm_password
import e_shopping.composeapp.generated.resources.email
import e_shopping.composeapp.generated.resources.password
import e_shopping.composeapp.generated.resources.phone_no
import e_shopping.composeapp.generated.resources.sign_up
import e_shopping.composeapp.generated.resources.submit
import e_shopping.composeapp.generated.resources.user_name
import io.ktor.http.HttpStatusCode
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignUpPageContent(
    viewModel: RegisterViewModel = koinViewModel(),
    navController: NavHostController,
) {
    val userName = viewModel.registerRequestState.value.userName
    val email = viewModel.registerRequestState.value.email
    val phoneNo = viewModel.registerRequestState.value.phoneNo
    val password = viewModel.registerRequestState.value.password
    val confirmPassword = viewModel.registerRequestState.value.confirmPassword
    val registerUiState = viewModel.registerUiState.collectAsState().value
    val isButtonClicked = viewModel.isButtonClicked.value

    Box(contentAlignment = Alignment.Center) {
        Column(
            modifier =
                Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LeimartText(
                text = stringResource(Res.string.sign_up),
                fontFamily = headerFontFamily,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = primary,
            )
            Spacer(modifier = Modifier.height(16.dp))
            SignUpForm(
                userName,
                email,
                phoneNo,
                password,
                confirmPassword,
                viewModel,
                navController,
            )
        }

        // Loading's LeimartCircularProgressIndicator is shown here instead of showing it in the composable
        // @RegisterFunction function because of UI issue i.e, if LeimartCircularProgressIndicator
        // is not called from here CircularProgressIndicator is not able to align directly at the center
        if (registerUiState is RegisterUiState.Loading && isButtonClicked) {
            LeimartCircularProgressIndicator()
        }
    }
}

@Composable
fun SignUpForm(
    userName: String,
    email: String,
    phoneNo: String,
    password: String,
    confirmPassword: String,
    viewModel: RegisterViewModel,
    navController: NavHostController,
) {
    /* ## How copy(value = newValue) works:
        copy() creates a new RegisterRequest with all fields identical to the original, except userName.
        The lambda implicitly returns this new object (due to Kotlin’s last-expression-return rule).
     */
    val onUserNameChange: (String) -> Unit =
        { newValue -> viewModel.updateOnChangeRegisterRequest { copy(userName = newValue) } }
    val onEmailChange: (String) -> Unit = { newValue ->
        viewModel.updateOnChangeRegisterRequest {
            copy(email = newValue)
        }
    }
    val onPhoneNoChange: (String) -> Unit = { newValue ->
        viewModel.updateOnChangeRegisterRequest {
            copy(phoneNo = newValue)
        }
    }
    val onPasswordChange: (String) -> Unit = { newValue ->
        viewModel.updateOnChangeRegisterRequest {
            copy(password = newValue)
        }
    }
    val onConfirmPasswordChange: (String) -> Unit =
        { newValue ->
            viewModel.updateOnChangeRegisterRequest {
                copy(confirmPassword = newValue)
            }
        }

    Column {
        VerticalTextFieldSpacer(userName, onUserNameChange, stringResource(Res.string.user_name))
        VerticalTextFieldSpacer(email, onEmailChange, stringResource(Res.string.email))
        VerticalTextFieldSpacer(phoneNo, onPhoneNoChange, stringResource(Res.string.phone_no))
        VerticalTextFieldSpacer(password, onPasswordChange, stringResource(Res.string.password))
        VerticalTextFieldSpacer(
            confirmPassword,
            onConfirmPasswordChange,
            stringResource(Res.string.confirm_password),
        )
    }
    RegisterAction(viewModel, navController)
}

@Composable
fun VerticalTextFieldSpacer(
    textFieldItem: String,
    onValueChange: (String) -> Unit,
    label: String,
) {
    Column {
        LeimartTextField(
            value = textFieldItem,
            onValueChange = onValueChange,
            label = label,
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun RegisterAction(
    viewModel: RegisterViewModel,
    navController: NavHostController,
) {
    val registerResponseState = viewModel.registerUiState.collectAsState().value
    val registerRequest = viewModel.registerRequestState.value
    val context = LocalContext.current

    SolidButton(
        onClick = {
            viewModel.registerUser(registerRequest)
        },
        stringResource(Res.string.submit),
        modifier =
            Modifier
                .fillMaxWidth()
                .height(63.dp),
    )

    when (registerResponseState) {
        is RegisterUiState.Success -> {
            if (registerResponseState.registerResponse.status == HttpStatusCode.OK.value) {
                LeimartToast("Registration Successful", context = context)

                /*Look for the SignUp destination in the back stack (the history of screens the user has visited)
              Remove all destinations that are above the SignUp screen in the stack,
              including SignUp screen because inclusive = true if not included*/
                navController.navigate(Destination.Login.route) {
                    popUpTo(Destination.SignUp.route) {
                        inclusive = true
                    }
                }
            }
        }

        is RegisterUiState.Error -> {
            LeimartToast(registerResponseState.message, context = context)
        }

        else -> Unit
    }
}
