package StructuralDesignPatterns.Bridge.GOOD.implementation;

/**
 * Concrete Implementation 2.
 */
public class Radio implements Device {
    private boolean on = false;
    private int volume = 10;

    @Override
    public boolean isEnabled() { return on; }

    @Override
    public void enable() {
        on = true;
        System.out.println("Radio is now ON.");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("Radio is now OFF.");
    }

    @Override
    public int getVolume() { return volume; }

    @Override
    public void setVolume(int percent) {
        if (percent > 100) this.volume = 100;
        else if (percent < 0) this.volume = 0;
        else this.volume = percent;
        System.out.println("Radio volume set to " + this.volume + "%");
    }
}
