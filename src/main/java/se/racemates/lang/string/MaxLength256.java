package se.racemates.lang.string;

public interface MaxLength256 extends MaxLength {
    default int maxLength() {
        return 256;
    }
}
