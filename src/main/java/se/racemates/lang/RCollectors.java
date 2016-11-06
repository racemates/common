package se.racemates.lang;

import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RCollectors {

    public static <T> Collector<T, ?, T> singletonCollector(final Function<Void, Void> errorHandler) {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        errorHandler.apply(null);
                    }
                    return list.get(0);
                }
        );
    }

}
