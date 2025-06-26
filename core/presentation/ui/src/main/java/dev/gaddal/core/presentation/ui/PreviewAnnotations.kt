package dev.gaddal.core.presentation.ui

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers

/**
 * Annotation for previewing UI components in different locales (languages).
 *
 * This annotation previews the UI in both Arabic (RTL) and English (LTR) locales
 * to ensure proper bidirectional text support and text layout across different writing systems.
 */
@Preview(showBackground = true, locale = "ar", name = "Arabic (RTL)")
@Preview(showBackground = true, locale = "en", name = "English (LTR)")
annotation class LocalesPreview

/**
 * Annotation for previewing UI components in different themes (light and dark).
 *
 * This annotation previews the UI in both Light and Dark themes to ensure
 * proper color contrast and visibility across different theme modes.
 */
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Light Theme")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Theme")
annotation class ThemesPreview

/**
 * Annotation for previewing UI components with different font scales (sizes).
 *
 * This annotation previews the UI with various font scales to test accessibility
 * and responsiveness for users who prefer different text sizes.
 */
@Preview(showBackground = true, fontScale = 1.0f, name = "Default Font (100%)")
@Preview(showBackground = true, fontScale = 0.85f, name = "Small Font (85%)")
@Preview(showBackground = true, fontScale = 1.15f, name = "Large Font (115%)")
@Preview(showBackground = true, fontScale = 1.3f, name = "Largest Font (130%)")
annotation class FontScalePreview

/**
 * Annotation for previewing UI components on different devices.
 *
 * This annotation previews the UI on various device types to ensure
 * compatibility and proper layout across the device spectrum.
 */
@Preview(showBackground = true, name = "Phone", device = "id:pixel_9")
@Preview(showBackground = true, name = "Phone Landscape", device = "id:pixel_9", widthDp = 800, heightDp = 400)
@Preview(showBackground = true, name = "Foldable", device = "id:pixel_9_pro_fold")
@Preview(showBackground = true, name = "Tablet", device = "id:pixel_c")
@Preview(showBackground = true, name = "Desktop", device = "id:desktop_medium")
annotation class DevicesPreview

/**
 * Annotation specifically for previewing phone form factors with different screen sizes.
 *
 * Use this to test UI components specifically on phone-sized devices.
 */
@Preview(showBackground = true, name = "Phone - Small", device = "id:pixel_5")
@Preview(showBackground = true, name = "Phone - Medium", device = "id:pixel_9")
@Preview(showBackground = true, name = "Phone - Large", device = "id:pixel_9_pro")
annotation class PhonePreview

/**
 * Annotation for previewing phone form factors in landscape orientation.
 *
 * Use this to test UI components specifically on phone-sized devices in landscape mode.
 */
@Preview(showBackground = true, name = "Phone - Small Landscape", device = "id:pixel_5", widthDp = 800, heightDp = 400)
@Preview(showBackground = true, name = "Phone - Medium Landscape", device = "id:pixel_9", widthDp = 800, heightDp = 400)
@Preview(showBackground = true, name = "Phone - Large Landscape", device = "id:pixel_9_pro", widthDp = 900, heightDp = 400)
annotation class PhonePreviewLandscape

/**
 * Annotation for previewing tablet and larger form factors.
 *
 * Use this to test UI components on larger screen devices.
 */
@Preview(showBackground = true, name = "Small Tablet", device = "id:pixel_tablet")
@Preview(showBackground = true, name = "Small Tablet Portrait", device = "id:pixel_tablet", widthDp = 800, heightDp = 1280)
@Preview(showBackground = true, name = "Medium Tablet", device = "id:pixel_c")
@Preview(showBackground = true, name = "Medium Tablet Portrait", device = "id:pixel_c", widthDp = 800, heightDp = 1280)
@Preview(showBackground = true, name = "Large Desktop", device = "id:desktop_large")
annotation class LargeScreenPreview

/**
 * Annotation for previewing UI components with different wallpapers.
 *
 * This helps ensure components remain visually accessible against
 * various wallpaper types and color schemes.
 */
@Preview(showBackground = false, name = "Blue Wallpaper", wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE)
@Preview(showBackground = false, name = "Red Wallpaper", wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE)
@Preview(showBackground = false, name = "Green Wallpaper", wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE)
annotation class WallpaperPreview

/**
 * Annotation for previewing UI components with specific accessibility features.
 *
 * Use this to test how your components work with various accessibility settings.
 */
@FontScalePreview
@Preview(showBackground = true, fontScale = 1.0f, name = "Default Contrast")
@Preview(showBackground = true, fontScale = 1.0f, uiMode = Configuration.UI_MODE_NIGHT_YES or 0x20, name = "High Contrast")
annotation class AccessibilityPreview

/**
 * Comprehensive preview annotation that combines the most common testing scenarios.
 *
 * Use this for quickly testing components across the most important variations
 * like themes and device sizes.
 */
@ThemesPreview
@DevicesPreview
annotation class ComprehensivePreview

/**
 * Complete test preview that covers all major variation points.
 *
 * Use this when you need to thoroughly test a component across many dimensions.
 * Note: This generates many previews so use selectively.
 */
@ThemesPreview
@DevicesPreview
@FontScalePreview
@LocalesPreview
annotation class CompleteTestPreview
