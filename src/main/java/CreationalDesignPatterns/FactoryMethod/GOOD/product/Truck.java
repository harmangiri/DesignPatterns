package CreationalDesignPatterns.FactoryMethod.GOOD.product;

// 2. Concrete Products
public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by land in a box.");
    }
}
