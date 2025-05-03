package apui.shopping.kmp.data.remote.registration

import apui.shopping.kmp.data.model.RegisterRequest
import apui.shopping.kmp.data.model.RegisterResponse
import apui.shopping.kmp.data.remote.ApiConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class RegisterApiService(private val client: HttpClient) {
    suspend fun registerUser(
        registerRequest: RegisterRequest
    ): RegisterResponse {
        return client.post(ApiConfig.Endpoints.registration) {
            setBody(registerRequest)
        }.body()
    }
}