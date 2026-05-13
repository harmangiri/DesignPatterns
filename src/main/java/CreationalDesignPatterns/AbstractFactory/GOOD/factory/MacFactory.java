package CreationalDesignPatterns.AbstractFactory.GOOD.factory;

import CreationalDesignPatterns.AbstractFactory.GOOD.product.Button;
import CreationalDesignPatterns.AbstractFactory.GOOD.product.Checkbox;
import CreationalDesignPatterns.AbstractFactory.GOOD.product.MacButton;
import CreationalDesignPatterns.AbstractFactory.GOOD.product.MacCheckbox;

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
