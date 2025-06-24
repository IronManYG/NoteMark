package dev.gaddal.core.presentation.designsystem.colors

import androidx.compose.ui.graphics.Color

/**
 * Centralised colour tokens for NoteMark.
 *
 * Exactly **10** colours are exposed—no more, no less.
 * Any translucent variants required by the design spec are
 * generated via `copy(alpha = …)` to avoid extra constants.
 */
object AppColors {

    /* ─── Brand ─────────────────────────────────────────────── */

    /** #5977F7  */
    val Primary = Color(0xFF5977F7)

    /** 10 % tint of Primary – used for subtle containers/state layers. */
    val Primary10 = Primary.copy(alpha = 0.10f)

    /** Text/icons atop Primary surfaces – #FFFFFF */
    val OnPrimary = Color(0xFFFFFFFF)

    /** 12 % tint of OnPrimary – pressed/dragged ripple on Primary. */
    val OnPrimary12 = OnPrimary.copy(alpha = 0.12f)


    /* ─── Surfaces ──────────────────────────────────────────── */

    /** Main surface colour – #EFEFF2 */
    val Surface = Color(0xFFEFEFF2)

    /** Window / lowest elevation – #FFFFFF */
    val SurfaceLowest = Color(0xFFFFFFFF)

    /** High-contrast surface text – #1B1B1C */
    val OnSurface = Color(0xFF1B1B1C)

    /** Muted surface text – #535364 */
    val OnSurfaceVariant = Color(0xFF535364)

    /** 12 % tint of OnSurface – borders, dividers, state layers. */
    val OnSurface12 = OnSurface.copy(alpha = 0.12f)


    /* ─── Feedback ─────────────────────────────────────────── */

    /** Error / destructive actions – #E1294B */
    val Error = Color(0xFFE1294B)
}
