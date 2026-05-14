package CreationalDesignPatterns.AbstractFactory.Example.product;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

/**
 * Concrete Product B1: Implements TransactionProcessor for the Stripe family.
 * ACTUALLY makes HTTP requests to Stripe's servers to create a Payment Intent.
 */
public class StripeTransactionProcessor implements TransactionProcessor {
    @Override
    public void processPayment(double amount, String currency, String customerId) {
        System.out.println("[Stripe API] Calling actual Stripe API to create Payment Intent for Customer: " + customerId + "...");
        
        // Stripe expects amount in the smallest currency unit (e.g., cents/paise).
        long amountInSmallestUnit = (long) (amount * 100);

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(amountInSmallestUnit)
                .setCurrency(currency.toLowerCase()) 
                .setCustomer(customerId) 
                // Test card specifically designated as a "Non-Indian" card.
                // Indian export regulations force 3D Secure on all INR transactions if using an Indian card.
                // Using an International test card bypasses the RBI 3D Secure mandate in test mode.
                .setPaymentMethod("pm_card_visa") 
                .setConfirm(true) 
                .setReturnUrl("https://example.com/return") 
                .setDescription("Test Payment for Abstract Factory Pattern Order")
                .build();

        try {
            PaymentIntent paymentIntent = PaymentIntent.create(params);
            System.out.println("[Stripe API] Success! Payment Intent created with ID: " + paymentIntent.getId());
            System.out.println("[Stripe API] Status: " + paymentIntent.getStatus());
            System.out.println("[Stripe API] Amount: " + (paymentIntent.getAmount() / 100.0) + " " + paymentIntent.getCurrency().toUpperCase());
            System.out.println("[Stripe API] Linked Customer: " + paymentIntent.getCustomer());
            System.out.println("[Stripe API] Payment Method: " + paymentIntent.getPaymentMethod());
        } catch (StripeException e) {
            System.err.println("[Stripe API] Failed to create Payment Intent!");
            e.printStackTrace();
        }
    }
}
