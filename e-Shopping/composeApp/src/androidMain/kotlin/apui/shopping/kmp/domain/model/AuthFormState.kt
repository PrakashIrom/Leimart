package apui.shopping.kmp.domain.model

data class AuthFormState(
    val userName: String = "",
    val emailOrPhone: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)
