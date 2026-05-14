package CreationalDesignPatterns.AbstractFactory.Example.app;

import CreationalDesignPatterns.AbstractFactory.Example.factory.PaymentGatewayFactory;
import CreationalDesignPatterns.AbstractFactory.Example.factory.StripeFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== Payment Gateway System (Abstract Factory) ======\n");

        // --- Use Case 1: ACTUAL Stripe Integration ---
        // Replace this with your ACTUAL Stripe Secret API Key (sk_test_...)
        // You can get this for free by creating an account at dashboard.stripe.com -> Developers -> API keys.
        String actualStripeSecretKey = "sk_test_51MbKgDSIABCDABCDABCD"; 
        
        System.out.println(">>> Configuring system for STRIPE...");
        System.out.println("Note: You must provide your actual Stripe Secret Key in Main.java to see real API calls.");
        System.out.println("Note: You must also add the `com.stripe:stripe-java` dependency to your project.");
        
        PaymentGatewayFactory stripeFactory = new StripeFactory(actualStripeSecretKey);
        
        // We pass the factory into the client code (BillingService).
        BillingService billingService = new BillingService(stripeFactory);
        
        // This will now make REAL HTTP network calls to Stripe's servers!
        billingService.processOrder("Rahul Sharma", "rahul@example.com", 2000.50, "inr");
    }
}
