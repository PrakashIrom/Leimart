package apui.shopping.kmp.presentation.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import apui.shopping.kmp.data.model.RegisterResponse
import apui.shopping.kmp.data.remote.registration.RegisterApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed interface RegisterUiState {
    data class Success(val registerResponse: RegisterResponse) : RegisterUiState
    data object Loading : RegisterUiState
    data class Error(val message: String) : RegisterUiState
}

class RegisterViewModel(private val registerApiService: RegisterApiService) : ViewModel() {

    private val _registerUiState = MutableStateFlow<RegisterUiState>(RegisterUiState.Loading)
    val registerUiState: StateFlow<RegisterUiState> = _registerUiState

    fun registerUser(
        userName: String,
        email: String,
        phoneNo: String,
        password: String,
        confirmPassword: String,
        whatsAppNotification: Boolean
    ) {

        _registerUiState.value = RegisterUiState.Loading

        viewModelScope.launch {

            try {
                val registerResponse = registerApiService.registerUser(
                    userName,
                    email,
                    phoneNo,
                    password,
                    confirmPassword,
                    whatsAppNotification
                )
                _registerUiState.value = RegisterUiState.Success(registerResponse)

            } catch (e: Exception) {
                RegisterUiState.Error(e.message.toString())
            }
        }

    }

}