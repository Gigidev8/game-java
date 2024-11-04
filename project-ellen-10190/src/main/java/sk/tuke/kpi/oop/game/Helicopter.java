package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.Player;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.Scene;


public class Helicopter extends AbstractActor {
    private Player player; // Reference to the player

    public Helicopter() {
        // Load the helicopter animation
        Animation heliAnimation = new Animation("sprites/heli.png", 80, 80, 0.1f, Animation.PlayMode.LOOP);
        setAnimation(heliAnimation);
    }

    // Method to start searching and attacking the player
    public void searchAndDestroy() {
        Scene scene = getScene();
        if (scene != null) {
            player = (Player) scene.getFirstActorByName("Player"); // Get reference to the player

            if (player != null) {
                new Invoke<>(this::moveTowardsPlayer).scheduleFor(this); // Schedule the action
            }
        }
    }

    // Method to move towards the player
    private void moveTowardsPlayer() {
        if (player != null) {
            // Check if the helicopter is touching the player
            if (this.getBoundingBox().overlaps(player.getBoundingBox())) {
                player.decreaseEnergy(1); // Decrease player's energy by 1 on collision
                System.out.println("Helicopter has attacked the player!");
            } else {
                // Move towards the player's position
                float dx = player.getX() - getX();
                float dy = player.getY() - getY();
                float distance = (float) Math.sqrt(dx * dx + dy * dy);

                if (distance > 0) {
                    float moveX = dx / distance;
                    float moveY = dy / distance;

                    // Move the helicopter towards the player
                    setPosition(getX() + moveX, getY() + moveY);
                }
            }
        }
    }
}
