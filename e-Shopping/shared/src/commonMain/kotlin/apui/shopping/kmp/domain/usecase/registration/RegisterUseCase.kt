package apui.shopping.kmp.domain.usecase.registration

import apui.shopping.kmp.data.model.RegisterRequest
import apui.shopping.kmp.data.model.RegisterResponse
import apui.shopping.kmp.domain.remote.repository.RegisterApiService

class RegisterUseCase(
    private val registerApiService: RegisterApiService,
) {
    suspend fun invoke(registerRequest: RegisterRequest): RegisterResponse = registerApiService.registerApiService(registerRequest)
}
