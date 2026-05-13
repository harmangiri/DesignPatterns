package CreationalDesignPatterns.AbstractFactory.BAD.app;

import CreationalDesignPatterns.AbstractFactory.BAD.components.*;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(String osType) {
        if (osType.equals("Windows")) {
            button = new WindowsButton();
            checkbox = new WindowsCheckbox();
        } else if (osType.equals("Mac")) {
            button = new MacButton();
            checkbox = new MacCheckbox();
        }
    }

    public void render() {
        if(button != null && checkbox != null){
            button.render();
            checkbox.render();
        }
    }
}
