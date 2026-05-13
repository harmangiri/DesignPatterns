package CreationalDesignPatterns.AbstractFactory.BAD.components;

public class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Mac Checkbox");
    }
}
