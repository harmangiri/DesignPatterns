package CreationalDesignPatterns.Builder.GOOD.builder;

import CreationalDesignPatterns.Builder.GOOD.product.House;

/**
 * The Builder.
 * This class exposes a fluent interface to construct a House step-by-step.
 */
public class HouseBuilder {
    
    // Package-private or public fields so the product can access them during construction
    public int walls;
    public int doors;
    public int windows;
    public boolean hasGarage;
    public boolean hasSwimmingPool;
    public boolean hasGarden;

    // Required parameters can be passed in the builder's constructor
    public HouseBuilder(int walls, int doors) {
        this.walls = walls;
        this.doors = doors;
    }

    // Optional steps return "this" to allow method chaining
    public HouseBuilder setWindows(int windows) {
        this.windows = windows;
        return this;
    }

    public HouseBuilder addGarage() {
        this.hasGarage = true;
        return this;
    }

    public HouseBuilder addSwimmingPool() {
        this.hasSwimmingPool = true;
        return this;
    }

    public HouseBuilder addGarden() {
        this.hasGarden = true;
        return this;
    }

    /**
     * The final step that returns the fully constructed product.
     */
    public House build() {
        return new House(this);
    }
}
