package apui.leimart.cmp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    @SerialName("name")
    val userName: String = "",
    val email: String = "",
    @SerialName("phoneNumber")
    val phoneNo: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    @SerialName("whatsApp_Notification")
    val whatsAppNotification: Boolean = false,
)
