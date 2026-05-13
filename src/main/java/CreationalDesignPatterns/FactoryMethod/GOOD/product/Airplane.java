package CreationalDesignPatterns.FactoryMethod.GOOD.product;

public class Airplane implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by air in a plane.");
    }
}
