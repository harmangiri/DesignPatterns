package CreationalDesignPatterns.Prototype.BAD.app;

import CreationalDesignPatterns.Prototype.BAD.product.Circle;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- BAD Practice (Manual Object Copying) ---");

        // 1. Create an original object
        Circle originalCircle = new Circle(10, 20, 15, "Red");
        System.out.println("Original: " + originalCircle);

        // 2. Try to copy it manually
        // We have to know EXACTLY what concrete class we are dealing with.
        // We have to manually fetch every field and pass it.
        // What if some fields are private and have no getters? We are stuck!
        Circle copyCircle = new Circle(
                originalCircle.getX(),
                originalCircle.getY(),
                originalCircle.getRadius(),
                originalCircle.getColor()
        );
        
        // 3. Modify the copy to prove it's a different instance
        copyCircle.setX(100);
        System.out.println("Copy (Modified): " + copyCircle);
        
        System.out.println("Original is unchanged: " + originalCircle);

        System.out.println("\nProblems:");
        System.out.println("1. We had to manually copy 4 fields. If Circle had 20 fields, this would be a nightmare.");
        System.out.println("2. If Circle had private fields without getters, we couldn't copy it from this Main class at all.");
        System.out.println("3. If we had a List of generic 'Shapes', we wouldn't know which constructor to call without 'instanceof' checks.");
    }
}
