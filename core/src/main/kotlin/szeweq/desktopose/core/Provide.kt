package szeweq.desktopose.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle

@Composable
@ReadOnlyComposable
infix fun ProvidableCompositionLocal<TextStyle>.providesMerged(value: TextStyle) =
    this provides this.current.merge(value)

@Composable
@ReadOnlyComposable
infix fun <T> ProvidableCompositionLocal<T>.providesFrom(other: CompositionLocal<T>) =
    this provides other.current