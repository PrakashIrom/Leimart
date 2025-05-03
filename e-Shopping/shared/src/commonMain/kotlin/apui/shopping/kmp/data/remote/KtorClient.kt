package apui.shopping.kmp.data.remote

import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json

expect fun createHttpClient(): HttpClient

val json = (Json {
    ignoreUnknownKeys = true
    isLenient = true
    coerceInputValues = true
})