package CreationalDesignPatterns.Singleton.BAD.service;

/**
 * A heavy class representing a Database Connection.
 * Anyone can create instances of this class.
 */
public class DatabaseConnection {
    
    public DatabaseConnection() {
        System.out.println("[DB] Connecting to database... (Expensive Network Call)");
        // Imagine complex connection logic here
        System.out.println("[DB] Connection established!");
    }

    public void executeQuery(String query) {
        System.out.println("Executing: " + query);
    }
}
