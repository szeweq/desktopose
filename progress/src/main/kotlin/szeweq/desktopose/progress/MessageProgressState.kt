package szeweq.desktopose.progress

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.setValue

class MessageProgressState : ProgressState() {
    var message by mutableStateOf("")

    companion object {
        val Saver = listSaver<MessageProgressState, Any>(
            save = { listOf(it.value, it.message) },
            restore = { MessageProgressState().apply {
                value = (it[0] as Float)
                message = it[1] as String
            } }
        )
    }
}
