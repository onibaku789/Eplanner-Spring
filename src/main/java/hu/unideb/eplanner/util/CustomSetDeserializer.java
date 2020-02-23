package hu.unideb.eplanner.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CustomSetDeserializer<T> extends StdDeserializer<Set<T>> {

    protected CustomSetDeserializer(Class<?> vc) {
        super(vc);
    }

    protected CustomSetDeserializer(JavaType valueType) {
        super(valueType);
    }

    protected CustomSetDeserializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public Set<T> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return new HashSet<>();
    }
}
