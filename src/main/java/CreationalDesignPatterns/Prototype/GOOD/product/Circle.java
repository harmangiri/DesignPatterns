package CreationalDesignPatterns.Prototype.GOOD.product;

/**
 * Concrete Prototype: Implements the clone() method to copy itself.
 */
public class Circle implements Shape {
    private int x, y;
    private int radius;
    private String color; // Even though this is private, clone() can access it!

    public Circle(int x, int y, int radius, String color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    // A private copy constructor is a great way to handle cloning internally
    private Circle(Circle source) {
        this.x = source.x;
        this.y = source.y;
        this.radius = source.radius;
        this.color = source.color;
    }

    @Override
    public Shape clone() {
        // The object clones ITSELF. It has full access to its own private fields.
        return new Circle(this); 
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle at (" + x + "," + y + ") with radius " + radius + " and color " + color);
    }

    @Override
    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
}
