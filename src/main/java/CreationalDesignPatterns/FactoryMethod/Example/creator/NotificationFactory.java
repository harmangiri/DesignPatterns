package CreationalDesignPatterns.FactoryMethod.Example.creator;

import CreationalDesignPatterns.FactoryMethod.Example.product.Notification;

/**
 * Creator Abstract Class: Declares the factory method.
 * 
 * Note: It can optionally contain core business logic that relies on the 
 * Notification object returned by the factory method.
 */
public abstract class NotificationFactory {
    
    /**
     * The Factory Method. Subclasses must implement this to instantiate
     * the specific type of Notification.
     */
    public abstract Notification createNotification();

    /**
     * Core business logic. The creator relies on its subclasses to 
     * provide the actual concrete product instance.
     */
    public void processAndSendNotification(String message) {
        // Log the start of the process
        System.out.println("Processing notification request...");
        
        // Call the factory method to create a Notification object
        Notification notification = createNotification();
        
        // Use the product
        notification.send(message);
    }
}
