package dev.gaddal.core.presentation.designsystem.util

import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

/**
 * Represents the current device configuration based on screen size and orientation.
 * This enumeration helps in adapting UI layouts according to different device types and orientations.
 */
enum class DeviceConfiguration {
    /**
     * Represents a mobile device in portrait orientation.
     * Typically has narrow width and tall height.
     */
    MOBILE_PORTRAIT,

    /**
     * Represents a mobile device in landscape orientation.
     * Typically has wide width and short height.
     */
    MOBILE_LANDSCAPE,

    /**
     * Represents a tablet device in portrait orientation.
     * Typically has medium width and expanded height.
     */
    TABLET_PORTRAIT,

    /**
     * Represents a tablet device in landscape orientation.
     * Typically has expanded width and medium/compact height.
     */
    TABLET_LANDSCAPE,

    /**
     * Represents a desktop configuration.
     * Used as a fallback for any configuration that doesn't match other defined types.
     */
    DESKTOP;

    companion object {
        /**
         * Determines the device configuration based on the provided [WindowSizeClass].
         * Uses width and height classifications to identify the appropriate device configuration.
         *
         * @param windowSizeClass The size classification of the window provided by the system
         * @return The corresponding [DeviceConfiguration] for the given window size
         */
        fun fromWindowSizeClass(windowSizeClass: WindowSizeClass): DeviceConfiguration =
            when (windowSizeClass.windowWidthSizeClass) {
                // ---------------- Phones ----------------
                WindowWidthSizeClass.COMPACT -> MOBILE_PORTRAIT

                WindowWidthSizeClass.MEDIUM -> when (windowSizeClass.windowHeightSizeClass) {
                    WindowHeightSizeClass.COMPACT,
                    WindowHeightSizeClass.MEDIUM -> MOBILE_LANDSCAPE

                    else -> TABLET_PORTRAIT          // safety-net for EXPANDED or future values
                }

                // ---------------- Tablets & larger -------
                WindowWidthSizeClass.EXPANDED -> when (windowSizeClass.windowHeightSizeClass) {
                    WindowHeightSizeClass.EXPANDED -> TABLET_PORTRAIT
                    WindowHeightSizeClass.MEDIUM,
                    WindowHeightSizeClass.COMPACT -> TABLET_LANDSCAPE

                    else -> TABLET_LANDSCAPE         // fallback for any new value
                }

                // Anything unrecognised (desktop mode, large monitor, etc.)
                else -> DESKTOP
            }
    }
}