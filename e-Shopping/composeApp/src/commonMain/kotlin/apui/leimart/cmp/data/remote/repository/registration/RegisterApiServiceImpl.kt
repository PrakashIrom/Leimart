package apui.leimart.cmp.data.remote.repository.registration

import apui.leimart.cmp.data.model.RegisterRequest
import apui.leimart.cmp.data.model.RegisterResponse
import apui.leimart.cmp.data.remote.ApiConfig
import apui.leimart.cmp.domain.remote.repository.RegisterApiService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class RegisterApiServiceImpl(
    private val client: HttpClient,
) : RegisterApiService {
    override suspend fun registerApiService(registerRequest: RegisterRequest): RegisterResponse =
        client
            .post(ApiConfig.BASE_URL + ApiConfig.Endpoints.REGISTRATION) {
                contentType(ContentType.Application.Json)
                setBody(registerRequest)
            }.body()
}
