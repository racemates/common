package se.racemates.lang;

public final class ExceptionUtil {

    public static boolean isCause(
            final Class<? extends Throwable> expected,
            final Throwable exception
    ) {
        return expected.isInstance(exception) || (
                exception != null && isCause(expected, exception.getCause())
        );
    }
}
