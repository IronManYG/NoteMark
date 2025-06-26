package dev.gaddal.feature.auth.presentation.landing

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
import dev.gaddal.core.presentation.designsystem.colors.AppColors
import dev.gaddal.core.presentation.designsystem.components.NoteMarkScaffold
import dev.gaddal.core.presentation.designsystem.util.DeviceConfiguration
import dev.gaddal.core.presentation.ui.DevicesPreview
import dev.gaddal.core.presentation.ui.LocalesPreview
import dev.gaddal.feature.auth.presentation.landing.components.MobileLandscapeLayout
import dev.gaddal.feature.auth.presentation.landing.components.MobilePortraitLayout
import dev.gaddal.feature.auth.presentation.landing.components.TabletOrDesktopLayout

@Composable
fun LandingRoot(
    viewModel: LandingViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LandingScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun LandingScreen(
    state: LandingState,
    onAction: (LandingAction) -> Unit,
) {
    NoteMarkScaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppColors.LandingBackground,
        contentWindowInsets = WindowInsets.statusBars
    ) { innerPadding ->
        val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
        val deviceConfiguration = DeviceConfiguration.fromWindowSizeClass(windowSizeClass)

        when (deviceConfiguration) {
            DeviceConfiguration.MOBILE_PORTRAIT -> {
                MobilePortraitLayout(modifier = Modifier.padding(innerPadding), onAction)
            }

            DeviceConfiguration.MOBILE_LANDSCAPE -> {
                MobileLandscapeLayout(modifier = Modifier.padding(innerPadding), onAction)
            }

            DeviceConfiguration.TABLET_PORTRAIT,
            DeviceConfiguration.TABLET_LANDSCAPE,
            DeviceConfiguration.DESKTOP -> {
                TabletOrDesktopLayout(modifier = Modifier.padding(innerPadding), onAction)
            }
        }
    }
}

@LocalesPreview
@DevicesPreview
@Composable
private fun Preview() {
    NoteMarkTheme {
        LandingScreen(
            state = LandingState(),
            onAction = {}
        )
    }
}