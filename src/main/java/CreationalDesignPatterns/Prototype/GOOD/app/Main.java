package CreationalDesignPatterns.Prototype.GOOD.app;

import CreationalDesignPatterns.Prototype.GOOD.product.Circle;
import CreationalDesignPatterns.Prototype.GOOD.product.Rectangle;
import CreationalDesignPatterns.Prototype.GOOD.product.Shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GOOD Practice (Prototype Pattern) ---");

        // 1. Create original shapes
        Circle originalCircle = new Circle(10, 20, 15, "Red");
        Rectangle originalRectangle = new Rectangle(30, 40, 10, 20, "Blue");

        // 2. Create a list of shapes (polymorphic collection)
        List<Shape> shapes = new ArrayList<>();
        shapes.add(originalCircle);
        shapes.add(originalRectangle);

        // 3. Clone the shapes without knowing their concrete types
        List<Shape> clonedShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            clonedShapes.add(shape.clone());
        }

        // 4. Modify the cloned shapes to prove they are independent copies
        System.out.println("\nOriginal Shapes:");
        for (Shape shape : shapes) {
            shape.draw();
        }

        System.out.println("\nCloned Shapes (Modified):");
        for (Shape shape : clonedShapes) {
            shape.move(500, 500); // Move all cloned shapes
            shape.draw();
        }

        System.out.println("\nOriginal Shapes (after cloning and modifying clones):");
        for (Shape shape : shapes) {
            shape.draw(); // Originals should remain unchanged
        }

        System.out.println("\nBenefits:");
        System.out.println("1. No need for 'instanceof' checks or knowing concrete classes to copy.");
        System.out.println("2. Each object handles its own copying, even for private fields.");
        System.out.println("3. Efficient for creating many similar objects from a template.");
    }
}
