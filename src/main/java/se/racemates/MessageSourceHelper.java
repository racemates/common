package se.racemates;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class MessageSourceHelper {

    private static final Object[] DEFAULT_ARGS = new Object[]{};

    private final MessageSource messageSource;
    private final Locale locale;

    public MessageSourceHelper(
            final MessageSource messageSource,
            final Locale locale
    ) {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    public String getMessage(final String key) {
        return this.messageSource.getMessage(key, DEFAULT_ARGS, locale);
    }
}
