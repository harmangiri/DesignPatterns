package CreationalDesignPatterns.AbstractFactory.Example.app;

import CreationalDesignPatterns.AbstractFactory.Example.factory.PaymentGatewayFactory;
import CreationalDesignPatterns.AbstractFactory.Example.product.CustomerManager;
import CreationalDesignPatterns.AbstractFactory.Example.product.TransactionProcessor;

/**
 * The Client Code.
 * The client works with factories and products only through abstract interfaces.
 * This allows passing any factory or product subclass to the client code without breaking it.
 */
public class BillingService {
    private final CustomerManager customerManager;
    private final TransactionProcessor transactionProcessor;

    /**
     * The BillingService doesn't know WHICH gateway it's using. 
     * It just knows it has a factory that provides matching Customer and Transaction handlers.
     */
    public BillingService(PaymentGatewayFactory factory) {
        this.customerManager = factory.createCustomerManager();
        this.transactionProcessor = factory.createTransactionProcessor();
    }

    public void processOrder(String customerName, String email, double amount, String currency) {
        System.out.println("\n--- Starting Order Processing ---");
        
        // 1. Ensure the customer exists in the gateway
        // Now returns the actual Gateway Customer ID (e.g. cus_12345)
        String customerId = customerManager.createCustomer(customerName, email);
        
        // 2. Process the payment using the same gateway family, linked to that customer!
        if (customerId != null) {
            transactionProcessor.processPayment(amount, currency, customerId);
        } else {
            System.err.println("Cannot process payment because Customer Creation failed.");
        }
        
        System.out.println("--- Order Processing Complete ---\n");
    }
}
