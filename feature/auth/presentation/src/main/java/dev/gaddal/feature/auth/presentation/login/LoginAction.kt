package dev.gaddal.feature.auth.presentation.login

sealed interface LoginAction {
    data class OnEmailChange(val email: String) : LoginAction
    data class OnPasswordChange(val password: String) : LoginAction
    data object TogglePasswordVisibility : LoginAction
    data object Login : LoginAction
    data object DontHaveAccount : LoginAction
}