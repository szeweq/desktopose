package szeweq.desktopose.core

import androidx.compose.runtime.*

/**
 * This is an inline version of [CompositionLocalProvider]
 */
@OptIn(InternalComposeApi::class)
@Composable
inline fun withProviders(vararg values: ProvidedValue<*>, fn: @Composable () -> Unit) {
    currentComposer.startProviders(values)
    fn()
    currentComposer.endProviders()
}