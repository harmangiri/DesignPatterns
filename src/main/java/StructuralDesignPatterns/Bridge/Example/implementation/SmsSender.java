package StructuralDesignPatterns.Bridge.Example.implementation;

/**
 * Concrete Implementation 2: Sends messages via SMS.
 */
public class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        // In reality, this would hit Twilio or Fast2SMS API
        System.out.println("[SMS API] Connecting to Telecom Gateway...");
        System.out.println("[SMS API] Sending: " + message);
        System.out.println("[SMS API] Success!\n");
    }
}
