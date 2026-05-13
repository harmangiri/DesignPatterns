package CreationalDesignPatterns.AbstractFactory.GOOD.product;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}
