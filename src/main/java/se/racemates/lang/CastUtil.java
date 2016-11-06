package se.racemates.lang;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CastUtil {

    public static <T> Optional<T> cast(@Nullable final Object object, Class<T> clazz) {
        return Optional.ofNullable(object).filter(o -> clazz.isAssignableFrom(o.getClass())).map(o -> (T) o);
    }
}
