package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Controller extends AbstractActor {
    private final Reactor reactor;

    public Controller(Reactor reactor) {
        super(("sprites/switch.png"));  // Assuming a single frame
        this.reactor = reactor;
    }

    public void toggle() {
        if (reactor.isRunning()) {
            reactor.turnOff();
        } else {
            reactor.turnOn();
        }
    }
}
