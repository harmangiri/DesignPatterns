package CreationalDesignPatterns.FactoryMethod.GOOD.creator;

import CreationalDesignPatterns.FactoryMethod.GOOD.product.Transport;
import CreationalDesignPatterns.FactoryMethod.GOOD.product.Truck;

public class TruckLogistics extends RoadLogistics{
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
