package apui.shopping.kmp.presentation.registration

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import apui.shopping.kmp.data.model.RegisterRequest
import apui.shopping.kmp.data.model.RegisterResponse
import apui.shopping.kmp.domain.usecase.registration.RegisterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface RegisterUiState {
    data class Success(
        val registerResponse: RegisterResponse,
    ) : RegisterUiState

    data object Loading : RegisterUiState

    data class Error(
        val message: String,
    ) : RegisterUiState
}

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase,
) : ViewModel() {
    private val _registerUiState = MutableStateFlow<RegisterUiState>(RegisterUiState.Loading)
    val registerUiState: StateFlow<RegisterUiState> = _registerUiState.asStateFlow()

    private val _registerRequestState = mutableStateOf(RegisterRequest())
    val registerRequestState: State<RegisterRequest> = _registerRequestState

    val isButtonClicked = mutableStateOf(false)

    fun updateOnChangeRegisterRequest(update: RegisterRequest.() -> RegisterRequest) {
        /*
        ## Parameter ##
        In your ViewModel, _registerRequestState holds an immutable RegisterRequest object.
         When you want to update it, you must:
        Create a new copy of the state (leaving the original unchanged).
        Return the modified copy.
        This is why the lambda must return a RegisterRequest—it enforces that you provide the updated state.
        Initially, When I do:
        updateRegisterRequest { copy(userName = "Alice") }
        copy() creates a new RegisterRequest with all fields identical to the original, except userName.
        The lambda implicitly returns this new object (due to Kotlin’s last-expression-return rule).
         */
        _registerRequestState.value = _registerRequestState.value.update()
    }

    fun whatsAppNotification(whatsAppNotification: Boolean) {
        _registerRequestState.value =
            _registerRequestState.value.copy(whatsAppNotification = whatsAppNotification)
    }

    fun registerUser(registerRequest: RegisterRequest) {
        isButtonClicked.value = true
        _registerUiState.value = RegisterUiState.Loading

        viewModelScope.launch {
            try {
                val registerResponse =
                    registerUseCase.invoke(
                        registerRequest = registerRequest,
                    )
                _registerUiState.value = RegisterUiState.Success(registerResponse)
                isButtonClicked.value = false
            } catch (e: Exception) {
                RegisterUiState.Error(e.message.toString())
                isButtonClicked.value = false
            }
        }
    }
}
