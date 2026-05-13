package CreationalDesignPatterns.AbstractFactory.GOOD.product;

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}
