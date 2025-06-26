package dev.gaddal.feature.auth.presentation.landing

/**
 * Actions that can be performed on the landing screen
 */
sealed interface LandingAction {
    /**
     * Action to navigate to the register screen
     */
    object Register : LandingAction

    /**
     * Action to navigate to the login screen
     */
    object Login : LandingAction
}
