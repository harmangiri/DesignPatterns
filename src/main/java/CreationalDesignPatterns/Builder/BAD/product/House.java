package CreationalDesignPatterns.Builder.BAD.product;

/**
 * This class demonstrates the "Telescoping Constructor" anti-pattern.
 * When you have many optional parameters, you end up with a confusing mess of constructors.
 */
public class House {
    // Required parameters
    private final int walls;
    private final int doors;

    // Optional parameters
    private final int windows;
    private final boolean hasGarage;
    private final boolean hasSwimmingPool;
    private final boolean hasGarden;

    // Constructor for basic house
    public House(int walls, int doors) {
        this(walls, doors, 0, false, false, false);
    }

    // Constructor with windows
    public House(int walls, int doors, int windows) {
        this(walls, doors, windows, false, false, false);
    }
    
    // Constructor with windows and garage
    public House(int walls, int doors, int windows, boolean hasGarage) {
        this(walls, doors, windows, hasGarage, false, false);
    }

    // The "Telescoping" all-in-one constructor
    public House(int walls, int doors, int windows, boolean hasGarage, boolean hasSwimmingPool, boolean hasGarden) {
        this.walls = walls;
        this.doors = doors;
        this.windows = windows;
        this.hasGarage = hasGarage;
        this.hasSwimmingPool = hasSwimmingPool;
        this.hasGarden = hasGarden;
    }

    @Override
    public String toString() {
        return "House Details: \n" +
                "  - Walls: " + walls + "\n" +
                "  - Doors: " + doors + "\n" +
                "  - Windows: " + windows + "\n" +
                "  - Has Garage: " + hasGarage + "\n" +
                "  - Has Swimming Pool: " + hasSwimmingPool + "\n" +
                "  - Has Garden: " + hasGarden;
    }
}
