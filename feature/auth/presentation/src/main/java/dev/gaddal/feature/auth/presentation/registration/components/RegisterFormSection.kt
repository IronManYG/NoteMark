package dev.gaddal.feature.auth.presentation.registration.components

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
fun RegisterFormSection(
    usernameText: String,
    onUsernameTextChange: (String) -> Unit,
    emailText: String,
    onEmailTextChange: (String) -> Unit,
    passwordText: String,
    onPasswordTextChange: (String) -> Unit,
    confirmPasswordText: String,
    onConfirmPasswordTextChange: (String) -> Unit,
    onCreateAccountClick: () -> Unit,
    onAlreadyHaveAccountClick: () -> Unit,
    modifier: Modifier = Modifier,
    usernameSupportingText: String? = null,
    emailSupportingText: String? = null,
    passwordSupportingText: String? = null,
    confirmPasswordSupportingText: String? = null,
    isPasswordVisible: Boolean = false,
    isConfirmPasswordVisible: Boolean = false,
    onPasswordVisibilityChange: () -> Unit = {},
    onConfirmPasswordVisibilityChange: () -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        NoteMarkTextField(
            text = usernameText,
            onValueChange = onUsernameTextChange,
            label = stringResource(R.string.username),
            hint = stringResource(R.string.username_hint),
            isInputSecret = false,
            modifier = Modifier.fillMaxWidth(),
            isError = usernameSupportingText != null,
            supportingText = usernameSupportingText,
            isPasswordVisible = false,
            onPasswordVisibilityChange = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        NoteMarkTextField(
            text = emailText,
            onValueChange = onEmailTextChange,
            label = stringResource(R.string.email),
            hint = stringResource(R.string.email_hint),
            isInputSecret = false,
            modifier = Modifier.fillMaxWidth(),
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
            modifier = Modifier.fillMaxWidth(),
            isError = passwordSupportingText != null,
            supportingText = passwordSupportingText,
            isPasswordVisible = isPasswordVisible,
            onPasswordVisibilityChange = { onPasswordVisibilityChange() }
        )
        Spacer(modifier = Modifier.height(16.dp))
        NoteMarkTextField(
            text = confirmPasswordText,
            onValueChange = onConfirmPasswordTextChange,
            label = stringResource(R.string.confirm_password),
            hint = stringResource(R.string.password_hint),
            isInputSecret = true,
            modifier = Modifier.fillMaxWidth(),
            isError = confirmPasswordSupportingText != null,
            supportingText = confirmPasswordSupportingText,
            isPasswordVisible = isConfirmPasswordVisible,
            onPasswordVisibilityChange = { onConfirmPasswordVisibilityChange() }
        )
        Spacer(modifier = Modifier.height(24.dp))
        NoteMarkFilledButton(
            text = stringResource(R.string.create_account),
            onClick = { onCreateAccountClick() },
            modifier = Modifier.fillMaxWidth(),
            enabled = usernameText.isNotBlank() && emailText.isNotBlank() && passwordText.isNotBlank() && confirmPasswordText.isNotBlank()
        )
        Spacer(modifier = Modifier.height(16.dp))
        NoteMarkLink(
            text = stringResource(R.string.already_have_account),
            onClick = { onAlreadyHaveAccountClick() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterFormSectionPreview() {
    NoteMarkTheme {
        Box(
            modifier = Modifier.padding(16.dp),
        ) {
            RegisterFormSection(
                usernameText = "",
                onUsernameTextChange = {},
                emailText = "",
                onEmailTextChange = {},
                passwordText = "",
                onPasswordTextChange = {},
                confirmPasswordText = "",
                onConfirmPasswordTextChange = {},
                onCreateAccountClick = {},
                onAlreadyHaveAccountClick = {},
                modifier = Modifier
            )
        }
    }
}