package szeweq.desktopose.core;

import java.util.Objects;

/**
 * An interface that accepts two long numbers.
 */
@FunctionalInterface
public interface LongBiConsumer {
    void accept(long l, long r);

    default LongBiConsumer andThen(LongBiConsumer after) {
        Objects.requireNonNull(after);

        return (l, r) -> {
            accept(l, r);
            after.accept(l,r);
        };
    }

    LongBiConsumer DUMMY = (l, r) -> {};
}
