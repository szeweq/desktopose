package szeweq.desktopose.hover

import androidx.compose.foundation.background
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput

/**
 * Updates hover state when pointer enters or exits the component.
 */
fun Modifier.hoverState(cb: (Boolean) -> Unit) = pointerInput(cb) {
    awaitPointerEventScope {
        while (true) {
            val event = awaitPointerEvent()
            when (event.type) {
                PointerEventType.Enter -> {
                    cb(true)
                }
                PointerEventType.Exit -> {
                    cb(false)
                }
            }
        }
    }
}

/**
 * Uses [hoverState] to draw a [shape] with [color] as background.
 * Background colors can be mixed if a hover color has `alpha < 1f`.
 */
fun Modifier.hover(
    color: Color = Color.Unspecified,
    shape: Shape = RectangleShape
) = composed {
    val (hover, setHover) = remember { mutableStateOf(false) }
    val mod = hoverState(setHover)
    if (hover) mod.background(color.takeOrElse { LocalHoverColor.current }, shape) else mod
}