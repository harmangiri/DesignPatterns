package CreationalDesignPatterns.Builder.GOOD.app;

import CreationalDesignPatterns.Builder.GOOD.builder.HouseBuilder;
import CreationalDesignPatterns.Builder.GOOD.product.House;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GOOD Practice (Builder Pattern) ---");

        // Building a complex mansion using method chaining (Fluent Interface).
        // Notice how readable this is compared to `new House(4, 2, 4, true, false, true)`!
        House mansion = new HouseBuilder(4, 2)
                .setWindows(4)
                .addGarage()
                .addGarden()
                // Notice we didn't have to call addSwimmingPool() or pass `false`
                .build();
                
        System.out.println("Mansion Created:\n" + mansion.toString());

        System.out.println("----------------------------------------------");

        // Building a simple cabin
        House cabin = new HouseBuilder(4, 1)
                .setWindows(2)
                .build();
                
        System.out.println("Cabin Created:\n" + cabin.toString());
    }
}
