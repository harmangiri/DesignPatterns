package StructuralDesignPatterns.Bridge.Example.abstraction;

import StructuralDesignPatterns.Bridge.Example.implementation.MessageSender;

/**
 * Refined Abstraction 2: Daily Digest Notification.
 * Formats the message as a low-priority informative summary.
 */
public class DailyDigestNotification extends Notification {

    public DailyDigestNotification(MessageSender sender) {
        super(sender);
    }

    @Override
    public void notify(String content) {
        System.out.println("Formatting Daily Digest Notification...");
        String formattedMessage = "📰 Daily Summary: " + content;
        
        // Delegate the actual sending to the bridge
        sender.sendMessage(formattedMessage);
    }
}
