package com.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocatorLoader {
    public static Map<String, String> getLocators(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        String resourcePath = "locators/" + fileName + ".json";

        try (InputStream is = LocatorLoader.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new RuntimeException("Locator file not found in resources: " + resourcePath);
            }
            return mapper.readValue(is, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load locators from file: " + resourcePath, e);
        }
    }
}