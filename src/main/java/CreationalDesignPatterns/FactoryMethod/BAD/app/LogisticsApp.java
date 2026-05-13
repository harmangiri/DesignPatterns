package CreationalDesignPatterns.FactoryMethod.BAD.app;

import CreationalDesignPatterns.FactoryMethod.BAD.transport.Ship;
import CreationalDesignPatterns.FactoryMethod.BAD.transport.Truck;

public class LogisticsApp {
    public void planDelivery(String transportType) {
        // BAD PRACTICE: Tightly coupled to specific classes.
        // Any new transport type requires modifying this class (violates Open/Closed Principle).
        // If we add 'Air' transport, we have to modify this code again.
        if (transportType.equalsIgnoreCase("road")) {
            Truck truck = new Truck();
            truck.deliver();
        } else if (transportType.equalsIgnoreCase("sea")) {
            Ship ship = new Ship();
            ship.deliver();
        } else {
            System.out.println("Unknown transport type.");
        }
    }
}
