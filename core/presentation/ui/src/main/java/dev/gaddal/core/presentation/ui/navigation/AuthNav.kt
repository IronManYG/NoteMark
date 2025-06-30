package dev.gaddal.core.presentation.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class AuthNav : NavKey {
    @Serializable
    data object Landing : AuthNav()

    @Serializable
    data object Login : AuthNav()

    @Serializable
    data object Register : AuthNav()
}