package StructuralDesignPatterns.Adapter.Example.third_party;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

/**
 * Adaptee 1: A third-party Stripe API.
 * This represents the actual, modern Stripe Java SDK integration.
 * We pretend we cannot change this class (it acts as a wrapper for the external SDK).
 */
public class StripeAPI {
    
    public StripeAPI(String apiKey) {
        Stripe.apiKey = apiKey;
        System.out.println("[Stripe SDK] Initialized.");
    }

    /**
     * Stripe expects amounts in cents/paise (smallest unit).
     */
    public void createPaymentIntent(String customerId, long amountInCents, String currency) {
        System.out.println("[Stripe SDK] Creating PaymentIntent...");
        
        PaymentIntentCreateParams.Builder paramsBuilder = PaymentIntentCreateParams.builder()
                .setAmount(amountInCents)
                .setCurrency(currency)
                .setPaymentMethod("pm_card_us") // Using international test card to bypass Indian 3D secure
                .setConfirm(true)
                .setReturnUrl("https://example.com/return")
                .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                                .setEnabled(true)
                                .setAllowRedirects(PaymentIntentCreateParams.AutomaticPaymentMethods.AllowRedirects.NEVER)
                                .build()
                )
                .setDescription("Adapter Pattern - Stripe Charge");

        // Only attach a customer if the ID actually exists (doesn't start with our dummy string)
        // In a real application, you would ensure the customer token is valid before passing it.
        if (customerId != null && !customerId.equals("cus_12345_test")) {
            paramsBuilder.setCustomer(customerId);
        }

        try {
            PaymentIntent intent = PaymentIntent.create(paramsBuilder.build());
            System.out.println("[Stripe SDK] SUCCESS! Payment Intent created. ID: " + intent.getId() + ", Status: " + intent.getStatus());
        } catch (StripeException e) {
            System.err.println("[Stripe SDK] FAILED to process payment!");
            e.printStackTrace();
        }
    }
}
