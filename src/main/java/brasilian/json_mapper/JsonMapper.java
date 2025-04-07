package brasilian.json_mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * A generic JSON mapper class that provides functionality to convert between
 * JSON and Java objects.
 * This class supports both simple object mapping and field-based JSON
 * generation.
 *
 * @param <T> The type of object to be mapped
 */
public class JsonMapper<T> {
    private Object o = null;
    Map.Entry<String, Object>[] pairs = null;

    /**
     * Default constructor
     */
    public JsonMapper() {
    }

    /**
     * Constructor that takes an object to be converted to JSON
     *
     * @param o The object to be converted
     */
    public JsonMapper(Object o) {
        this.o = o;
    }

    /**
     * Converts the current object or fields to JSON string
     *
     * @return JSON string representation
     * @throws JsonProcessingException if JSON processing fails
     */
    public String toJson() throws JsonProcessingException {
        if (o == null) {
            return fieldsToJson();
        }

        var objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }

    /**
     * Sets the fields to be converted to JSON
     *
     * @param args Variable number of key-value pairs
     * @return The current JsonMapper instance for method chaining
     */
    @SafeVarargs
    public final JsonMapper<T> fromFields(Map.Entry<String, Object>... args) {
        this.pairs = args;
        return this;
    }

    /**
     * Converts the current fields to JSON string
     *
     * @return JSON string representation of the fields
     * @throws JsonProcessingException if JSON processing fails
     */
    private String fieldsToJson() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        Map<String, Object> jsonMap = new HashMap<>();

        // Adding all key-value pairs to the map
        for (Map.Entry<String, Object> entry : pairs) {
            jsonMap.put(entry.getKey(), entry.getValue());
        }

        return mapper.writeValueAsString(jsonMap);
    }

    /**
     * Converts a JSON string to an object of the specified class
     *
     * @param json  The JSON string to convert
     * @param klass The target class
     * @return An instance of the target class
     * @throws JsonProcessingException if JSON processing fails
     */
    public T fromJsonToTargetClass(String json, Class<T> klass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Ignore unknown properties in JSON
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(json, klass);
    }

    /**
     * Converts a JSON string to an object using TypeReference
     *
     * @param json          The JSON string to convert
     * @param typeReference The TypeReference specifying the target type
     * @return An instance of the target type
     * @throws JsonProcessingException if JSON processing fails
     */
    public T fromJsonToTargetClass(String json, TypeReference<T> typeReference) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(json, typeReference);
    }
}
