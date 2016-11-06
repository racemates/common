package se.racemates.lang.string;

public interface MaxLength {
    default int maxLength() {
        return Integer.MAX_VALUE;
    }
}
