package szeweq.desktopose.progress;

import androidx.compose.runtime.MutableState;

import static androidx.compose.runtime.SnapshotStateKt.mutableStateOf;
import static androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy;

public class MessageProgressState extends ProgressState {
    private final MutableState<String> ms = mutableStateOf("", structuralEqualityPolicy());

    public String getMessage() {
        return ms.getValue();
    }

    public void setMessage(String message) {
        ms.setValue(message);
    }
}
