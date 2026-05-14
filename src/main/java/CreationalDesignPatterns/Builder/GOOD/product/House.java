package CreationalDesignPatterns.Builder.GOOD.product;

import CreationalDesignPatterns.Builder.GOOD.builder.HouseBuilder;

/**
 * The Product.
 * This is the complex object we want to build.
 * It only has a private constructor, so it CANNOT be instantiated directly.
 */
public class House {
    private final int walls;
    private final int doors;
    private final int windows;
    private final boolean hasGarage;
    private final boolean hasSwimmingPool;
    private final boolean hasGarden;

    // The constructor is private and takes a Builder object.
    // This enforces immutability and ensures the object is fully constructed.
    public House(HouseBuilder builder) {
        this.walls = builder.walls;
        this.doors = builder.doors;
        this.windows = builder.windows;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarden = builder.hasGarden;
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
