package dev.gaddal.notemark.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import dev.gaddal.core.presentation.ui.navigation.AuthNav
import dev.gaddal.feature.auth.presentation.landing.LandingRoot
import dev.gaddal.feature.auth.presentation.login.LoginRoot
import dev.gaddal.feature.auth.presentation.registration.RegisterRoot

@Composable
fun AuthNavigationRoot(navigateToNotes: () -> Unit) {
    val backStack = rememberNavBackStack<AuthNav>(AuthNav.Landing)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<AuthNav.Landing> {
                LandingRoot(
                    onLoginClick = { backStack.add(AuthNav.Login) },
                    onGetStartedClick = { backStack.add(AuthNav.Register) }
                )
            }
            entry<AuthNav.Login> {
                LoginRoot(
                    onLoginClick = { navigateToNotes() },
                    onDontHaveAccountClick = { backStack.add(AuthNav.Register) }
                )
            }
            entry<AuthNav.Register> {
                RegisterRoot(
                    onCreateAccountClick = { navigateToNotes() },
                    onAlreadyHaveAccountClick = { backStack.add(AuthNav.Login) }
                )
            }
        }
    )
}