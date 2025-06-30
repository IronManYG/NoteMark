package dev.gaddal.feature.auth.presentation.registration

sealed interface RegisterAction {
    data class OnUsernameChange(val username: String) : RegisterAction
    data class OnEmailChange(val email: String) : RegisterAction
    data class OnPasswordChange(val password: String) : RegisterAction
    data class OnConfirmPasswordChange(val confirmPassword: String) : RegisterAction
    data object TogglePasswordVisibility : RegisterAction
    data object ToggleConfirmPasswordVisibility : RegisterAction
    data object CreateAccount : RegisterAction
    data object AlreadyHaveAccount : RegisterAction
}