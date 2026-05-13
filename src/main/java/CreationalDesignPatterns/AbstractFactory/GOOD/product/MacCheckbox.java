package CreationalDesignPatterns.AbstractFactory.GOOD.product;

public class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Mac Checkbox");
    }
}
