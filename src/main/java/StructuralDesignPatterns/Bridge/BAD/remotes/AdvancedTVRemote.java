package StructuralDesignPatterns.Bridge.BAD.remotes;

/**
 * Level 2 of inheritance (Concrete device + Concrete remote)
 */
public class AdvancedTVRemote extends TVRemote {
    @Override 
    public void turnOn() { 
        System.out.println("Advanced TV Remote: Turning ON TV"); 
    }
    
    @Override 
    public void turnOff() { 
        System.out.println("Advanced TV Remote: Turning OFF TV"); 
    }
    
    public void mute() { 
        System.out.println("Advanced TV Remote: Muting TV"); 
    }
}
