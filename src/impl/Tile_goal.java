package impl;

import behavior.behaviors.Collidable;
import game.Tile;

public class Tile_goal extends Tile implements Collidable {
	
    public Tile_goal() {
        super("/resources/textures/goal.png", false);
    }
    
    @Override
    public void handleCollision(Collidable collidable) {
    	
    }
}