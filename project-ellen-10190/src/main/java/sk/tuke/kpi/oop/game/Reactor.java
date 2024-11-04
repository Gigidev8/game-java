package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.oop.game.actions.PerpetualReactorHeating;

public class Reactor extends AbstractActor {
    private int temperature;
    private int damage;
    private boolean isRunning;
    private Light connectedLight;  // Reference to the connected light
    private final Animation normalAnimation;
    private final Animation hotAnimation;
    private final Animation brokenAnimation;
    public static final int MAX_TEMPERATURE = 6000;
    public static final int OVERHEAT_WARNING_TEMPERATURE = 4000;
    public static final int SMART_COOLER_ACTIVATION_TEMPERATURE = 2500;
    public static final int SMART_COOLER_DEACTIVATION_TEMPERATURE = 1500;

    public Reactor() {
        this.temperature = 0;
        this.damage = 0;
        this.isRunning = false;

        this.normalAnimation = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        this.hotAnimation = new Animation("sprites/reactor_hot.png", 80, 80, 0.05f, Animation.PlayMode.LOOP_PINGPONG);
        this.brokenAnimation = new Animation("sprites/reactor_broken.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);

        setAnimation(normalAnimation);
    }

    @Override
    public void addedToScene(Scene scene) {
        super.addedToScene(scene);
        // Schedule perpetual heating for the reactor
        new PerpetualReactorHeating(1).scheduleFor(this);
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public void turnOn() {
        if (!this.isRunning && this.damage < 100) {
            this.isRunning = true;
            updateAnimation();
            updateLight();  // Update the light state
        }
    }

    public void turnOff() {
        this.isRunning = false;
        updateAnimation();
        updateLight();  // Update the light state
    }

    public void increaseTemperature(int increment) {
        if (increment < 0 || this.damage == 100 || !this.isRunning) {
            return;
        }

        if (this.damage >= 33 && this.damage <= 66) {
            increment = (int) Math.ceil(increment * 1.5);
        } else if (this.damage > 66) {
            increment = (int) Math.ceil(increment * 2);
        }

        this.temperature += increment;

        if (this.temperature > 2000) {
            this.damage = Math.min(100, (this.temperature - 2000) / 40);
        }

        if (this.temperature >= 6000) {
            this.damage = 100;
        }

        updateAnimation();
    }

    public void decreaseTemperature(int decrement) {
        if (decrement < 0 || this.damage == 100 || !this.isRunning) {
            return;
        }

        int actualDecrement = this.damage >= 50 ? decrement / 2 : decrement;
        this.temperature = Math.max(0, this.temperature - actualDecrement);

        updateAnimation();
    }

    // Add remaining methods for light and animation handling...

    private void updateLight() {
        // Implementation for light update...
    }

    private void updateAnimation() {
        // Implementation for animation update...
    }
}
