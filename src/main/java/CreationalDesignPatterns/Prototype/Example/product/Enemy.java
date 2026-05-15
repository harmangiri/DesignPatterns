package CreationalDesignPatterns.Prototype.Example.product;

/**
 * Prototype Interface: Declares the cloning method for Enemies.
 */
public interface Enemy extends Cloneable {
    Enemy clone();
    void setPosition(int x, int y);
    void spawn();
}
