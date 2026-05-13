package CreationalDesignPatterns.FactoryMethod.GOOD;

public class HotAirBalloonLogistics extends AirLogistics {
    @Override
    public Transport createTransport() {
        return new HotAirBalloon();
    }
}
