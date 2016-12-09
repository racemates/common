package se.racemates.lang;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(using = WrapperSerializer.class)
public abstract class Wrapper<T> implements Serializable {

    private final T value;

    protected Wrapper(final T value) {
        this.value = value;
    }

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
