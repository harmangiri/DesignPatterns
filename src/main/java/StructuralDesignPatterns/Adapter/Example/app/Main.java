package StructuralDesignPatterns.Adapter.Example.app;

import StructuralDesignPatterns.Adapter.Example.adapters.PayPalAdapter;
import StructuralDesignPatterns.Adapter.Example.adapters.StripeAdapter;
import StructuralDesignPatterns.Adapter.Example.targetInterface.PaymentProcessor;
import StructuralDesignPatterns.Adapter.Example.third_party.PayPalAPI;
import StructuralDesignPatterns.Adapter.Example.third_party.StripeAPI;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== Payment Gateway Integration (Adapter Pattern) ======\n");

        // --- Configuration for ACTUAL APIs ---
        
        // 1. Stripe Credentials (You can use the same key from the AbstractFactory example)
        String stripeSecretKey = "sk_test_51MbKgDSIB9FX3wABCDABCDABCDABCD";
        
        // 2. PayPal Credentials (Create a Sandbox App at developer.paypal.com)
        // These are dummy placeholders, replace with actual sandbox Client ID and Secret to test!
        String payPalClientId = "YOUR_PAYPAL_CLIENT_ID_HERE";
        String payPalClientSecret = "YOUR_PAYPAL_CLIENT_SECRET_HERE";


        // =========================================================================

        // --- Use Case 1: Processing a payment via Stripe ---
        System.out.println(">>> Setting up Stripe API...");
        StripeAPI stripeAPI = new StripeAPI(stripeSecretKey);
        
        // The Adapter takes the incompatible StripeAPI and makes it match PaymentProcessor
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeAPI, "inr");
        
        System.out.println("--- Processing payment with Stripe Adapter ---");
        // We pass the amount as a normal double (1600.50). 
        // The adapter handles converting it to 160050 cents/paise for Stripe!
        stripeProcessor.processPayment("cus_12345_test", 1100.50);
        
        System.out.println("\n----------------------------------------\n");

        // --- Use Case 2: Processing a payment via PayPal ---
        System.out.println(">>> Setting up PayPal API...");
        PayPalAPI payPalAPI = new PayPalAPI(payPalClientId, payPalClientSecret);
        
        // The Adapter takes the incompatible PayPalAPI and makes it match PaymentProcessor
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalAPI, "USD");
        
        System.out.println("--- Processing payment with PayPal Adapter ---");
        // We pass the amount as a normal double (150.75).
        // The adapter handles formatting it to a string "150.75" and building the JSON payload for PayPal!
        payPalProcessor.processPayment("user@example.com", 150.75);
        
        
        System.out.println("\n========================================");
        System.out.println("Benefits Proved:");
        System.out.println("The Main class called `.processPayment()` exactly the same way for both gateways.");
        System.out.println("It didn't know that Stripe uses an SDK with cents, and PayPal uses direct HTTP REST calls with JSON.");
        System.out.println("The Adapters handled 100% of the ugly translation work!");
    }
}
