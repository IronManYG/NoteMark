package dev.gaddal.feature.auth.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(RegisterState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = RegisterState()
        )

    fun onAction(action: RegisterAction) {
        when (action) {
            is RegisterAction.OnUsernameChange -> {
                _state.update {
                    it.copy(
                        username = action.username,
                        usernameError = null
                    )
                }
            }

            is RegisterAction.OnEmailChange -> {
                _state.update {
                    it.copy(
                        email = action.email,
                        emailError = null
                    )
                }
            }

            is RegisterAction.OnPasswordChange -> {
                _state.update {
                    it.copy(
                        password = action.password,
                        passwordError = null
                    )
                }
            }

            is RegisterAction.OnConfirmPasswordChange -> {
                _state.update {
                    it.copy(
                        confirmPassword = action.confirmPassword,
                        confirmPasswordError = null
                    )
                }
            }

            is RegisterAction.TogglePasswordVisibility -> {
                _state.update {
                    it.copy(
                        isPasswordVisible = !it.isPasswordVisible
                    )
                }
            }

            is RegisterAction.ToggleConfirmPasswordVisibility -> {
                _state.update {
                    it.copy(
                        isConfirmPasswordVisible = !it.isConfirmPasswordVisible
                    )
                }
            }

            RegisterAction.CreateAccount -> {
                // TODO: Implement account creation logic
            }

            else -> Unit
        }
    }

}