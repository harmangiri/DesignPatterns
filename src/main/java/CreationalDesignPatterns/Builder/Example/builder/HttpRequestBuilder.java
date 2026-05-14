package CreationalDesignPatterns.Builder.Example.builder;

import CreationalDesignPatterns.Builder.Example.product.HttpRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Builder: Provides a fluent API to construct an HttpRequest step-by-step.
 */
public class HttpRequestBuilder {
    
    // Properties are accessible to the product in the same package, 
    // or public if they are in different packages (as in our structure).
    public String url;
    public String method;
    public Map<String, String> headers;
    public String body;
    public int timeoutSeconds = 30; // Default value

    // Required fields are passed in the constructor
    public HttpRequestBuilder(String url) {
        this.url = url;
        this.method = "GET"; // Default method
        this.headers = new HashMap<>();
    }

    public HttpRequestBuilder setMethod(String method) {
        this.method = method;
        return this;
    }

    public HttpRequestBuilder addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public HttpRequestBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public HttpRequestBuilder setTimeout(int timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
        return this;
    }

    // The final build step
    public HttpRequest build() {
        // You can also add validation here before creating the object!
        if (method.equals("POST") && (body == null || body.isEmpty())) {
            System.err.println("Warning: POST request created without a body.");
        }
        return new HttpRequest(this);
    }
}
