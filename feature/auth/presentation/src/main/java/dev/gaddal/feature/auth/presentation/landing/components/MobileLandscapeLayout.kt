package dev.gaddal.feature.auth.presentation.landing.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
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
import dev.gaddal.core.presentation.ui.PhonePreviewLandscape
import dev.gaddal.feature.auth.presentation.R
import dev.gaddal.feature.auth.presentation.landing.LandingAction

@Composable
fun MobileLandscapeLayout(
    modifier: Modifier = Modifier,
    onAction: (LandingAction) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .consumeWindowInsets(WindowInsets.navigationBars),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.landing_background),
            contentDescription = null,
            modifier = Modifier.weight(3f),
            contentScale = ContentScale.Crop
        )

        HeaderAndActionButtonsSection(
            modifier = Modifier
                .weight(4f)
                .clip(
                    RoundedCornerShape(
                        topStart = 15.dp,
                        bottomStart = 15.dp
                    )
                )
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(top = 20.dp, bottom = 20.dp, start = 40.dp, end = 60.dp)
                .consumeWindowInsets(WindowInsets.navigationBars),
            onAction = onAction
        )
    }
}

@PhonePreviewLandscape
@Composable
fun MobileLandscapeLayoutPreview() {
    NoteMarkTheme {
        NoteMarkScaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = AppColors.LandingBackground,
            contentWindowInsets = WindowInsets.statusBars
        ) { innerPadding ->
            MobileLandscapeLayout(
                onAction = {}
            )
        }
    }
}