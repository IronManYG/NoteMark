package dev.gaddal.feature.auth.presentation.registration.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.gaddal.core.presentation.designsystem.NoteMarkTheme
import dev.gaddal.core.presentation.designsystem.components.NoteMarkScaffold
import dev.gaddal.core.presentation.ui.PhonePreviewLandscape
import dev.gaddal.feature.auth.presentation.R
import dev.gaddal.feature.auth.presentation.components.HeaderSection
import dev.gaddal.feature.auth.presentation.registration.RegisterAction
import dev.gaddal.feature.auth.presentation.registration.RegisterState

@Composable
fun RegisterMobileLandscapeLayout(
    state: RegisterState,
    onAction: (RegisterAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp
                )
            )
            .background(MaterialTheme.colorScheme.surfaceContainerLowest)
            .windowInsetsPadding(WindowInsets.displayCutout)
            .padding(
                horizontal = 32.dp,
                vertical = 24.dp
            )
            .consumeWindowInsets(WindowInsets.navigationBars),
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        HeaderSection(
            modifier = Modifier.weight(1f),
            title = stringResource(id = R.string.register_header_title),
            subtitle = stringResource(id = R.string.register_header_subtitle),
            alignment = Alignment.CenterHorizontally
        )
        RegisterFormSection(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            usernameText = state.username,
            onUsernameTextChange = { onAction(RegisterAction.OnUsernameChange(it)) },
            emailText = state.email,
            onEmailTextChange = { onAction(RegisterAction.OnEmailChange(it)) },
            passwordText = state.password,
            onPasswordTextChange = { onAction(RegisterAction.OnPasswordChange(it)) },
            confirmPasswordText = state.confirmPassword,
            onConfirmPasswordTextChange = { onAction(RegisterAction.OnConfirmPasswordChange(it)) },
            usernameSupportingText = state.usernameError,
            emailSupportingText = state.emailError,
            passwordSupportingText = state.passwordError,
            confirmPasswordSupportingText = state.confirmPasswordError,
            isPasswordVisible = state.isPasswordVisible,
            isConfirmPasswordVisible = state.isConfirmPasswordVisible,
            onPasswordVisibilityChange = { onAction(RegisterAction.TogglePasswordVisibility) },
            onConfirmPasswordVisibilityChange = { onAction(RegisterAction.ToggleConfirmPasswordVisibility) },
            onCreateAccountClick = { onAction(RegisterAction.CreateAccount) },
            onAlreadyHaveAccountClick = { onAction(RegisterAction.AlreadyHaveAccount) }
        )
    }
}

@PhonePreviewLandscape
@Composable
private fun RegisterMobileLandscapeLayoutPreview() {
    NoteMarkTheme {
        NoteMarkScaffold(
            modifier = Modifier.fillMaxSize(),
            withGradient = true,
            contentWindowInsets = WindowInsets.statusBars
        ) { innerPadding ->
            RegisterMobileLandscapeLayout(
                state = RegisterState(),
                onAction = {},
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
