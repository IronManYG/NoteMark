package dev.gaddal.feature.auth.presentation.landing.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.gaddal.core.presentation.designsystem.NoteMarkTheme
import dev.gaddal.core.presentation.designsystem.colors.AppColors
import dev.gaddal.core.presentation.designsystem.components.NoteMarkScaffold
import dev.gaddal.core.presentation.ui.LargeScreenPreview
import dev.gaddal.feature.auth.presentation.R
import dev.gaddal.feature.auth.presentation.landing.LandingAction

@Composable
fun TabletOrDesktopLayout(
    modifier: Modifier = Modifier,
    onAction: (LandingAction) -> Unit
) {
    Box(
        modifier = modifier
            .consumeWindowInsets(WindowInsets.navigationBars)
            .fillMaxSize()
            .background(AppColors.LandingBackground)
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.landing_background_big),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 48.dp)
        ) {
            HeaderAndActionButtonsSection(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 24.dp
                    )
                    .consumeWindowInsets(WindowInsets.navigationBars),
                onAction = onAction
            )
        }
    }
}

@LargeScreenPreview
@Composable
fun TabletOrDesktopLayoutPreview() {
    NoteMarkTheme {
        NoteMarkScaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = AppColors.LandingBackground,
            contentWindowInsets = WindowInsets.statusBars
        ) { innerPadding ->
            TabletOrDesktopLayout(
                onAction = {}
            )
        }
    }
}
