package dev.gaddal.notemark.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import dev.gaddal.core.presentation.ui.navigation.Screen

@Composable
fun NavigationRoot() {
    val checked = true // Placeholder for any condition you might want to check
    val backStack = rememberNavBackStack<Screen>(if (checked) Screen.Auth else Screen.Notes)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Screen.Auth> {
                AuthNavigationRoot(
                    navigateToNotes = {
                        backStack.add(Screen.Notes)
                    }
                )
            }
            entry<Screen.Notes> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = { backStack.removeLastOrNull() }) {
                        Text(text = "Navigate Back")
                    }
                }
            }
        }
    )
}