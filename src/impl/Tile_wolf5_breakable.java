package impl;

import behavior.behaviors.Collidable;
import game.Tile;

public class Tile_wolf5_breakable extends Tile implements Collidable {
	
    public Tile_wolf5_breakable() {
        super("/resources/textures/wolf5_breakable.png", true);
    }
    
    @Override
    public void handleCollision(Collidable collidable) {
    	
    }
}