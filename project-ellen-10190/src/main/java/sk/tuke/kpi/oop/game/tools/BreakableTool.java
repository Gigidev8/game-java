package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.framework.AbstractActor;

public abstract class BreakableTool extends AbstractActor {
    private int remainingUses;

    public BreakableTool(int initialUsages) {
        this.remainingUses = initialUsages;
    }

    public int getRemainingUses() {
        return remainingUses;
    }

    public void use() {
        if (remainingUses > 0) {
            remainingUses--;
            if (remainingUses == 0) {
                // Code to remove this tool from the scene
                System.out.println("Tool has broken.");
            }
        }
    }
}
