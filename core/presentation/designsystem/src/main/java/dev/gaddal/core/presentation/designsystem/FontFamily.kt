package dev.gaddal.core.presentation.designsystem

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

/**
 * NOTE:
 *  ── Space Grotesk is used for all “Title” styles.
 *  ── Inter is used for every “Body” style.
 */
object AppFontFamilies {

    /* ─── Space Grotesk ───────────────────────────── */
    val SpaceGrotesk = FontFamily(
        Font(R.font.space_grotesk_regular, FontWeight.Normal),
        Font(R.font.space_grotesk_medium, FontWeight.Medium),
        Font(R.font.space_grotesk_bold, FontWeight.Bold)
    )

    /* ─── Inter ──────────────────────────────────── */
    val Inter = FontFamily(
        Font(R.font.inter_regular, FontWeight.Normal),
        Font(R.font.inter_medium, FontWeight.Medium)
    )

    /* ─── Cairo ──────────────────────────────────── */
    val Cairo = FontFamily(
        Font(R.font.cairo_regular, FontWeight.Normal),
        Font(R.font.cairo_medium, FontWeight.Medium),
        Font(R.font.cairo_bold, FontWeight.Bold)
    )
}
