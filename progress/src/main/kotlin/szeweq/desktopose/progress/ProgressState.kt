package szeweq.desktopose.progress;

import androidx.compose.runtime.MutableState;
import szeweq.desktopose.core.LongBiConsumer;

import static androidx.compose.runtime.SnapshotStateKt.mutableStateOf;
import static androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy;

/**
 * A state object for displaying and updating values in process-related tasks (like downloading a file).
 */
public class ProgressState implements LongBiConsumer {
    private final MutableState<Float> state = mutableStateOf(Float.MAX_VALUE, structuralEqualityPolicy());

    public float getValue() {
        return state.getValue();
    }

    public void setValue(float v) {
        state.setValue(v);
    }

    public boolean isActive() {
        return getValue() <= 1f;
    }

    public boolean isIndeterminate() {
        return getValue() == -1f;
    }

    public void setIndeterminate() {
        setValue(-1f);
    }

    public void setFinished() {
        setValue(Float.MAX_VALUE);
    }

    @Override
    public void accept(long l, long r) {
        setValue(((float) l) / r);
    }
}
