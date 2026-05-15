package StructuralDesignPatterns.Bridge.BAD.remotes;

/**
 * Base Abstraction simulating the "Class Explosion" problem with Inheritance.
 */
public abstract class RemoteControl {
    public abstract void turnOn();
    public abstract void turnOff();
}
