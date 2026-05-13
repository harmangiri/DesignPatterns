package CreationalDesignPatterns.FactoryMethod.GOOD;

// 2. Concrete Products
public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by Truck in a box via land.");
    }
}
