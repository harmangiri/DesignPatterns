package StructuralDesignPatterns.Bridge.BAD.app;

import StructuralDesignPatterns.Bridge.BAD.remotes.AdvancedRadioRemote;
import StructuralDesignPatterns.Bridge.BAD.remotes.BasicTVRemote;
import StructuralDesignPatterns.Bridge.BAD.remotes.RemoteControl;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- BAD Practice (Inheritance causes Class Explosion) ---");

        RemoteControl basicTV = new BasicTVRemote();
        basicTV.turnOn();

        AdvancedRadioRemote advRadio = new AdvancedRadioRemote();
        advRadio.mute();

        System.out.println("\nProblems:");
        System.out.println("1. We have 4 concrete classes for just 2 devices and 2 remote types (2x2).");
        System.out.println("2. If we add 'AC' and 'SmartRemote', we need 3x3 = 9 classes!");
        System.out.println("3. Adding a new platform requires creating a huge number of classes. This is unmaintainable.");
    }
}
