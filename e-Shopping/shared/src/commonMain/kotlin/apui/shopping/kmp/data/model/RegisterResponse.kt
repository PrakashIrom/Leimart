package apui.shopping.kmp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponse(
    val status: Int,
    val ok: Boolean,
    val message: String
)
