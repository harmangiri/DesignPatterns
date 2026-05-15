package StructuralDesignPatterns.Bridge.GOOD.app;

import StructuralDesignPatterns.Bridge.GOOD.abstraction.AdvancedRemoteControl;
import StructuralDesignPatterns.Bridge.GOOD.abstraction.RemoteControl;
import StructuralDesignPatterns.Bridge.GOOD.implementation.Device;
import StructuralDesignPatterns.Bridge.GOOD.implementation.Radio;
import StructuralDesignPatterns.Bridge.GOOD.implementation.TV;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GOOD Practice (Bridge Pattern) ---");

        System.out.println(">>> Client tests Basic Remote with TV:");
        Device tv = new TV();
        RemoteControl basicRemote = new RemoteControl(tv); // Bridging Remote to TV
        basicRemote.togglePower();
        basicRemote.volumeUp();

        System.out.println("\n>>> Client tests Advanced Remote with Radio:");
        Device radio = new Radio();
        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(radio); // Bridging AdvRemote to Radio
        advancedRemote.togglePower();
        advancedRemote.mute();
        
        System.out.println("\nBenefits:");
        System.out.println("1. No Class Explosion! We have 2 Device classes + 2 Remote classes = 4 classes total.");
        System.out.println("2. Adding 'AC' only requires 1 new class (AC implements Device).");
        System.out.println("3. Adding 'SmartRemote' only requires 1 new class (SmartRemote extends RemoteControl).");
        System.out.println("4. They grow completely independently!");
    }
}
