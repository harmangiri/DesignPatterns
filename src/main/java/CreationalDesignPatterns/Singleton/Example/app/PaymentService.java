package CreationalDesignPatterns.Singleton.Example.app;

import CreationalDesignPatterns.Singleton.Example.config.ConfigurationManager;

public class PaymentService {
    public void processPayment() {
        // Accessing the global singleton instance
        ConfigurationManager config = ConfigurationManager.INSTANCE;
        
        System.out.println("Processing Payment...");
        System.out.println("Reading API Key from Config Manager: " + config.getProperty("api_key"));
    }
}
