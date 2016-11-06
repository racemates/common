package se.racemates.lang;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.NotNull;

@JsonSerialize(using = WrapperSerializer.class)
public abstract class Wrapper<T> {

    private final T value;

    protected Wrapper(final T value) {
        this.value = value;
    }

    @NotNull
    public T get() {
        return value;
    }

    @Override
    public boolean equals(final Object other) {
        return this
                .getClass()
                .isInstance(other)
                && ((Wrapper<T>) other).value.equals(this.value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

}
