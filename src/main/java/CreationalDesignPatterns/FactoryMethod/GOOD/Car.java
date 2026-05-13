package CreationalDesignPatterns.FactoryMethod.GOOD;

public class Car implements Transport{
    @Override
    public void deliver() {
        System.out.println("Deliver by land in a car.");
    }
}
