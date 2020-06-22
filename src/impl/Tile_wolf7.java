package impl;

import behavior.behaviors.Collidable;
import game.Tile;

public class Tile_wolf7 extends Tile implements Collidable {
	
    public Tile_wolf7() {
        super("/resources/textures/wolf7.png", false);
    }
    
    @Override
    public void handleCollision(Collidable collidable) {
    	
    }
}