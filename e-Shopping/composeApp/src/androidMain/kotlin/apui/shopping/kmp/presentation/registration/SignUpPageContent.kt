package apui.shopping.kmp.presentation.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import apui.shopping.kmp.R
import apui.shopping.kmp.presentation.navigation.Destination
import apui.shopping.kmp.presentation.theme.appColor.primary
import apui.shopping.kmp.presentation.theme.font.headerFontFamily
import apui.shopping.kmp.utils.ui.LeimartCircularProgressIndicator
import apui.shopping.kmp.utils.ui.LeimartText
import apui.shopping.kmp.utils.ui.LeimartTextField
import apui.shopping.kmp.utils.ui.LeimartToast
import apui.shopping.kmp.utils.ui.SolidButton
import io.ktor.http.HttpStatusCode
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignUpPageContent(
    viewModel: RegisterViewModel = koinViewModel(),
    navController: NavHostController
) {
    val userName = viewModel.registerRequestState.value.userName
    val email = viewModel.registerRequestState.value.email
    val phoneNo = viewModel.registerRequestState.value.phoneNo
    val password = viewModel.registerRequestState.value.password
    val confirmPassword = viewModel.registerRequestState.value.confirmPassword

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LeimartText(
            text = stringResource(R.string.sign_up),
            fontFamily = headerFontFamily,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        SignUpForm(userName, email, phoneNo, password, confirmPassword, viewModel, navController)
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
    navController: NavHostController
) {
    val onUserNameChange: (String) -> Unit = { newValue -> viewModel.onUserNameChange(newValue) }
    val onEmailChange: (String) -> Unit = { newValue -> viewModel.onEmailChange(newValue) }
    val onPhoneNoChange: (String) -> Unit = { newValue -> viewModel.onPhoneNoChange(newValue) }
    val onPasswordChange: (String) -> Unit = { newValue -> viewModel.onPasswordChange(newValue) }
    val onConfirmPasswordChange: (String) -> Unit =
        { newValue -> viewModel.onConfirmPasswordChange(newValue) }

    Column {
        VerticalTextFieldSpacer(userName, onUserNameChange, stringResource(R.string.user_name))
        VerticalTextFieldSpacer(email, onEmailChange, stringResource(R.string.email))
        VerticalTextFieldSpacer(phoneNo, onPhoneNoChange, stringResource(R.string.phone_no))
        VerticalTextFieldSpacer(password, onPasswordChange, stringResource(R.string.password))
        VerticalTextFieldSpacer(
            confirmPassword,
            onConfirmPasswordChange,
            stringResource(R.string.confirm_password)
        )
        RegisterAction(viewModel, navController)
    }
}

@Composable
fun VerticalTextFieldSpacer(textFieldItem: String, onValueChange: (String) -> Unit, label: String) {
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
fun RegisterAction(viewModel: RegisterViewModel, navController: NavHostController) {

    val registerResponseState = viewModel.registerUiState.collectAsStateWithLifecycle().value
    val registerRequest = viewModel.registerRequestState.value
    val isButtonClick = remember { mutableStateOf(false) }

    SolidButton(
        onClick = {
            viewModel.registerUser(registerRequest)
            isButtonClick.value = true
        }, stringResource(R.string.submit),
        modifier = Modifier
            .fillMaxWidth()
            .height(63.dp)
    )

    if (isButtonClick.value) {
        when (registerResponseState) {
            is RegisterUiState.Success -> {
                if (registerResponseState.registerResponse.status == HttpStatusCode.OK.value) {
                    LeimartToast("Registration Successful")
                    /*Look for the SignUp destination in the back stack (the history of screens the user has visited)
                      Remove all destinations that are above the SignUp screen in the stack,
                      including SignUp screen because inclusive = true*/
                    navController.navigate(Destination.Login.route) {
                        popUpTo(Destination.SignUp.route) {
                            inclusive = true
                        }
                    }
                }
            }

            is RegisterUiState.Loading -> {
                LeimartCircularProgressIndicator()
            }

            is RegisterUiState.Error -> {
                LeimartToast(toastMessage = registerResponseState.message)
            }
        }
        isButtonClick.value = false
    }
}