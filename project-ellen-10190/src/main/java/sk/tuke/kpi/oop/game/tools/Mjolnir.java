package sk.tuke.kpi.oop.game.tools;

public class Mjolnir extends Hammer {
    private static final int INITIAL_USES = 4; // Mjolnir lasts for 4 uses

    private int remainingUses;

    public Mjolnir() {
        super(); // Call the parent constructor (default)
        this.remainingUses = INITIAL_USES; // Initialize remaining uses to 4
    }

    @Override
    public void use() {
        if (remainingUses > 0) {
            super.use(); // Call the parent use method
            remainingUses--; // Decrease remaining uses
            // Additional functionality can be added here if desired
        } else {
            // Optionally handle the case when Mjolnir is out of uses
            // e.g., remove from scene or display a message
        }
    }

    public int getRemainingUses() {
        return remainingUses;
    }
}

