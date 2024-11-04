package sk.tuke.kpi.oop.game.actions;

import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.actions.Action;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.oop.game.Reactor;

public class PerpetualReactorHeating implements Action {
    private final int increment;
    private boolean running = true;

    public PerpetualReactorHeating(int increment) {
        this.increment = increment;
    }


    public void execute(Actor actor) {
        if (running && actor instanceof Reactor) {
            ((Reactor) actor).increaseTemperature(increment);
        }
    }

    public void stop() {
        running = false;
    }

    // Method to schedule the action repeatedly, depends on your game loop
    public void scheduleFor(Reactor actor) {
        // This method will handle scheduling the action at intervals
    }

    @Override
    public @Nullable Actor getActor() {
        return null;
    }

    @Override
    public void setActor(@Nullable Actor actor) {

    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public void execute(float deltaTime) {

    }

    @Override
    public void reset() {

    }
}
