package CreationalDesignPatterns.FactoryMethod.GOOD.creator;

import CreationalDesignPatterns.FactoryMethod.GOOD.product.HotAirBalloon;
import CreationalDesignPatterns.FactoryMethod.GOOD.product.Transport;

public class HotAirBalloonLogistics extends AirLogistics {
    @Override
    public Transport createTransport() {
        return new HotAirBalloon();
    }
}
