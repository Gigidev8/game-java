package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor {
    private boolean isPowered;
    private final Animation lightOnAnimation;
    private final Animation lightOffAnimation;

    public Light() {
        this.lightOnAnimation = new Animation("sprites/light_on.png");
        this.lightOffAnimation = new Animation("sprites/light_off.png");
        setAnimation(lightOffAnimation); // Start with light off
        this.isPowered = false;
    }

    public void turnOn() {
        this.isPowered = true;
        setAnimation(lightOnAnimation);
    }

    public void turnOff() {
        this.isPowered = false;
        setAnimation(lightOffAnimation);
    }

    // New method to control electricity flow to the light
    public void setElectricityFlow(boolean powered) {
        this.isPowered = powered;
        if (this.isPowered) {
            turnOn();
        } else {
            turnOff();
        }
    }

    // Public method to check if the light is on
    public boolean isOn() {
        return isPowered;
    }
}
