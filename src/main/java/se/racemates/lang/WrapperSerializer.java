package se.racemates.lang;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class WrapperSerializer extends JsonSerializer<Wrapper> {
    @Override
    public void serialize(
            Wrapper wrapper,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider
    ) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(wrapper.toString());
    }
}
