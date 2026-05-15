package StructuralDesignPatterns.Bridge.GOOD.abstraction;

import StructuralDesignPatterns.Bridge.GOOD.implementation.Device;

/**
 * The Abstraction.
 * It maintains a reference to an object of the Implementation hierarchy (the "Bridge")
 * and delegates all real work to this object.
 */
public class RemoteControl {
    // The "Bridge" reference
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void togglePower() {
        System.out.println("Remote: power toggle button pressed");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    public void volumeDown() {
        System.out.println("Remote: volume down button pressed");
        device.setVolume(device.getVolume() - 10);
    }

    public void volumeUp() {
        System.out.println("Remote: volume up button pressed");
        device.setVolume(device.getVolume() + 10);
    }
}
