package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import java.util.Random;

public class DefectiveLight extends Light {
    private final Random random = new Random();  // Random number generator

    // Method to define blinking behavior for defective light
    private void blink() {
        // Generate a random number between 0 and 20
        int chance = random.nextInt(21);
        if (chance == 1) {  // 5% chance to toggle the light
            if (isOn()) {
                turnOff();  // Turn off the light if it's currently on
            } else {
                turnOn();   // Turn on the light if it's currently off
            }
        }
    }

    @Override
    public void addedToScene(Scene scene) {
        super.addedToScene(scene);
        // Schedule a repeating action that calls blink() at regular intervals
        new Loop<>(new Invoke<>(this::blink)).scheduleFor(this);
    }
}
