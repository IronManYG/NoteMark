package dev.gaddal.core.presentation.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.gaddal.core.presentation.designsystem.NoteMarkTheme

/**
 * A filled button with the NoteMark design style
 */
@Composable
fun NoteMarkFilledButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    isIconEnd: Boolean = false,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    val buttonShape = RoundedCornerShape(10.dp)
    val buttonContentPadding = PaddingValues(12.dp)

    Button(
        onClick = onClick,
        modifier = modifier,
        shape = buttonShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        contentPadding = buttonContentPadding
    ) {
        ButtonContent(
            text = text,
            icon = icon,
            isIconEnd = isIconEnd
        )
    }
}

/**
 * An outlined button with the NoteMark design style
 */
@Composable
fun NoteMarkOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    isIconEnd: Boolean = false,
    borderColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.primary
) {
    val buttonShape = RoundedCornerShape(10.dp)
    val buttonContentPadding = PaddingValues(12.dp)

    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        shape = buttonShape,
        border = BorderStroke(1.dp, borderColor),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = contentColor
        ),
        contentPadding = buttonContentPadding
    ) {
        ButtonContent(
            text = text,
            icon = icon,
            isIconEnd = isIconEnd
        )
    }
}

/**
 * Shared button content used by both button variants
 */
@Composable
private fun ButtonContent(
    text: String,
    icon: ImageVector?,
    isIconEnd: Boolean
) {
    if (icon != null && !isIconEnd) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
    }

    Text(
        text = text,
        style = MaterialTheme.typography.titleSmall
    )

    if (icon != null && isIconEnd) {
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
    }
}

// Previews
@Preview(showBackground = true)
@Composable
fun NoteMarkFilledButtonPreview() {
    NoteMarkTheme {
        NoteMarkFilledButton(
            text = "Filled Button",
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NoteMarkOutlinedButtonPreview() {
    NoteMarkTheme {
        NoteMarkOutlinedButton(
            text = "Outlined Button",
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "Filled Button with start icon")
@Composable
fun NoteMarkFilledButtonWithStartIconPreview() {
    NoteMarkTheme {
        NoteMarkFilledButton(
            text = "Button with Icon",
            onClick = {},
            icon = Icons.Default.Add,
            isIconEnd = false,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "Outlined Button with start icon")
@Composable
fun NoteMarkOutlinedButtonWithStartIconPreview() {
    NoteMarkTheme {
        NoteMarkOutlinedButton(
            text = "Outlined with Icon",
            onClick = {},
            icon = Icons.Default.Add,
            isIconEnd = false,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "Blue Outlined Button")
@Composable
fun NoteMarkBlueOutlinedButtonPreview() {
    NoteMarkTheme {
        NoteMarkOutlinedButton(
            text = "Blue Outlined",
            onClick = {},
            borderColor = Color(0xFF4169E1), // Royal Blue color
            contentColor = Color(0xFF4169E1),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true, name = "Black Outlined Button")
@Composable
fun NoteMarkBlackOutlinedButtonPreview() {
    NoteMarkTheme {
        NoteMarkOutlinedButton(
            text = "Black Outlined",
            onClick = {},
            borderColor = Color.Black,
            contentColor = Color.Black,
            modifier = Modifier.padding(16.dp)
        )
    }
}
