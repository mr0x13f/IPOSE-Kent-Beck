package impl;

import behavior.behaviors.Collidable;
import game.Tile;

public class Tile_wolf5 extends Tile implements Collidable {
	
    public Tile_wolf5() {
        super("/resources/textures/wolf5.png", false);
    }
    
    @Override
    public void handleCollision(Collidable collidable) {
    	
    }
}