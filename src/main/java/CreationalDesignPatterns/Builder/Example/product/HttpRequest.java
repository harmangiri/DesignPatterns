package CreationalDesignPatterns.Builder.Example.product;

import CreationalDesignPatterns.Builder.Example.builder.HttpRequestBuilder;

import java.util.Map;

/**
 * Product: A complex HTTP Request object.
 * This represents a real-world object that often requires a Builder 
 * because a request can have many optional headers, bodies, and parameters.
 */
public class HttpRequest {
    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final String body;
    private final int timeoutSeconds;

    // Private constructor ensures the object can only be created via the Builder
    public HttpRequest(HttpRequestBuilder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.body = builder.body;
        this.timeoutSeconds = builder.timeoutSeconds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Sending HTTP Request ---\n");
        sb.append("URL: ").append(url).append("\n");
        sb.append("Method: ").append(method).append("\n");
        sb.append("Timeout: ").append(timeoutSeconds).append("s\n");
        
        if (headers != null && !headers.isEmpty()) {
            sb.append("Headers: ").append(headers).append("\n");
        }
        
        if (body != null && !body.isEmpty()) {
            sb.append("Body: ").append(body).append("\n");
        }
        sb.append("----------------------------\n");
        return sb.toString();
    }
}
