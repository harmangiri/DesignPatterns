package StructuralDesignPatterns.Adapter.Example.adapters;

import StructuralDesignPatterns.Adapter.Example.targetInterface.PaymentProcessor;
import StructuralDesignPatterns.Adapter.Example.third_party.PayPalAPI;

/**
 * Adapter for PayPal.
 * Bridges the PaymentProcessor interface to the actual PayPalAPI class.
 */
public class PayPalAdapter implements PaymentProcessor {
    private final PayPalAPI payPalAPI;
    private final String currencyCode;

    public PayPalAdapter(PayPalAPI payPalAPI, String currencyCode) {
        this.payPalAPI = payPalAPI;
        this.currencyCode = currencyCode;
    }

    @Override
    public void processPayment(String accountIdentifier, double amount) {
        System.out.println("[Adapter] Adapting target 'processPayment' request to PayPal format...");
        
        // 1. PayPal expects the amount as a formatted String (e.g., "150.75"), not a double/long
        String stringAmount = String.format("%.2f", amount);
        
        // 2. We use 'accountIdentifier' as the PayPal 'email' identifier
        payPalAPI.createOrder(accountIdentifier, stringAmount, currencyCode);
    }
}
