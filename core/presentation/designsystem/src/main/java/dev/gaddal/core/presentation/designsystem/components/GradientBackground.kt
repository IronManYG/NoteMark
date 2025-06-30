package dev.gaddal.core.presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import dev.gaddal.core.presentation.designsystem.NoteMarkTheme
import dev.gaddal.core.presentation.designsystem.colors.AppColors.BGGradient

@Composable
fun GradientBackground(
    modifier: Modifier = Modifier,
    gradientColors: List<Color> = BGGradient,
    hasToolbar: Boolean = true,
    gradientDirection: GradientDirection = GradientDirection.Vertical,
    content: @Composable ColumnScope.() -> Unit
) {
    val gradientModifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .background(
            brush = when (gradientDirection) {
                GradientDirection.Vertical -> Brush.verticalGradient(colors = gradientColors)
                GradientDirection.Horizontal -> Brush.horizontalGradient(colors = gradientColors)
                GradientDirection.Diagonal -> Brush.linearGradient(colors = gradientColors)
            }
        )

    Box(modifier = gradientModifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if (hasToolbar) {
                        Modifier
                    } else {
                        Modifier.systemBarsPadding()
                    }
                )
        ) {
            content()
        }
    }
}

enum class GradientDirection {
    Vertical,
    Horizontal,
    Diagonal
}

@Preview(name = "Default Gradient")
@Composable
private fun GradientBackgroundDefaultPreview() {
    NoteMarkTheme {
        GradientBackground(
            modifier = Modifier.fillMaxSize()
        ) {
            // Content placeholder
        }
    }
}

@Preview(name = "Horizontal Gradient")
@Composable
private fun GradientBackgroundHorizontalPreview() {
    NoteMarkTheme {
        GradientBackground(
            modifier = Modifier.fillMaxSize(),
            gradientDirection = GradientDirection.Horizontal
        ) {
            // Content placeholder
        }
    }
}

@Preview(name = "Diagonal Gradient")
@Composable
private fun GradientBackgroundDiagonalPreview() {
    NoteMarkTheme {
        GradientBackground(
            modifier = Modifier.fillMaxSize(),
            gradientDirection = GradientDirection.Diagonal
        ) {
            // Content placeholder
        }
    }
}

@Preview(name = "No Toolbar")
@Composable
private fun GradientBackgroundNoToolbarPreview() {
    NoteMarkTheme {
        GradientBackground(
            modifier = Modifier.fillMaxSize(),
            hasToolbar = false
        ) {
            // Content placeholder
        }
    }
}