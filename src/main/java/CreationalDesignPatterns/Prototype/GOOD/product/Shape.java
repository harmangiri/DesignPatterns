package CreationalDesignPatterns.Prototype.GOOD.product;

/**
 * Prototype Interface: Declares an interface for cloning itself.
 * This is the common interface for all objects that can be cloned.
 */
public interface Shape extends Cloneable {
    Shape clone(); // Returns a copy of itself
    void draw();   // For demonstration purposes
    void move(int x, int y); // For demonstration purposes
}
