package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;

public class SmartCooler extends Cooler {
    public SmartCooler() {
        // Schedule the temperature check action
        new Loop<>(new Invoke<>(this::checkReactorTemperature)).scheduleFor(this);
    }

    // Method to check the temperature of the connected reactor and control cooling
    private void checkReactorTemperature() {
        Reactor reactor = getReactor(); // Get the connected reactor

        if (reactor != null) {
            int currentTemperature = reactor.getTemperature();
            if (currentTemperature > Reactor.SMART_COOLER_ACTIVATION_TEMPERATURE) {
                if (!isCooling()) { // Check if the cooler is not already cooling
                    turnOn(); // Turn on the cooler
                    System.out.println("SmartCooler: Turning on to cool the reactor.");
                }
            } else if (currentTemperature < Reactor.SMART_COOLER_DEACTIVATION_TEMPERATURE) {
                if (isCooling()) { // Check if the cooler is cooling
                    turnOff(); // Turn off the cooler
                    System.out.println("SmartCooler: Turning off, reactor is cool enough.");
                }
            }
        }
    }
}
