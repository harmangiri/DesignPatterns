package CreationalDesignPatterns.FactoryMethod.Example.product;

/**
 * Product Interface: Defines the common interface for all notification types.
 * All concrete notification classes must implement this interface.
 */
public interface Notification {
    void send(String message);
}
