package CreationalDesignPatterns.Builder.BAD.app;

import CreationalDesignPatterns.Builder.BAD.product.House;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- BAD Practice (Telescoping Constructor) ---");

        // What does this mean? `4, 2, 4, true, false, true`
        // It's incredibly hard to read without looking at the class definition.
        // You have to pass `false` for swimming pool just to get to the `hasGarden` parameter.
        House mansion = new House(4, 2, 4, true, false, true);
        
        System.out.println("Mansion Created:\n" + mansion.toString());
        
        System.out.println("----------------------------------------------");

        // Basic house
        House cabin = new House(4, 1);
        System.out.println("Cabin Created:\n" + cabin.toString());
    }
}
