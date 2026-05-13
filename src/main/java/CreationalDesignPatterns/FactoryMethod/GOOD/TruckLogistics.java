package CreationalDesignPatterns.FactoryMethod.GOOD;

public class TruckLogistics  extends RoadLogistics{
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
