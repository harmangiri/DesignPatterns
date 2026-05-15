package CreationalDesignPatterns.Singleton.GOOD.service;

/**
 * Singleton: Ensures only ONE instance of the Database Connection exists.
 * Implemented using Thread-Safe Double-Checked Locking.
 */
public class DatabaseConnection {
    
    // 1. Private static variable to hold the ONE instance
    // The 'volatile' keyword ensures that multiple threads handle the instance correctly
    private static volatile DatabaseConnection instance;

    // 2. Private constructor to prevent direct instantiation
    private DatabaseConnection() {
        System.out.println("[DB] Connecting to database... (Expensive Network Call)");
        System.out.println("[DB] Connection established!");
    }

    // 3. Public static method to get the instance (Global Access Point)
    public static DatabaseConnection getInstance() {
        // First check (no locking) - fast
        if (instance == null) {
            // Locking block - slow but thread-safe
            synchronized (DatabaseConnection.class) {
                // Second check (inside lock)
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("Executing: " + query);
    }
}
