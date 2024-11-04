package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;

public class FireExtinguisher extends BreakableTool {

    // Constructor to initialize the number of usages and set the image
    public FireExtinguisher() {
        super(1);  // Fire extinguisher has 1 usage
        // Set extinguisher image with specific size
        setAnimation(new Animation("sprites/extinguisher.png", 16, 16));
    }

//    @Override
    protected void removeFromScene() {
        // Logic to remove the Fire Extinguisher from the scene
        System.out.println("Fire extinguisher used up and removed from the game.");
        getScene().removeActor(this); // Call the scene's method to remove this actor
    }

    @Override
    public void use() {
        if (getRemainingUses() > 0) {
            super.use(); // Call the inherited use method to decrease remaining usages
            System.out.println("Fire extinguisher used. Remaining usages: " + getRemainingUses());

            // Remove the fire extinguisher from the scene if it has no remaining usages
            if (getRemainingUses() == 0) {
                removeFromScene();
            }
        } else {
            System.out.println("Fire extinguisher is empty and cannot be used.");
        }
    }
}
