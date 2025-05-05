package apui.shopping.kmp.data.remote.repository.registration

import apui.shopping.kmp.data.model.RegisterRequest
import apui.shopping.kmp.data.model.RegisterResponse
import apui.shopping.kmp.data.remote.ApiConfig
import apui.shopping.kmp.domain.remote.repository.RegisterApiService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class RegisterApiServiceImpl(
    private val client: HttpClient,
) : RegisterApiService {
    override suspend fun registerApiService(registerRequest: RegisterRequest): RegisterResponse =
        client
            .post(ApiConfig.BASE_URL + ApiConfig.Endpoints.REGISTRATION) {
                setBody(registerRequest)
            }.body()
}
