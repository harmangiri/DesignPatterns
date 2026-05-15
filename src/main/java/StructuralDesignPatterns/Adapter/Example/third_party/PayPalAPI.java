package StructuralDesignPatterns.Adapter.Example.third_party;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;

/**
 * Adaptee 2: A third-party PayPal API.
 * This represents actual HTTP calls to the PayPal REST API.
 */
public class PayPalAPI {
    private final String clientId;
    private final String clientSecret;
    private final String baseUrl = "https://api-m.sandbox.paypal.com"; // Sandbox environment

    public PayPalAPI(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        System.out.println("[PayPal API] Initialized.");
    }

    /**
     * Helper method to get an OAuth2 access token from PayPal.
     */
    private String getAccessToken() throws Exception {
        String auth = clientId + ":" + clientSecret;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/v1/oauth2/token"))
                .header("Authorization", "Basic " + encodedAuth)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        // Very basic parsing for demonstration (in reality, use GSON here)
        String body = response.body();
        String token = body.split("\"access_token\":\"")[1].split("\"")[0];
        return token;
    }

    /**
     * PayPal expects string-formatted amounts and complex JSON structures for Orders.
     */
    public void createOrder(String email, String stringAmount, String currencyCode) {
        System.out.println("[PayPal API] Attempting to create an Order...");
        try {
            String accessToken = getAccessToken();

            // Constructing the specific JSON payload PayPal requires
            String jsonPayload = "{\n" +
                    "  \"intent\": \"CAPTURE\",\n" +
                    "  \"purchase_units\": [\n" +
                    "    {\n" +
                    "      \"amount\": {\n" +
                    "        \"currency_code\": \"" + currencyCode + "\",\n" +
                    "        \"value\": \"" + stringAmount + "\"\n" +
                    "      },\n" +
                    "      \"description\": \"Payment from " + email + "\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";

            HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/v2/checkout/orders"))
                    .header("Authorization", "Bearer " + accessToken)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            if (response.statusCode() == 201 || response.statusCode() == 200) {
                // Extracting order ID from raw JSON
                String orderId = response.body().split("\"id\":\"")[1].split("\"")[0];
                System.out.println("[PayPal API] SUCCESS! Order created. ID: " + orderId);
            } else {
                System.err.println("[PayPal API] FAILED to create order! Status: " + response.statusCode());
                System.err.println("Response: " + response.body());
            }

        } catch (Exception e) {
            System.err.println("[PayPal API] Error during PayPal request.");
            e.printStackTrace();
        }
    }
}
