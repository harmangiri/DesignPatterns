package StructuralDesignPatterns.Bridge.Example.implementation;

/**
 * Concrete Implementation 1: Sends messages via Email.
 */
public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        // In reality, this would use JavaMail API or AWS SES
        System.out.println("[EMAIL API] Connecting to SMTP server...");
        System.out.println("[EMAIL API] Sending: " + message);
        System.out.println("[EMAIL API] Success!\n");
    }
}
