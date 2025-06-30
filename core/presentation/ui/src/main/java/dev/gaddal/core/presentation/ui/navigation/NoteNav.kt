package dev.gaddal.core.presentation.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class NoteNav : NavKey {
    @Serializable
    data object NoteList : NoteNav()

    @Serializable
    data class NoteDetail(val id: Int) : NoteNav()
}