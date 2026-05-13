package CreationalDesignPatterns.AbstractFactory.BAD.components;

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}
