package dev.gaddal.feature.auth.presentation.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.gaddal.core.presentation.designsystem.NoteMarkTheme
import dev.gaddal.core.presentation.designsystem.components.NoteMarkScaffold
import dev.gaddal.core.presentation.ui.PhonePreview
import dev.gaddal.feature.auth.presentation.R
import dev.gaddal.feature.auth.presentation.components.HeaderSection
import dev.gaddal.feature.auth.presentation.login.LoginAction
import dev.gaddal.feature.auth.presentation.login.LoginState

@Composable
fun LoginMobilePortraitLayout(
    state: LoginState,
    onAction: (LoginAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp
                )
            )
            .background(MaterialTheme.colorScheme.surfaceContainerLowest)
            .padding(
                horizontal = 16.dp,
                vertical = 24.dp
            )
            .consumeWindowInsets(WindowInsets.navigationBars),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        HeaderSection(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.login_header_title),
            subtitle = stringResource(id = R.string.login_header_subtitle),
        )
        LoginFormSection(
            emailText = state.email,
            onEmailTextChange = { onAction(LoginAction.OnEmailChange(it)) },
            passwordText = state.password,
            onPasswordTextChange = { onAction(LoginAction.OnPasswordChange(it)) },
            onLoginClick = { onAction(LoginAction.Login) },
            onDontHaveAccountClick = { onAction(LoginAction.DontHaveAccount) },
            modifier = Modifier.fillMaxWidth(),
            emailSupportingText = state.emailError,
            passwordSupportingText = state.passwordError,
            isPasswordVisible = state.isPasswordVisible,
            onPasswordVisibilityChange = { onAction(LoginAction.TogglePasswordVisibility) }
        )
    }
}

@PhonePreview
@Composable
private fun LoginMobilePortraitLayoutPreview() {
    NoteMarkTheme {
        NoteMarkScaffold(
            modifier = Modifier.fillMaxSize(),
            withGradient = true,
            contentWindowInsets = WindowInsets.statusBars
        ) { innerPadding ->
            LoginMobilePortraitLayout(
                state = LoginState(),
                onAction = {},
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
