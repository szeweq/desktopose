package szeweq.desktopose.core

import androidx.compose.runtime.MutableState

/**
 * Method for binding specific values for use in an event.
 */
fun <T> MutableState<T>.bind(value: T): () -> Unit = { this.value = value }

/**
 * Creates a function with a bound value.
 */
fun <T> ((T) -> Unit).bind(value: T): () -> Unit = { this(value) }

/**
 * Joins two functions into one (calling in provided order).
 */
infix fun (() -> Unit).and(other: () -> Unit): () -> Unit = {
    this()
    other()
}