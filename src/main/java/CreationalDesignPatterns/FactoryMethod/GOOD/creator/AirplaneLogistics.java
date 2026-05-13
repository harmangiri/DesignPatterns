package CreationalDesignPatterns.FactoryMethod.GOOD.creator;

import CreationalDesignPatterns.FactoryMethod.GOOD.product.Airplane;
import CreationalDesignPatterns.FactoryMethod.GOOD.product.Transport;

public class AirplaneLogistics extends AirLogistics {
    @Override
    public Transport createTransport() {
        return new Airplane();
    }
}
