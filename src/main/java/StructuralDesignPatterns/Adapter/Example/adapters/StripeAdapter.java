package StructuralDesignPatterns.Adapter.Example.adapters;

import StructuralDesignPatterns.Adapter.Example.targetInterface.PaymentProcessor;
import StructuralDesignPatterns.Adapter.Example.third_party.StripeAPI;

/**
 * Adapter for Stripe.
 * Bridges the PaymentProcessor interface to the actual StripeAPI class.
 */
public class StripeAdapter implements PaymentProcessor {
    private final StripeAPI stripeAPI;
    private final String currency;

    public StripeAdapter(StripeAPI stripeAPI, String currency) {
        this.stripeAPI = stripeAPI;
        this.currency = currency;
    }

    @Override
    public void processPayment(String accountIdentifier, double amount) {
        System.out.println("[Adapter] Adapting target 'processPayment' request to Stripe format...");
        
        // 1. Stripe expects amounts in the smallest currency unit (cents/paise)
        long amountInCents = (long) (amount * 100);
        
        // 2. We use 'accountIdentifier' as Stripe's 'customerId'
        stripeAPI.createPaymentIntent(accountIdentifier, amountInCents, currency);
    }
}
