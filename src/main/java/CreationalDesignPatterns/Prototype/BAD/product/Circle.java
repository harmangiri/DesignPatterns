package CreationalDesignPatterns.Prototype.BAD.product;

public class Circle {
    private int x, y;
    private int radius;
    private String color; // Let's say this is private and complex to copy

    public Circle(int x, int y, int radius, String color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    // No easy way to copy this object from outside if 'color' is private
    // and we don't have a copy constructor or public setters for all fields.
    // Even if we did, it's manual and error-prone.

    public int getX() { return x; }
    public int getY() { return y; }
    public int getRadius() { return radius; }
    public String getColor() { return color; } // Exposed for demonstration, but imagine it's not.

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setRadius(int radius) { this.radius = radius; }
    // No public setter for color, making it harder to copy externally.

    @Override
    public String toString() {
        return "Circle [x=" + x + ", y=" + y + ", radius=" + radius + ", color=" + color + "]";
    }
}
