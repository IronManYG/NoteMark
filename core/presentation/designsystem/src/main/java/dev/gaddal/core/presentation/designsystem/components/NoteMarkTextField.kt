package dev.gaddal.core.presentation.designsystem.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.gaddal.core.presentation.designsystem.AppIcons
import dev.gaddal.core.presentation.designsystem.NoteMarkTheme

@Composable
fun NoteMarkTextField(
    text: String,
    onValueChange: (String) -> Unit,
    label: String,
    hint: String,
    isInputSecret: Boolean,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    supportingText: String? = null,
    isPasswordVisible: Boolean = false,
    onPasswordVisibilityChange: (Boolean) -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(7.dp))
        OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (isInputSecret && !isPasswordVisible) {
                PasswordVisualTransformation(mask = '*')
            } else VisualTransformation.None,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                cursorColor = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                focusedBorderColor = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = if (isError) MaterialTheme.colorScheme.error.copy(alpha = 0.5f) else Color.Transparent,
                errorCursorColor = MaterialTheme.colorScheme.error,
                errorBorderColor = MaterialTheme.colorScheme.error,
                errorContainerColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.bodyLarge
                )
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            shape = RoundedCornerShape(10.dp),
            isError = isError,
            trailingIcon = {
                if (isInputSecret) {
                    IconButton(
                        onClick = {
                            onPasswordVisibilityChange(!isPasswordVisible)
                        }
                    ) {
                        when {
                            isPasswordVisible -> {
                                Icon(
                                    imageVector = AppIcons.Eye,
                                    contentDescription = "Hide password",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            !isPasswordVisible -> {
                                Icon(
                                    imageVector = AppIcons.EyeOff,
                                    contentDescription = "Show password",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        )

        if (!supportingText.isNullOrEmpty()) {
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = supportingText,
                modifier = Modifier.padding(start = 12.dp),
                style = MaterialTheme.typography.bodySmall,
                color = when {
                    isError -> MaterialTheme.colorScheme.error
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun NoteMarkTextFieldAllStatesPreview() {
    NoteMarkTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            var regularText = remember { mutableStateOf("Regular text field") }
            var passwordText = remember { mutableStateOf("Hidden password") }
            var visiblePasswordText = remember { mutableStateOf("Visible password") }
            var errorText = remember { mutableStateOf("Field with error") }
            var errorPasswordText = remember { mutableStateOf("Password with error") }

            var passwordVisible1 = remember { mutableStateOf(false) }
            var passwordVisible2 = remember { mutableStateOf(true) }
            var passwordVisible3 = remember { mutableStateOf(false) }

            // Regular text field
            NoteMarkTextField(
                text = regularText.value,
                onValueChange = { regularText.value = it },
                label = "Regular Field",
                hint = "Enter text",
                isInputSecret = false,
                supportingText = "This is regular text field"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password field (hidden)
            NoteMarkTextField(
                text = passwordText.value,
                onValueChange = { passwordText.value = it },
                label = "Password Field (Hidden)",
                hint = "Enter password",
                isInputSecret = true,
                supportingText = "Password is hidden",
                isPasswordVisible = passwordVisible1.value,
                onPasswordVisibilityChange = { passwordVisible1.value = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password field (visible)
            NoteMarkTextField(
                text = visiblePasswordText.value,
                onValueChange = { visiblePasswordText.value = it },
                label = "Password Field (Visible)",
                hint = "Enter password",
                isInputSecret = true,
                supportingText = "Password is visible",
                isPasswordVisible = passwordVisible2.value,
                onPasswordVisibilityChange = { passwordVisible2.value = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Error text field
            NoteMarkTextField(
                text = errorText.value,
                onValueChange = { errorText.value = it },
                label = "Error Field",
                hint = "Enter text",
                isInputSecret = false,
                isError = true,
                supportingText = "This field has an error"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Error password field
            NoteMarkTextField(
                text = errorPasswordText.value,
                onValueChange = { errorPasswordText.value = it },
                label = "Password with Error",
                hint = "Enter password",
                isInputSecret = true,
                isError = true,
                supportingText = "Password field with error",
                isPasswordVisible = passwordVisible3.value,
                onPasswordVisibilityChange = { passwordVisible3.value = it }
            )
        }
    }
}
