package CreationalDesignPatterns.FactoryMethod.GOOD;

public class CarLogistics extends RoadLogistics{
    @Override
    public Transport createTransport() {
        return new Car();
    }
}
