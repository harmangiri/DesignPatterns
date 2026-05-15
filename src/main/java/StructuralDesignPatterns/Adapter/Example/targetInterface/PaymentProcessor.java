package StructuralDesignPatterns.Adapter.Example.targetInterface;

/**
 * Target Interface.
 * This is the standard interface our application (Checkout Service) expects.
 */
public interface PaymentProcessor {
    void processPayment(String accountIdentifier, double amount);
}
