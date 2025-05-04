package apui.shopping.kmp.domain.remote.repository

import apui.shopping.kmp.data.model.RegisterRequest
import apui.shopping.kmp.data.model.RegisterResponse

interface RegisterApiService {
    suspend fun registerApiService(registerRequest: RegisterRequest): RegisterResponse
}