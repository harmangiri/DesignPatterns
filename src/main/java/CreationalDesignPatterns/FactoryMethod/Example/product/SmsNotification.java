package CreationalDesignPatterns.FactoryMethod.Example.product;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Concrete Product: Implements the Notification interface for sending ACTUAL SMS messages.
 * This example uses Fast2SMS API (a popular provider in India) as a demonstration.
 */
public class SmsNotification implements Notification {

    private final String phoneNumber;
    private final String apiKey;

    public SmsNotification(String phoneNumber, String apiKey) {
        this.phoneNumber = phoneNumber;
        this.apiKey = apiKey;
    }

    @Override
    public void send(String messageBody) {
        System.out.println("--- Attempting to send actual SMS to Indian Number ---");

        try {
            // Fast2SMS API Endpoint for sending Quick SMS
            // Note: The phone number must be without +91, just the 10 digits for Fast2SMS.
            String url = "https://www.fast2sms.com/dev/bulkV2?authorization=" + apiKey +
                         "&route=q&message=" + java.net.URLEncoder.encode(messageBody, "UTF-8") +
                         "&language=english&flash=0&numbers=" + phoneNumber;

            // Using Java 11+ HttpClient to make the REST API call
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            System.out.println("Connecting to SMS Gateway...");
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("Status: SMS successfully sent to " + phoneNumber + "!");
                System.out.println("Gateway Response: " + response.body() + "\n");
            } else {
                System.err.println("Status: Failed to send SMS!");
                System.err.println("Gateway Error: " + response.body() + "\n");
            }

        } catch (Exception e) {
            System.err.println("Status: Error occurred while sending SMS!");
            e.printStackTrace();
        }
    }
}
