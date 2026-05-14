package CreationalDesignPatterns.FactoryMethod.Example.app;

import CreationalDesignPatterns.FactoryMethod.Example.creator.EmailNotificationFactory;
import CreationalDesignPatterns.FactoryMethod.Example.creator.NotificationFactory;
import CreationalDesignPatterns.FactoryMethod.Example.creator.SmsNotificationFactory;

/**
 * The Client Code.
 * It coordinates everything but works strictly through the NotificationFactory abstraction.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("====== Notification Service (Factory Method) ======\n");

        // --- Use Case 1: Sending an ACTUAL Email ---
        System.out.println("Note: For the email to actually send, you must provide a valid Gmail App Password in the code.");
        
        NotificationFactory emailFactory = new EmailNotificationFactory(
                "noreply_test@test.com", 
                "test@test.com"
        );
        
        emailFactory.processAndSendNotification("Hello! Your account has been successfully created and this is a real email test.");

        System.out.println("--------------------------------------------------");

        // --- Use Case 2: Sending an ACTUAL SMS (India) ---
        // To make this work:
        // 1. Create a free account on (https://www.test.com/)
        // 2. Get your free API Key from the Dev API section.
        // 3. Replace "YOUR_API_KEY" with your actual key.
        // 4. Replace "9999999999" with your actual 10-digit Indian mobile number (no +91 needed).
        
        System.out.println("Note: For the SMS to actually send, you must provide a valid test API Key in the code.");
        
        NotificationFactory smsFactory = new SmsNotificationFactory(
                "9999999999", // Enter a 10 digit Indian mobile number here
                "DUMMY_API_KEY" // Enter API key here
        );
        
        smsFactory.processAndSendNotification("Your OTP code is 849201. Tested via Factory Method Design Pattern!");
        
        
        // --- The Power of the Pattern ---
        // We added heavy HTTP REST API logic for SMS and SMTP logic for Emails.
        // Yet, the client execution logic (`emailFactory.processAndSendNotification` / `smsFactory.processAndSendNotification`)
        // remains perfectly clean and unchanged!
    }
}
