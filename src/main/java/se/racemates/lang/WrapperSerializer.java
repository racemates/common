package se.racemates.lang;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class WrapperSerializer extends JsonSerializer<Wrapper> {
    @Override
    public void serialize(
            final Wrapper wrapper,
            final JsonGenerator jsonGenerator,
            final SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeString(wrapper.toString());
    }
}
