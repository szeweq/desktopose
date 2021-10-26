package szeweq.desktopose.progress

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun rememberProgressState() = rememberSaveable(
    saver = ProgressState.Saver
) { ProgressState() }

@Composable
fun rememberMessageProgressState() = rememberSaveable(
    saver = MessageProgressState.Saver
) { MessageProgressState() }

@Composable
fun LinearIndicator(
    progressState: ProgressState,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary
) {
    if (progressState.isIndeterminate) {
        LinearProgressIndicator(modifier, color)
    } else {
        LinearProgressIndicator(progressState.value, modifier, color)
    }
}

@Composable
fun ProgressCard(
    msgProgress: MessageProgressState,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary
) = Card(modifier) { Column {
    Text(msgProgress.message, Modifier.padding(8.dp))
    LinearIndicator(msgProgress, Modifier.fillMaxWidth(), color = color)
} }