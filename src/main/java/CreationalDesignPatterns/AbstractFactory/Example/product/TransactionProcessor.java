package CreationalDesignPatterns.AbstractFactory.Example.product;

/**
 * Abstract Product B: Declares an interface for processing transactions.
 */
public interface TransactionProcessor {
    void processPayment(double amount, String currency, String customerId);
}
