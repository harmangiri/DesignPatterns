package StructuralDesignPatterns.Bridge.BAD.remotes;

/**
 * Level 2 of inheritance (Concrete device + Concrete remote)
 */
public class AdvancedRadioRemote extends RadioRemote {
    @Override 
    public void turnOn() { 
        System.out.println("Advanced Radio Remote: Turning ON Radio"); 
    }
    
    @Override 
    public void turnOff() { 
        System.out.println("Advanced Radio Remote: Turning OFF Radio"); 
    }
    
    public void mute() { 
        System.out.println("Advanced Radio Remote: Muting Radio"); 
    }
}
