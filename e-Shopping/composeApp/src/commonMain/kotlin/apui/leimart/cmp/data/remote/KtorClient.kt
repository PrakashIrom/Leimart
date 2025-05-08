package apui.leimart.cmp.data.remote

import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json

expect fun createHttpClient(): HttpClient

val json = (
    Json {
        ignoreUnknownKeys = true
        // data not in kotlin data class but it's there in json is ignored and ignored will not be shown

        isLenient = true
            /* without isLenient {name:"Apui"} error will be shown, it should be {"name":"Apui"}, with isLenient
            the quotation mark is ignored and error is ignored*/

        coerceInputValues = true
            /*If a value in JSON is null or invalid, and your Kotlin data class provides a default value,
            it will use the default instead of throwing an error*/
    }
)
