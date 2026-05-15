package CreationalDesignPatterns.Prototype.Example.registry;

import CreationalDesignPatterns.Prototype.Example.product.Dragon;
import CreationalDesignPatterns.Prototype.Example.product.Enemy;
import CreationalDesignPatterns.Prototype.Example.product.Goblin;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototype Registry (Cache): Stores prototypes and provides a way to access cloned copies.
 */
public class EnemyRegistry {
    private Map<String, Enemy> cache = new HashMap<>();

    public EnemyRegistry() {
        // Load prototypes initially (Expensive operation, happens only ONCE)
        System.out.println("Initializing Enemy Registry (Loading Prototypes)...");
        
        Goblin goblinPrototype = new Goblin();
        cache.put("Goblin", goblinPrototype);
        
        Dragon dragonPrototype = new Dragon();
        cache.put("Dragon", dragonPrototype);
        
        System.out.println("Registry Initialization Complete!\n");
    }

    /**
     * Gets a CLONED instance of the requested enemy.
     */
    public Enemy getEnemy(String type) {
        Enemy prototype = cache.get(type);
        if (prototype != null) {
            return prototype.clone(); // Return a fast, in-memory copy!
        }
        return null;
    }
}
