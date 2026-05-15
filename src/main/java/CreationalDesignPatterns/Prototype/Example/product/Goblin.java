package CreationalDesignPatterns.Prototype.Example.product;

/**
 * Concrete Prototype: Goblin Enemy.
 * Imagine this object takes 5 seconds to load from a database or file (textures, AI logic, stats).
 */
public class Goblin implements Enemy {
    private int health;
    private int damage;
    private String aiLogic;
    private String textureData; // Heavy data
    private int x, y;

    public Goblin() {
        System.out.println("  [DB Call] Loading heavy Goblin data from database... (Simulating 2s delay)");
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        this.health = 100;
        this.damage = 15;
        this.aiLogic = "Aggressive Melee";
        this.textureData = "goblin_texture_1024x1024.png (10MB)";
    }

    // Private copy constructor for cloning
    private Goblin(Goblin source) {
        this.health = source.health;
        this.damage = source.damage;
        this.aiLogic = source.aiLogic;
        this.textureData = source.textureData;
        // Coordinates are usually set per instance after cloning
    }

    @Override
    public Enemy clone() {
        return new Goblin(this); // Instantly copies memory without hitting DB again
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void spawn() {
        System.out.println("Spawned Goblin at (" + x + "," + y + ") with " + health + " HP and AI: " + aiLogic);
    }
}
