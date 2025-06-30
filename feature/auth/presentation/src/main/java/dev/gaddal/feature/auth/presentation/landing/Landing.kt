package dev.gaddal.feature.auth.presentation.landing

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.gaddal.core.presentation.designsystem.NoteMarkTheme
import dev.gaddal.core.presentation.designsystem.colors.AppColors
import dev.gaddal.core.presentation.designsystem.components.NoteMarkScaffold
import dev.gaddal.core.presentation.designsystem.util.DeviceConfiguration
import dev.gaddal.core.presentation.ui.DevicesPreview
import dev.gaddal.core.presentation.ui.LocalesPreview
import dev.gaddal.feature.auth.presentation.landing.components.LandingMobileLandscapeLayout
import dev.gaddal.feature.auth.presentation.landing.components.LandingMobilePortraitLayout
import dev.gaddal.feature.auth.presentation.landing.components.LandingTabletOrDesktopLayout

@Composable
fun LandingRoot(
    onLoginClick: () -> Unit,
    onGetStartedClick: () -> Unit,
) {
    LandingScreen(
        onAction = { action ->
            when (action) {
                LandingAction.Login -> onLoginClick()
                LandingAction.Register -> onGetStartedClick()
            }
        }
    )
}

@Composable
fun LandingScreen(
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
                LandingMobilePortraitLayout(modifier = Modifier.padding(innerPadding), onAction)
            }

            DeviceConfiguration.MOBILE_LANDSCAPE -> {
                LandingMobileLandscapeLayout(modifier = Modifier.padding(innerPadding), onAction)
            }

            DeviceConfiguration.TABLET_PORTRAIT,
            DeviceConfiguration.TABLET_LANDSCAPE,
            DeviceConfiguration.DESKTOP -> {
                LandingTabletOrDesktopLayout(modifier = Modifier.padding(innerPadding), onAction)
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
            onAction = {}
        )
    }
}