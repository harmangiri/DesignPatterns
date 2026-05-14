package CreationalDesignPatterns.AbstractFactory.Example.factory;

import com.stripe.Stripe;
import CreationalDesignPatterns.AbstractFactory.Example.product.CustomerManager;
import CreationalDesignPatterns.AbstractFactory.Example.product.StripeCustomerManager;
import CreationalDesignPatterns.AbstractFactory.Example.product.StripeTransactionProcessor;
import CreationalDesignPatterns.AbstractFactory.Example.product.TransactionProcessor;

/**
 * Concrete Factory 1: Implements the operations to create Stripe-specific products.
 */
public class StripeFactory implements PaymentGatewayFactory {
    
    public StripeFactory(String apiKey) {
        // Initialize the official Stripe SDK globally for this factory's scope
        Stripe.apiKey = apiKey;
        System.out.println("[Stripe System] Official Stripe SDK initialized.");
    }

    @Override
    public CustomerManager createCustomerManager() {
        return new StripeCustomerManager();
    }

    @Override
    public TransactionProcessor createTransactionProcessor() {
        return new StripeTransactionProcessor();
    }
}
