package apui.shopping.kmp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

actual fun createHttpClient() = HttpClient(Darwin) {
    install(ContentNegotiation) {
        json(json)
    }
}