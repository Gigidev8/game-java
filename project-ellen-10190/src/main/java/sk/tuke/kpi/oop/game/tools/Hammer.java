package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Hammer extends BreakableTool {

    // Constructor that initializes the Hammer with a specific number of uses
    public Hammer() {
        super(1);  // Hammer has 1 use
        // Initialize the animation for the hammer
        Animation animation = new Animation("sprites/hammer.png");
        this.setAnimation(animation);  // Set the animation for the Hammer
    }

    //@Override
    protected void removeFromScene() {
        // Logic to remove Hammer from the scene
        System.out.println("Hammer has been removed from the scene.");
        getScene().removeActor(this); // Call the scene's method to remove this actor
    }

    // Override the use method to provide custom behavior when the hammer is used
    @Override
    public void use() {
        if (getRemainingUses() > 0) {
            super.use(); // Call the inherited use method to decrease remaining uses
            System.out.println("Hammer used. Remaining uses: " + getRemainingUses());

            // Remove the hammer from the scene if it has no remaining uses
            if (getRemainingUses() == 0) {
                removeFromScene();
            }
        } else {
            System.out.println("Hammer is broken and cannot be used.");
        }
    }
}
