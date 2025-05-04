package apui.shopping.kmp.presentation.registration

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import apui.shopping.kmp.data.model.RegisterRequest
import apui.shopping.kmp.data.model.RegisterResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.compose.runtime.State
import apui.shopping.kmp.domain.usecase.registration.RegisterUseCase

sealed interface RegisterUiState {
    data class Success(val registerResponse: RegisterResponse) : RegisterUiState
    data object Loading : RegisterUiState
    data class Error(val message: String) : RegisterUiState
}

class RegisterViewModel(private val registerUseCase: RegisterUseCase) : ViewModel() {

    private val _registerUiState = MutableStateFlow<RegisterUiState>(RegisterUiState.Loading)
    val registerUiState: StateFlow<RegisterUiState> = _registerUiState

    private val _registerRequestState = mutableStateOf(RegisterRequest())
    val registerRequestState: State<RegisterRequest> = _registerRequestState

    fun onUserNameChange(userName: String) {
        _registerRequestState.value = _registerRequestState.value.copy(userName = userName)
    }

    fun onEmailChange(email: String) {
        _registerRequestState.value = _registerRequestState.value.copy(email = email)
    }

    fun onPhoneNoChange(phoneNo: String) {
        _registerRequestState.value = _registerRequestState.value.copy(phoneNo = phoneNo)
    }

    fun onPasswordChange(password: String) {
        _registerRequestState.value = _registerRequestState.value.copy(password = password)
    }

    fun onConfirmPasswordChange(confirmPassword: String) {
        _registerRequestState.value =
            _registerRequestState.value.copy(confirmPassword = confirmPassword)
    }

    fun whatsAppNotification(whatsAppNotification: Boolean) {
        _registerRequestState.value =
            _registerRequestState.value.copy(whatsAppNotification = whatsAppNotification)
    }

    fun registerUser(
        registerRequest: RegisterRequest
    ) {
        _registerUiState.value = RegisterUiState.Loading

        viewModelScope.launch {
            try {
                val registerResponse = registerUseCase.invoke(
                    registerRequest = registerRequest
                )
                _registerUiState.value = RegisterUiState.Success(registerResponse)

            } catch (e: Exception) {
                RegisterUiState.Error(e.message.toString())
            }
        }

    }

}