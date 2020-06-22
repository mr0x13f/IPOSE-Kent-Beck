package impl;

import behavior.behaviors.Collidable;
import game.Tile;

public class Tile_wolf4 extends Tile implements Collidable {
	
    public Tile_wolf4() {
        super("/resources/textures/wolf4.png", false);
    }
    
    @Override
    public void handleCollision(Collidable collidable) {
    	
    }
}