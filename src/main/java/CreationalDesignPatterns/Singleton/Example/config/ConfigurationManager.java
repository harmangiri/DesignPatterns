package CreationalDesignPatterns.Singleton.Example.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton Enum: The most robust way to create a Singleton in modern Java.
 * Enum Singletons are natively thread-safe and safe from serialization/reflection attacks.
 * Recommended by Joshua Bloch (Effective Java).
 */
public enum ConfigurationManager {
    // This is the ONLY instance of this class that will ever exist.
    INSTANCE;

    private final Map<String, String> properties;

    // The enum constructor is implicitly private and runs only ONCE.
    ConfigurationManager() {
        System.out.println("  [System] Loading configuration file from disk... (Heavy I/O Operation)");
        properties = new HashMap<>();
        
        // Simulating loading data from an environment file or database
        properties.put("api_key", "sk_live_abc123");
        properties.put("timeout_seconds", "30");
        properties.put("environment", "production");
        
        System.out.println("  [System] Configurations successfully loaded and cached in memory!\n");
    }

    /**
     * Retrieves a configuration property.
     */
    public String getProperty(String key) {
        return properties.get(key);
    }
}
