package dev.gaddal.feature.auth.presentation.login

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.gaddal.core.presentation.designsystem.NoteMarkTheme
import dev.gaddal.core.presentation.designsystem.components.NoteMarkScaffold
import dev.gaddal.core.presentation.designsystem.util.DeviceConfiguration
import dev.gaddal.core.presentation.ui.DevicesPreview
import dev.gaddal.core.presentation.ui.LocalesPreview
import dev.gaddal.feature.auth.presentation.login.components.LoginMobileLandscapeLayout
import dev.gaddal.feature.auth.presentation.login.components.LoginMobilePortraitLayout
import dev.gaddal.feature.auth.presentation.login.components.LoginTabletOrDesktopLayout

@Composable
fun LoginRoot(
    onLoginClick: () -> Unit,
    onDontHaveAccountClick: () -> Unit,
    viewModel: LoginViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LoginScreen(
        state = state,
        onAction = { action ->
            when (action) {
                LoginAction.Login -> onLoginClick()
                LoginAction.DontHaveAccount -> onDontHaveAccountClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
fun LoginScreen(
    state: LoginState,
    onAction: (LoginAction) -> Unit,
) {
    NoteMarkScaffold(
        modifier = Modifier.fillMaxSize(),
        withGradient = true,
        contentWindowInsets = WindowInsets.statusBars
    ) { innerPadding ->
        val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
        val deviceConfiguration = DeviceConfiguration.fromWindowSizeClass(windowSizeClass)

        when (deviceConfiguration) {
            DeviceConfiguration.MOBILE_PORTRAIT -> {
                LoginMobilePortraitLayout(
                    state = state,
                    onAction = onAction,
                    modifier = Modifier.padding(innerPadding)
                )
            }

            DeviceConfiguration.MOBILE_LANDSCAPE -> {
                LoginMobileLandscapeLayout(
                    state = state,
                    onAction = onAction,
                    modifier = Modifier.padding(innerPadding)
                )
            }

            DeviceConfiguration.TABLET_PORTRAIT,
            DeviceConfiguration.TABLET_LANDSCAPE,
            DeviceConfiguration.DESKTOP -> {
                LoginTabletOrDesktopLayout(
                    state = state,
                    onAction = onAction,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@LocalesPreview
@DevicesPreview
@Composable
private fun Preview() {
    NoteMarkTheme {
        LoginScreen(
            state = LoginState(),
            onAction = {}
        )
    }
}