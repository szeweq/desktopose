package szeweq.desktopose.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun <T> rememberInitialState(value: T): MutableState<T> = remember { mutableStateOf(value) }