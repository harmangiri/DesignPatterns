package CreationalDesignPatterns.Prototype.Example.product;

/**
 * Concrete Prototype: Dragon Enemy.
 * Highly complex and expensive to create.
 */
public class Dragon implements Enemy {
    private int health;
    private int damage;
    private String aiLogic;
    private String fireBreathParticleEffect; // Heavy data
    private int x, y;

    public Dragon() {
        System.out.println("  [DB Call] Loading extremely heavy Dragon data from database... (Simulating 3s delay)");
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        this.health = 5000;
        this.damage = 250;
        this.aiLogic = "Flying Ranged Boss";
        this.fireBreathParticleEffect = "fire_breath_4k.fx (50MB)";
    }

    private Dragon(Dragon source) {
        this.health = source.health;
        this.damage = source.damage;
        this.aiLogic = source.aiLogic;
        this.fireBreathParticleEffect = source.fireBreathParticleEffect;
    }

    @Override
    public Enemy clone() {
        return new Dragon(this); // Instant clone
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void spawn() {
        System.out.println("Spawned Boss Dragon at (" + x + "," + y + ") with " + health + " HP. AI: " + aiLogic);
    }
}
