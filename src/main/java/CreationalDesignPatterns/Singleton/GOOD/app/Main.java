package CreationalDesignPatterns.Singleton.GOOD.app;

import CreationalDesignPatterns.Singleton.GOOD.service.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GOOD Practice (Singleton Pattern) ---");

        System.out.println("User 1 accesses the app...");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.executeQuery("SELECT * FROM users");

        System.out.println("\nUser 2 accesses the app...");
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.executeQuery("SELECT * FROM products");

        System.out.println("\nAre they the exact same connection? " + (db1 == db2));
        
        System.out.println("\nBenefits:");
        System.out.println("1. Only ONE expensive database connection was opened.");
        System.out.println("2. Safe for thousands of users. They all share the same connection pool instance.");
        System.out.println("3. The 'getInstance' method is thread-safe using double-checked locking.");
    }
}
