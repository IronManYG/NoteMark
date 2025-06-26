package dev.gaddal.core.presentation.designsystem.colors

import androidx.compose.material3.lightColorScheme

/**
 * Single light theme colour scheme that relies **exclusively**
 * on the ten tokens defined in [AppColors].
 */
val AppColorScheme = lightColorScheme(
    /* Brand */
    primary = AppColors.Primary,
    onPrimary = AppColors.OnPrimary,
    primaryContainer = AppColors.Primary10,
    onPrimaryContainer = AppColors.OnPrimary,

    /* Surfaces */
    surface = AppColors.Surface,
    onSurface = AppColors.OnSurface,
    surfaceVariant = AppColors.Surface,
    onSurfaceVariant = AppColors.OnSurfaceVariant,
    surfaceTint = AppColors.Primary,

    /* Error */
    error = AppColors.Error,
    onError = AppColors.OnPrimary,

    /* Outlines / dividers */
    outline = AppColors.OnSurface12,
)
