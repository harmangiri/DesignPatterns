package StructuralDesignPatterns.Bridge.Example.implementation;

/**
 * Implementation Interface.
 * Defines the low-level operations for sending messages across different platforms.
 */
public interface MessageSender {
    void sendMessage(String message);
}
