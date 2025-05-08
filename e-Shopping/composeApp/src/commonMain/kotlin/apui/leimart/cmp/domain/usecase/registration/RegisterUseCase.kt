package apui.leimart.cmp.domain.usecase.registration

import apui.leimart.cmp.data.model.RegisterRequest
import apui.leimart.cmp.data.model.RegisterResponse
import apui.leimart.cmp.domain.remote.repository.RegisterApiService

class RegisterUseCase(
    private val registerApiService: RegisterApiService,
) {
    suspend fun invoke(registerRequest: RegisterRequest): RegisterResponse = registerApiService.registerApiService(registerRequest)
}
