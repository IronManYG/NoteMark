package dev.gaddal.feature.auth.presentation.login.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.gaddal.core.presentation.designsystem.NoteMarkTheme
import dev.gaddal.feature.auth.presentation.R

@Composable
fun LoginHeaderSection(
    modifier: Modifier = Modifier,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = modifier,
        horizontalAlignment = alignment
    ) {
        Text(
            text = stringResource(id = R.string.login_header_title),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(id = R.string.login_header_subtitle),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginHeaderSectionPreview() {
    NoteMarkTheme {
        Box(
            modifier = Modifier.padding(16.dp),
        ) {
            LoginHeaderSection()
        }
    }
}
