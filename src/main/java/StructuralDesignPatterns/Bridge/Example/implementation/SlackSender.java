package StructuralDesignPatterns.Bridge.Example.implementation;

/**
 * Concrete Implementation 3: Sends messages via Slack.
 */
public class SlackSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        // In reality, this would hit the Slack Webhook API
        System.out.println("[SLACK API] Hitting Webhook URL...");
        System.out.println("[SLACK API] Sending Payload: {\"text\": \"" + message + "\"}");
        System.out.println("[SLACK API] Success!\n");
    }
}
