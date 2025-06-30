package dev.gaddal.feature.auth.presentation.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.widthIn
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
import dev.gaddal.core.presentation.ui.LargeScreenPreview
import dev.gaddal.feature.auth.presentation.R
import dev.gaddal.feature.auth.presentation.components.HeaderSection
import dev.gaddal.feature.auth.presentation.login.LoginAction
import dev.gaddal.feature.auth.presentation.login.LoginState

@Composable
fun LoginTabletOrDesktopLayout(
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
            .verticalScroll(rememberScrollState())
            .padding(
                horizontal = 48.dp,
                vertical = 100.dp
            )
            .consumeWindowInsets(WindowInsets.navigationBars),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderSection(
            modifier = Modifier.widthIn(max = 560.dp),
            title = stringResource(id = R.string.login_header_title),
            subtitle = stringResource(id = R.string.login_header_subtitle),
            alignment = Alignment.CenterHorizontally
        )
        LoginFormSection(
            emailText = state.email,
            onEmailTextChange = { onAction(LoginAction.OnEmailChange(it)) },
            passwordText = state.password,
            onPasswordTextChange = { onAction(LoginAction.OnPasswordChange(it)) },
            onLoginClick = { onAction(LoginAction.Login) },
            onDontHaveAccountClick = { onAction(LoginAction.DontHaveAccount) },
            modifier = Modifier.widthIn(max = 560.dp),
            emailSupportingText = state.emailError,
            passwordSupportingText = state.passwordError,
            isPasswordVisible = state.isPasswordVisible,
            onPasswordVisibilityChange = { onAction(LoginAction.TogglePasswordVisibility) }
        )
    }
}

@LargeScreenPreview
@Composable
private fun LoginTabletOrDesktopLayoutPreview() {
    NoteMarkTheme {
        NoteMarkScaffold(
            modifier = Modifier.fillMaxSize(),
            withGradient = true,
            contentWindowInsets = WindowInsets.statusBars
        ) { innerPadding ->
            LoginTabletOrDesktopLayout(
                state = LoginState(),
                onAction = {},
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
