package CreationalDesignPatterns.Builder.Example.app;

import CreationalDesignPatterns.Builder.Example.builder.HttpRequestBuilder;
import CreationalDesignPatterns.Builder.Example.product.HttpRequest;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== HTTP Request Builder (Builder Pattern) ======\n");

        // --- Use Case 1: Simple GET Request ---
        // Only URL is required, method defaults to GET, no headers, no body, default timeout.
        HttpRequest simpleGetRequest = new HttpRequestBuilder("https://api.example.com/data")
                .build();
        System.out.println(simpleGetRequest);

        // --- Use Case 2: Complex POST Request with Headers and Body ---
        HttpRequest postRequest = new HttpRequestBuilder("https://api.example.com/submit")
                .setMethod("POST")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer your_token_here")
                .setBody("{\"name\": \"Test User\", \"age\": 30}")
                .setTimeout(60) // 60 seconds timeout
                .build();
        System.out.println(postRequest);

        // --- Use Case 3: GET Request with Custom Timeout ---
        HttpRequest customTimeoutGetRequest = new HttpRequestBuilder("https://api.example.com/long-process")
                .setTimeout(120) // 120 seconds timeout
                .build();
        System.out.println(customTimeoutGetRequest);

        // --- The Power of the Builder Pattern ---
        // Notice how readable and flexible the object creation is.
        // You only set the properties you need, in any order, and the final object is always valid.
        // No confusing constructors with many nulls or booleans!
    }
}
