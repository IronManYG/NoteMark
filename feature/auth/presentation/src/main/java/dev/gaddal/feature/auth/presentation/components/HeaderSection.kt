package dev.gaddal.feature.auth.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.gaddal.core.presentation.designsystem.NoteMarkTheme

/**
 * A reusable header section component that displays a title and a subtitle.
 *
 * @param modifier Modifier to be applied to the column
 * @param title The main title text to be displayed
 * @param subtitle The subtitle text to be displayed below the title
 * @param alignment The horizontal alignment of the texts within the column
 */
@Composable
fun HeaderSection(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = modifier,
        horizontalAlignment = alignment
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = subtitle,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderSectionPreview() {
    NoteMarkTheme {
        HeaderSection(
            title = "Header Title",
            subtitle = "This is a sample subtitle for the header section."
        )
    }
}