package CreationalDesignPatterns.FactoryMethod.GOOD.product;

public class Car implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by road in a car.");
    }
}
