package CreationalDesignPatterns.FactoryMethod.GOOD;

public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
