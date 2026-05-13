package CreationalDesignPatterns.AbstractFactory.BAD.app;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- BAD Practice (Without Abstract Factory) ---");
        
        Application windowsApp = new Application("Windows");
        windowsApp.render();
        
        System.out.println();
        
        Application macApp = new Application("Mac");
        macApp.render();
    }
}
