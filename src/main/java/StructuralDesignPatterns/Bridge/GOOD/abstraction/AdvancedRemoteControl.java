package StructuralDesignPatterns.Bridge.GOOD.abstraction;

import StructuralDesignPatterns.Bridge.GOOD.implementation.Device;

/**
 * Refined Abstraction.
 * Extends the basic abstraction with new features, without touching the Device classes.
 */
public class AdvancedRemoteControl extends RemoteControl {

    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Remote: mute button pressed");
        device.setVolume(0);
    }
}
