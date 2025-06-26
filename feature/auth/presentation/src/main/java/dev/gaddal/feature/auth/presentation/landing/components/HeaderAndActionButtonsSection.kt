package dev.gaddal.feature.auth.presentation.landing.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.gaddal.core.presentation.designsystem.NoteMarkTheme
import dev.gaddal.core.presentation.designsystem.components.NoteMarkFilledButton
import dev.gaddal.core.presentation.designsystem.components.NoteMarkOutlinedButton
import dev.gaddal.feature.auth.presentation.R
import dev.gaddal.feature.auth.presentation.components.HeaderSection
import dev.gaddal.feature.auth.presentation.landing.LandingAction

@Composable
fun HeaderAndActionButtonsSection(
    modifier: Modifier = Modifier,
    onAction: (LandingAction) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Header section
        HeaderSection(
            title = stringResource(R.string.landing_header_title),
            subtitle = stringResource(R.string.landing_header_subtitle),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Action buttons
        NoteMarkFilledButton(
            text = stringResource(R.string.get_started),
            onClick = { onAction(LandingAction.Register) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        NoteMarkOutlinedButton(
            text = stringResource(R.string.log_in),
            onClick = { onAction(LandingAction.Login) },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderAndActionButtonsSectionPreview() {
    NoteMarkTheme {
        Box(
            modifier = Modifier.padding(16.dp),
        ) {
            HeaderAndActionButtonsSection(
                onAction = {}
            )
        }
    }
}