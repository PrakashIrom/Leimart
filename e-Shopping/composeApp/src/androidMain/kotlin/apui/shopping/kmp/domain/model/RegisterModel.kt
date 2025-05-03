package apui.shopping.kmp.domain.model

data class RegisterModel(
    val userName: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)
