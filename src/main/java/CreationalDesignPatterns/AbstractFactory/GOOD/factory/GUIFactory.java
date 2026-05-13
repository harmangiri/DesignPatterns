package CreationalDesignPatterns.AbstractFactory.GOOD.factory;

import CreationalDesignPatterns.AbstractFactory.GOOD.product.Button;
import CreationalDesignPatterns.AbstractFactory.GOOD.product.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
