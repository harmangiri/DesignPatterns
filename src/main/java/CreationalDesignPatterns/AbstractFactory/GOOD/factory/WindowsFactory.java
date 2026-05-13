package CreationalDesignPatterns.AbstractFactory.GOOD.factory;

import CreationalDesignPatterns.AbstractFactory.GOOD.product.Button;
import CreationalDesignPatterns.AbstractFactory.GOOD.product.Checkbox;
import CreationalDesignPatterns.AbstractFactory.GOOD.product.WindowsButton;
import CreationalDesignPatterns.AbstractFactory.GOOD.product.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
