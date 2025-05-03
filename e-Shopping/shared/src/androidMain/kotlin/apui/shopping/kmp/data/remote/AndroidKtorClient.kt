package apui.shopping.kmp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

actual fun createHttpClient() = HttpClient(OkHttp) {
    install(ContentNegotiation) {
        json(json)
    }
}