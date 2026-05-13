package CreationalDesignPatterns.FactoryMethod.GOOD.product;

public class HotAirBalloon implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by air in a hot air balloon.");
    }
}
