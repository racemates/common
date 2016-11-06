package se.racemates.lang.string;

public interface MaxLength36 extends MaxLength {
    default int maxLength() {
        return 36;
    }
}
