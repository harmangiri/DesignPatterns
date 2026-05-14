package CreationalDesignPatterns.FactoryMethod.Example.creator;

import CreationalDesignPatterns.FactoryMethod.Example.product.EmailNotification;
import CreationalDesignPatterns.FactoryMethod.Example.product.Notification;

/**
 * Concrete Creator: Overrides the factory method to return an EmailNotification.
 */
public class EmailNotificationFactory extends NotificationFactory {

    private final String senderEmail;
    private final String recipientEmail;

    // Injecting configuration needed to build the specific product (including auth)
    public EmailNotificationFactory(String senderEmail, String recipientEmail) {
        this.senderEmail = senderEmail;
        this.recipientEmail = recipientEmail;
    }

    @Override
    public Notification createNotification() {
        // Encapsulating the complex creation logic of the specific product
        return new EmailNotification(senderEmail, recipientEmail);
    }
}
