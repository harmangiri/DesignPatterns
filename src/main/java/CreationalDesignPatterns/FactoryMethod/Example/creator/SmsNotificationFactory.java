package CreationalDesignPatterns.FactoryMethod.Example.creator;

import CreationalDesignPatterns.FactoryMethod.Example.product.Notification;
import CreationalDesignPatterns.FactoryMethod.Example.product.SmsNotification;

/**
 * Concrete Creator: Overrides the factory method to return an SmsNotification.
 */
public class SmsNotificationFactory extends NotificationFactory {

    private final String phoneNumber;
    private final String apiKey;

    // Injecting configuration needed to build the specific product (including API Key)
    public SmsNotificationFactory(String phoneNumber, String apiKey) {
        this.phoneNumber = phoneNumber;
        this.apiKey = apiKey;
    }

    @Override
    public Notification createNotification() {
        return new SmsNotification(phoneNumber, apiKey);
    }
}
