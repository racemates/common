package se.racemates.lang;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = WrapperSerializer.class)
public abstract class Wrapper<T> {

    private final T value;

    protected Wrapper(final T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Wrapper<?> wrapper = (Wrapper<?>) o;

        return value.equals(wrapper.value);
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
