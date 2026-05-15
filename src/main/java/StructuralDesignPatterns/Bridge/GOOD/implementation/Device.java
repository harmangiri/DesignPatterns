package StructuralDesignPatterns.Bridge.GOOD.implementation;

/**
 * The Implementation interface.
 * It provides primitive operations that the Abstraction will use.
 */
public interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
}
