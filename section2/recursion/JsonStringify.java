package section2.recursion;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JsonStringify {
    public static void main(String[] args) {
        // Serialize
        Map<String, String> message = new HashMap<>() {{
            put("sender", "roki");
            put("receiver", "toki");
            put("message", "Hello World!");
            put("createdAt", "2022-09-21,15:12:31");
        }};

        ObjectMapper serializeMapper = new ObjectMapper();
        String jsonStringify = serializeMapper.writeValueAsString(message);
        System.out.println(jsonStringify);


        // Deserialize
        ObjectMapper deserializeMapper = new ObjectMapper();
        String jsonStringified = "{\"createdAt\":\"2022-09-21,15:12:31\",\"receiver\":\"roki\",\"sender\":\"toki\",\"message\":\"Hello World!\"}";

        Map<String, String> deserializedData = deserializeMapper.readValue(jsonStringified, Map.class);
        System.out.println(deserializedData);
    }
}