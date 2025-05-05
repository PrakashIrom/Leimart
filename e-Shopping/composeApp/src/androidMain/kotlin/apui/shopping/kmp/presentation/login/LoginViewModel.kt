package apui.shopping.kmp.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import apui.shopping.kmp.domain.model.AuthFormState

class LoginViewModel : ViewModel() {
    private val _formState = mutableStateOf(AuthFormState())
    val formState: State<AuthFormState> = _formState

    fun onEmailOrPhoneChange(emailOrPhone: String) {
        _formState.value = _formState.value.copy(emailOrPhone = emailOrPhone)
    }

    fun onPasswordChange(password: String) {
        _formState.value = _formState.value.copy(password = password)
    }
}
