package CreationalDesignPatterns.AbstractFactory.GOOD.app;

import CreationalDesignPatterns.AbstractFactory.GOOD.factory.GUIFactory;
import CreationalDesignPatterns.AbstractFactory.GOOD.factory.MacFactory;
import CreationalDesignPatterns.AbstractFactory.GOOD.factory.WindowsFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GOOD Practice (Abstract Factory) ---");
        
        GUIFactory windowsFactory = new WindowsFactory();
        Application windowsApp = new Application(windowsFactory);
        windowsApp.render();
        
        System.out.println();
        
        GUIFactory macFactory = new MacFactory();
        Application macApp = new Application(macFactory);
        macApp.render();
    }
}
