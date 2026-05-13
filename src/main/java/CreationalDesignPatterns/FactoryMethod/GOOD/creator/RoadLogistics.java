package CreationalDesignPatterns.FactoryMethod.GOOD.creator;

import CreationalDesignPatterns.FactoryMethod.GOOD.product.Transport;
import CreationalDesignPatterns.FactoryMethod.GOOD.product.Truck;

public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
