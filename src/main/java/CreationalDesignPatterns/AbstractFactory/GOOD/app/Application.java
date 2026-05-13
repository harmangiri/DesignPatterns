package CreationalDesignPatterns.AbstractFactory.GOOD.app;

import CreationalDesignPatterns.AbstractFactory.GOOD.factory.GUIFactory;
import CreationalDesignPatterns.AbstractFactory.GOOD.product.Button;
import CreationalDesignPatterns.AbstractFactory.GOOD.product.Checkbox;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void render() {
        button.render();
        checkbox.render();
    }
}
