package dev.gaddal.core.presentation.designsystem

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.gaddal.core.presentation.designsystem.util.LocaleUtils

/* ─── Locale helpers ───────────────────── */

@Composable
@ReadOnlyComposable
private fun displayFont(): FontFamily {
    val lang = LocaleUtils.getCurrentLocale(LocalContext.current).language
    return if (lang == "ar") AppFontFamilies.Cairo else AppFontFamilies.SpaceGrotesk
}

@Composable
@ReadOnlyComposable
private fun bodyFont(): FontFamily {
    val lang = LocaleUtils.getCurrentLocale(LocalContext.current).language
    return if (lang == "ar") AppFontFamilies.Cairo else AppFontFamilies.Inter
}

/* ─── Standard Material-3 overrides ───────────────────────────────────── */

val AppTypography: Typography
    @Composable
    @ReadOnlyComposable
    get() = Typography(
        /*— Titles that DO have matching tokens —*/
        titleLarge = TextStyle(                 // Figma: Title Large (32/36 Bold)
            fontFamily = displayFont(),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            lineHeight = 36.sp
        ),
        titleSmall = TextStyle(                 // Figma: Title Small (17/24 Med)
            fontFamily = displayFont(),
            fontWeight = FontWeight.Medium,
            fontSize = 17.sp,
            lineHeight = 24.sp
        ),

        /*— Body styles —*/
        bodyLarge = TextStyle(                  // 17/24 Regular
            fontFamily = bodyFont(),
            fontWeight = FontWeight.Normal,
            fontSize = 17.sp,
            lineHeight = 24.sp
        ),
        bodyMedium = TextStyle(                 // 15/20 Medium
            fontFamily = bodyFont(),
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            lineHeight = 20.sp
        ),
        bodySmall = TextStyle(                  // 13/18 Regular
            fontFamily = bodyFont(),
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
            lineHeight = 18.sp
        )
        /* everything else falls back to Material defaults */
    )

/* ─── Non-standard styles live here ───────────────────────────────────── */

/**
 * CustomTextStyles defines additional custom text styles for the app.
 * These styles are not part of the standard Material 3 typography.
 */
object CustomTextStyles {

    /**
     * Title x-Large (36 / 40 Bold) – not in the Material 3 scale.
     *
     * Usage example:
     * ```kotlin
     * Text(
     *     text = "Welcome",
     *     style = CustomTextStyles.TitleXLarge
     * )
     * ```
     */
    val TitleXLarge: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = TextStyle(
            fontFamily = displayFont(),
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            lineHeight = 40.sp
        )
}
