package se.racemates.lang.string;

public interface MaxLength32 extends MaxLength {
    default int maxLength() {
        return 32;
    }
}
