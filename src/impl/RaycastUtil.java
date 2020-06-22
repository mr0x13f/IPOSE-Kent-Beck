package impl;

import game.Level;
import game.Tile;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class RaycastUtil {
	
	private static Level lastLevel;

	public static Raycast cast( Level level, double startX, double startY, double directionX, double directionY, boolean shoot ) {

		// https://lodev.org/cgtutor/raycasting.html
		
		lastLevel = level;
	    int x = (int)startX;
		int y = (int)startY;
	    double sideDistX = 0;
		double sideDistY = 0;
	    double deltaDistX = Math.abs( 1 / directionX );
	    double deltaDistY = Math.abs( 1 / directionY );
	    double distance = 0;
	    double stepX = 0;
		double stepY = 0;
	    int side = 0;
	    double endX = startX;
	    double endY = startY;
	    double wallX = 0;
	    Image image;
	    Raycast raycast = new Raycast();
	    		

	    // Bepalen hoe ver de ray per stap moet bewegen
	    if (directionX < 0) {
	        stepX = -1;
	        sideDistX = (startX - x) * deltaDistX;
	    } else {
	        stepX = 1;
	        sideDistX = (x + 1 - startX) * deltaDistX;
	    }
	    if (directionY < 0) {
	        stepY = -1;
	        sideDistY = (startY - y) * deltaDistY;
	    } else {
	        stepY = 1;
	        sideDistY = (y + 1 - startY) * deltaDistY;
	    }
	    
	    // Stappen zetten totdat we een tile vinden
	    while (true) {

	        if (sideDistX < sideDistY) {
	            endX = startX + sideDistX * directionX;
	            endY = startY + sideDistX * directionY;
	            sideDistX += deltaDistX;
	            x += stepX;
	            side = 0;
	        } else {
	            endX = startX + sideDistY * directionX;
	            endY = startY + sideDistY * directionY;
	            sideDistY += deltaDistY;
	            y += stepY;
	            side = 1;
	        }

	        // Stop als de ray buiten het level komt
	        if (x < 0 || x >= level.getTiles()[0].length || y < 0 || y >= level.getTiles().length) {
	            break;
	        }

	        // Tile gevonden
	        if (level.getTiles()[x][y].getWall()) {
	        	if (level.getTiles()[x][y].isShot()) {
	        		raycast.setImage(level.getTiles()[x][y].getShotTexture());
	        	} else {
	        		raycast.setImage(level.getTiles()[x][y].getTexture());
	        	}
	            break;
	        }

	    }

	    // Kijk waar de ray de tile raakt
	    if (side == 0) {
	        distance = (x - startX + (1 - stepX) / 2) / directionX;
	        wallX = startY + distance * directionY;
	    } else {
	        distance = (y - startY + (1 - stepY) / 2) / directionY;
	        wallX = startX + distance * directionX;
	    }
	    wallX -= (int)wallX;
	    
	    if (shoot) {
	    	
		    // Break
		    if (level.getTiles()[x][y].getBreakable()) {
		    	level.getTiles()[x][y] = new Tile_air();
		    }
		    
		    // Shoot
		    if (level.getTiles()[x][y].getShootable() && !level.getTiles()[x][y].isShot()) {
		    	level.getTiles()[x][y].shoot();
		    	raycast.setHit(true);
		    }
		    
	    }
	    
	    // Stop de informatie in een Raycast en return deze
	    raycast.setEndX(endX);
	    raycast.setEndY(endY);
	    raycast.setDistance(distance);
	    raycast.setSide(side);
	    raycast.setWallPosX(wallX);
	    return raycast;

	}
	
	public static boolean shoot( double startX, double startY, double directionX, double directionY ) {

		// https://lodev.org/cgtutor/raycasting.html

	    Level level = lastLevel;
	    Raycast raycast = cast(level, startX, startY, directionX, directionY, true);
	    return raycast.isHit();

	}
	
	
}
