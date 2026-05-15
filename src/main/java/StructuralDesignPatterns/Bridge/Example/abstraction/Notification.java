package StructuralDesignPatterns.Bridge.Example.abstraction;

import StructuralDesignPatterns.Bridge.Example.implementation.MessageSender;

/**
 * Abstraction.
 * High-level control logic for different types of Notifications.
 * It uses the MessageSender bridge to actually deliver the messages.
 */
public abstract class Notification {
    // The Bridge
    protected MessageSender sender;

    protected Notification(MessageSender sender) {
        this.sender = sender;
    }

    // High-level operation that subclasses will define
    public abstract void notify(String content);
}
