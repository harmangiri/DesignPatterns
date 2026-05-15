package StructuralDesignPatterns.Bridge.Example.abstraction;

import StructuralDesignPatterns.Bridge.Example.implementation.MessageSender;

/**
 * Refined Abstraction 1: Alert Notification.
 * Formats the message as a high-priority CRITICAL alert.
 */
public class AlertNotification extends Notification {

    public AlertNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notify(String content) {
        System.out.println("Formatting Alert Notification...");
        String formattedMessage = "🚨 CRITICAL ALERT 🚨 : " + content.toUpperCase();
        
        // Delegate the actual sending to the bridge
        sender.sendMessage(formattedMessage);
    }
}
