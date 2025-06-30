package dev.gaddal.feature.auth.presentation.login.components

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
import dev.gaddal.core.presentation.designsystem.components.NoteMarkLink
import dev.gaddal.core.presentation.designsystem.components.NoteMarkTextField
import dev.gaddal.feature.auth.presentation.R

@Composable
fun LoginFormSection(
    emailText: String,
    onEmailTextChange: (String) -> Unit,
    passwordText: String,
    onPasswordTextChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onDontHaveAccountClick: () -> Unit,
    modifier: Modifier = Modifier,
    emailSupportingText: String? = null,
    passwordSupportingText: String? = null,
    isPasswordVisible: Boolean = false,
    onPasswordVisibilityChange: () -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        NoteMarkTextField(
            text = emailText,
            onValueChange = onEmailTextChange,
            label = stringResource(R.string.email),
            hint = stringResource(R.string.email_hint),
            isInputSecret = false,
            modifier = Modifier
                .fillMaxWidth(),
            isError = emailSupportingText != null,
            supportingText = emailSupportingText,
            isPasswordVisible = false,
            onPasswordVisibilityChange = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        NoteMarkTextField(
            text = passwordText,
            onValueChange = onPasswordTextChange,
            label = stringResource(R.string.password),
            hint = stringResource(R.string.password_hint),
            isInputSecret = true,
            modifier = Modifier
                .fillMaxWidth(),
            isError = passwordSupportingText != null,
            supportingText = passwordSupportingText,
            isPasswordVisible = isPasswordVisible,
            onPasswordVisibilityChange = { onPasswordVisibilityChange() }
        )
        Spacer(modifier = Modifier.height(24.dp))
        NoteMarkFilledButton(
            text = stringResource(R.string.log_in),
            onClick = { onLoginClick() },
            modifier = Modifier.fillMaxWidth(),
            enabled = emailText.isNotBlank() && passwordText.isNotBlank()
        )
        Spacer(modifier = Modifier.height(16.dp))
        NoteMarkLink(
            text = stringResource(R.string.dont_have_account),
            onClick = { onDontHaveAccountClick() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormSectionPreview() {
    NoteMarkTheme {
        Box(
            modifier = Modifier.padding(16.dp),
        ) {
            LoginFormSection(
                emailText = "",
                onEmailTextChange = {},
                passwordText = "",
                onPasswordTextChange = {},
                onLoginClick = {},
                onDontHaveAccountClick = {},
            )
        }
    }
}