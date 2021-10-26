package szeweq.desktopose.progress

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.autoSaver
import androidx.compose.runtime.setValue
import szeweq.desktopose.core.LongBiConsumer

/**
 * A state object for displaying and updating values in process-related tasks (like downloading a file).
 */
open class ProgressState : LongBiConsumer {
    var value: Float by mutableStateOf(Float.MAX_VALUE)

    val isActive: Boolean
        get() = value <= 1f
    val isIndeterminate: Boolean
        get() = value == -1f

    fun setIndeterminate() {
        value = -1f
    }

    fun setFinished() {
        value = Float.MAX_VALUE
    }

    override fun accept(l: Long, r: Long) {
        value = l.toFloat() / r
    }

    companion object {
        val Saver: Saver<ProgressState, *> = Saver(
            save = { it.value },
            restore = { ProgressState().apply { value = it } }
        )
    }
}