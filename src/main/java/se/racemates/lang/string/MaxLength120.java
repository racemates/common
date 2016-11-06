package se.racemates.lang.string;

public interface MaxLength120 extends MaxLength {
    default int maxLength() {
        return 120;
    }
}
