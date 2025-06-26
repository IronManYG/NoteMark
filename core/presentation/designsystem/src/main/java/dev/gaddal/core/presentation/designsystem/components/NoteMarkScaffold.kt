package dev.gaddal.core.presentation.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun NoteMarkScaffold(
    modifier: Modifier = Modifier,
    topAppBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    progressBarState: ProgressBarState = ProgressBarState.Idle,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = topAppBar,
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = FabPosition.End,
        containerColor = containerColor,
        contentWindowInsets = contentWindowInsets,
        modifier = modifier
    ) { padding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            content(padding)

            if (progressBarState is ProgressBarState.Loading) {
                CircularIndeterminateProgressBar()
            }
        }
    }
}