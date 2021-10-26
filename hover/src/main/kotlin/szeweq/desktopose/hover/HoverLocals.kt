package szeweq.desktopose.hover

import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * [CompositionLocal] that contains a background color used when a pointer is hovering over an element.
 * It should be updated to a `MaterialTheme.colors.onSurface` with `alpha < 1f`.
 */
val LocalHoverColor = compositionLocalOf { Color.Black.copy(0.12f) }