package apui.leimart.cmp.domain.model

// For Login Page
data class AuthFormState(
    val userName: String = "",
    val emailOrPhone: String = "",
    val password: String = "",
    val confirmPassword: String = "",
)
