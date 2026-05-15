package StructuralDesignPatterns.Bridge.BAD.remotes;

/**
 * Level 2 of inheritance (Concrete device + Concrete remote)
 */
public class BasicRadioRemote extends RadioRemote {
    @Override 
    public void turnOn() { 
        System.out.println("Basic Radio Remote: Turning ON Radio"); 
    }
    
    @Override 
    public void turnOff() { 
        System.out.println("Basic Radio Remote: Turning OFF Radio"); 
    }
}
