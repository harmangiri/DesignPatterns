package CreationalDesignPatterns.Prototype.GOOD.product;

/**
 * Concrete Prototype: Implements the clone() method to copy itself.
 */
public class Rectangle implements Shape {
    private int x, y;
    private int width, height;
    private String color;

    public Rectangle(int x, int y, int width, int height, String color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    private Rectangle(Rectangle source) {
        this.x = source.x;
        this.y = source.y;
        this.width = source.width;
        this.height = source.height;
        this.color = source.color;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle at (" + x + "," + y + ") with width " + width + ", height " + height + " and color " + color);
    }

    @Override
    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
}
