package com.specsavers.core;

import java.util.HashMap;
import java.util.Map;

public class DSPSpecificHeaders {

    public Map<String, ?> getHeaders(String apiKey) {
        Map<String, String> headers = new HashMap<>();

        headers.put("Connection", "keep-alive");
        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", apiKey);

        return headers;
    }
}
