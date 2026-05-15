package CreationalDesignPatterns.Prototype.Example.app;

import CreationalDesignPatterns.Prototype.Example.product.Enemy;
import CreationalDesignPatterns.Prototype.Example.registry.EnemyRegistry;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== Game NPC Spawner (Prototype Pattern) ======\n");

        long startTime = System.currentTimeMillis();

        // 1. Initialize the Registry (Simulates server startup, loads heavy data once)
        EnemyRegistry registry = new EnemyRegistry();

        long initializationTime = System.currentTimeMillis();
        System.out.println("Initialization took: " + (initializationTime - startTime) + "ms\n");

        System.out.println("--- Spawning 5 Goblins instantly using Cloning ---");
        
        long cloneStartTime = System.currentTimeMillis();
        
        // 2. Clone 5 Goblins instantly without hitting the "database" again
        for (int i = 0; i < 5; i++) {
            Enemy clonedGoblin = registry.getEnemy("Goblin");
            clonedGoblin.setPosition(i * 10, i * 15); // Customize the clone
            clonedGoblin.spawn();
        }

        System.out.println("\n--- Spawning 1 Boss Dragon instantly using Cloning ---");
        Enemy clonedDragon = registry.getEnemy("Dragon");
        clonedDragon.setPosition(100, 100);
        clonedDragon.spawn();

        long cloneEndTime = System.currentTimeMillis();
        System.out.println("\nCloning 6 enemies took: " + (cloneEndTime - cloneStartTime) + "ms!");
        
        // Without the prototype pattern, spawning 5 Goblins and 1 Dragon would have taken 
        // 5 * 2s + 3s = 13 seconds! With Prototype, it takes less than 5 milliseconds!
    }
}
