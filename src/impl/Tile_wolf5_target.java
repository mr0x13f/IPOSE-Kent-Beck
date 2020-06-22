package impl;

import behavior.behaviors.Collidable;
import game.Tile;

public class Tile_wolf5_target extends Tile implements Collidable {
	
    public Tile_wolf5_target() {
        super("/resources/textures/wolf5_target.png", "/resources/textures/wolf5_target_shot.png");
    }
    
    @Override
    public void handleCollision(Collidable collidable) {
    	
    }
}