package impl;

import behavior.behaviors.Collidable;
import game.Tile;

public class Tile_wolf2 extends Tile implements Collidable {
	
    public Tile_wolf2() {
        super("/resources/textures/wolf2.png", false);
    }
    
    @Override
    public void handleCollision(Collidable collidable) {
    	
    }
}