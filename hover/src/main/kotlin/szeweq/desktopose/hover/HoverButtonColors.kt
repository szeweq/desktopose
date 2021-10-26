package szeweq.desktopose.hover

import androidx.compose.material.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

/**
 * A [ButtonColors] that supports mixing colors with [hoverColor]
 * while [hover] is `true`
 */
class HoverButtonColors(
    private val hover: State<Boolean>,
    private val defaultColors: Pair<Color, Color>,
    private val disabledColors: Pair<Color, Color>,
    private val hoverColor: Color
): ButtonColors {
    @Composable
    override fun backgroundColor(enabled: Boolean): State<Color> {
        val cp = if (enabled) defaultColors else disabledColors
        return rememberUpdatedState(if (hover.value) hoverColor.compositeOver(cp.first) else cp.first)

    }

    @Composable
    override fun contentColor(enabled: Boolean): State<Color> {
        val cp = if (enabled) defaultColors else disabledColors
        return rememberUpdatedState(if (hover.value) hoverColor.compositeOver(cp.second) else cp.second)
    }

}