package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;

public class Cooler extends AbstractActor {
    private Reactor reactor; // Reference to the connected reactor
    private boolean cooling;

    public void connectToReactor(Reactor reactor) {
        this.reactor = reactor;
    }

    public Reactor getReactor() {
        return reactor;
    }

    public boolean isCooling() {
        return cooling;
    }

    public void turnOn() {
        cooling = true;
        System.out.println("Cooler: Cooling is ON.");
    }

    public void turnOff() {
        cooling = false;
        System.out.println("Cooler: Cooling is OFF.");
    }
}
