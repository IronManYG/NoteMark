package dev.gaddal.feature.auth.presentation.registration

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
import dev.gaddal.feature.auth.presentation.registration.components.RegisterMobileLandscapeLayout
import dev.gaddal.feature.auth.presentation.registration.components.RegisterMobilePortraitLayout
import dev.gaddal.feature.auth.presentation.registration.components.RegisterTabletOrDesktopLayout

@Composable
fun RegisterRoot(
    onCreateAccountClick: () -> Unit,
    onAlreadyHaveAccountClick: () -> Unit,
    viewModel: RegisterViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    RegisterScreen(
        state = state,
        onAction = { action ->
            when (action) {
                RegisterAction.CreateAccount -> onCreateAccountClick()
                RegisterAction.AlreadyHaveAccount -> onAlreadyHaveAccountClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
fun RegisterScreen(
    state: RegisterState,
    onAction: (RegisterAction) -> Unit,
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
                RegisterMobilePortraitLayout(
                    state = state,
                    onAction = onAction,
                    modifier = Modifier.padding(innerPadding)
                )
            }

            DeviceConfiguration.MOBILE_LANDSCAPE -> {
                RegisterMobileLandscapeLayout(
                    state = state,
                    onAction = onAction,
                    modifier = Modifier.padding(innerPadding)
                )
            }

            DeviceConfiguration.TABLET_PORTRAIT,
            DeviceConfiguration.TABLET_LANDSCAPE,
            DeviceConfiguration.DESKTOP -> {
                RegisterTabletOrDesktopLayout(
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
        RegisterScreen(
            state = RegisterState(),
            onAction = {}
        )
    }
}