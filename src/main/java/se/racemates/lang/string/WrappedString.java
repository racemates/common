package se.racemates.lang.string;

import se.racemates.lang.Wrapper;

public class WrappedString extends Wrapper<String> implements MaxLength {

    protected WrappedString(final String value) {
        super(value);
        if (value.length() > this.maxLength()) {
            throw new IllegalArgumentException("String is too long:" + value.length());
        }
    }
}
