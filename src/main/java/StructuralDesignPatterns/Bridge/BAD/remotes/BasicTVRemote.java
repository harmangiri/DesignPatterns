package StructuralDesignPatterns.Bridge.BAD.remotes;

/**
 * Level 2 of inheritance (Concrete device + Concrete remote)
 */
public class BasicTVRemote extends TVRemote {
    @Override 
    public void turnOn() { 
        System.out.println("Basic TV Remote: Turning ON TV"); 
    }
    
    @Override 
    public void turnOff() { 
        System.out.println("Basic TV Remote: Turning OFF TV"); 
    }
}
