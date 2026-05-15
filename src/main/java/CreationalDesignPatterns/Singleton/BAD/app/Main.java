package CreationalDesignPatterns.Singleton.BAD.app;

import CreationalDesignPatterns.Singleton.BAD.service.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- BAD Practice (No Singleton) ---");

        System.out.println("User 1 accesses the app...");
        DatabaseConnection db1 = new DatabaseConnection();
        db1.executeQuery("SELECT * FROM users");

        System.out.println("\nUser 2 accesses the app...");
        DatabaseConnection db2 = new DatabaseConnection();
        db2.executeQuery("SELECT * FROM products");

        System.out.println("\nAre they the same connection? " + (db1 == db2));
        
        System.out.println("\nProblems:");
        System.out.println("1. Two heavy database connections were opened, wasting resources.");
        System.out.println("2. In a real app with thousands of users, the database server would crash from too many connections.");
    }
}
