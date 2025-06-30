package dev.gaddal.core.presentation.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen : NavKey {
    @Serializable
    data object Auth : Screen()

    @Serializable
    data object Notes : Screen()
}