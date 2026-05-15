package CreationalDesignPatterns.Singleton.Example.app;

import CreationalDesignPatterns.Singleton.Example.config.ConfigurationManager;

public class EmailService {
    public void sendEmail() {
        // Accessing the exact same singleton instance
        ConfigurationManager config = ConfigurationManager.INSTANCE;
        
        System.out.println("Sending Email...");
        System.out.println("Reading Environment from Config Manager: " + config.getProperty("environment"));
    }
}
