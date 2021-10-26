package szeweq.desktopose.core

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit

/**
 * Returns a simple text component that only uses [text] and [fontSize] parameters.
 * It saves a lot of bytecode size if used inside scoped components (rows, columns, buttons, etc.).
 */
@Composable
fun UseScopeText(
    text: String,
    fontSize: TextUnit = TextUnit.Unspecified,
    style: TextStyle? = null
): @Composable Any.() -> Unit = {
    val textStyle = style ?: LocalTextStyle.current
    Text(text, fontSize = fontSize, style = textStyle)
}

/**
 * Returns a simple text component that only uses [text] and [fontSize] parameters.
 * It saves a lot of bytecode size if used inside another component that does not use any scope.
 */
@Composable
fun UseText(
    text: String,
    fontSize: TextUnit = TextUnit.Unspecified,
    style: TextStyle? = null
): @Composable () -> Unit = {
    val textStyle = style ?: LocalTextStyle.current
    Text(text, fontSize = fontSize, style = textStyle)
}