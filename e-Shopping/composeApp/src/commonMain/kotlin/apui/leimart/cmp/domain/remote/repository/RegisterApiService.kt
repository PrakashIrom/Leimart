package apui.leimart.cmp.domain.remote.repository

import apui.leimart.cmp.data.model.RegisterRequest
import apui.leimart.cmp.data.model.RegisterResponse

interface RegisterApiService {
    suspend fun registerApiService(registerRequest: RegisterRequest): RegisterResponse
}
