package CreationalDesignPatterns.FactoryMethod.GOOD.creator;

import CreationalDesignPatterns.FactoryMethod.GOOD.product.Car;
import CreationalDesignPatterns.FactoryMethod.GOOD.product.Transport;

public class CarLogistics extends RoadLogistics {
    @Override
    public Transport createTransport() {
        return new Car();
    }
}
