package impl;


import behavior.behaviors.Collidable;
import behavior.behaviors.KeyBehavior;
import engine.Renderer;
import game.Element;
import game.Level;
import game.Tile;

import java.util.ArrayList;

public class Player extends Element implements Collidable, KeyBehavior {

    private double deltaY;
    private double deltaX;
    private final double cameraSensitivity = 2;
    private final double moveSpeed = 2;
    private final double cameraOffset = 0.25;
    private int playerNumber = 1; // 1 of 2
    private boolean canShoot = true;


    public Player() {
        super("/resources/player.png");
        this.deltaY = 0;
        this.deltaX = 0;
    }


    @Override
    public void handleKeyPresses(ArrayList<String> arrayList) {
        this.deltaX = 0;
        this.deltaY = 0;
        
        if(arrayList.contains("W")){
        	deltaX += Math.cos(Renderer.getCameraARotation()/180*Math.PI) * moveSpeed;
        	deltaY += Math.sin(Renderer.getCameraARotation()/180*Math.PI) * moveSpeed;
        }
        
        if(arrayList.contains("S")){
        	deltaX -= Math.cos(Renderer.getCameraARotation()/180*Math.PI) * moveSpeed;
        	deltaY -= Math.sin(Renderer.getCameraARotation()/180*Math.PI) * moveSpeed;
        }
        
        if(arrayList.contains("A")){
        	deltaX += Math.cos((Renderer.getCameraARotation()-90)/180*Math.PI) * moveSpeed;
        	deltaY += Math.sin((Renderer.getCameraARotation()-90)/180*Math.PI) * moveSpeed;
        }
        
        if(arrayList.contains("D")){
        	deltaX -= Math.cos((Renderer.getCameraARotation()-90)/180*Math.PI) * moveSpeed;
        	deltaY -= Math.sin((Renderer.getCameraARotation()-90)/180*Math.PI) * moveSpeed;
        }
        
        if(arrayList.contains("SPACE")){
        	if (canShoot) {
        		shoot();
        		canShoot = false;
        	}
        } else {
        	canShoot = true;
        }
        

        super.setX(super.getX()+deltaX);
        super.setY(super.getY()+deltaY);
        
        
        if (arrayList.contains("LEFT")){
            Renderer.rotateCameraA(-cameraSensitivity);
        } else if (arrayList.contains("RIGHT")){
            Renderer.rotateCameraA(cameraSensitivity);
        }
        
        if (playerNumber == 1) {
            Renderer.setCameraAPos(this.getX()/80+cameraOffset, this.getY()/80+cameraOffset);
        } else if (playerNumber == 2) {
            Renderer.setCameraBPos(this.getX()/80+cameraOffset, this.getY()/80+cameraOffset);
        }
        
    }

    @Override
    public void handleCollision(Collidable collidable) {
        if(collidable instanceof Tile && ((Tile)collidable).getWall()){
        	
        	Tile tile = (Tile) collidable;

            if(tile.getX() < super.getX() & super.getY() + 40 > tile.getY() & super.getY() < tile.getY()+80){
                super.setX(super.getX() - deltaX);
            }
            else if(tile.getX()> super.getX() & super.getY() + 40 > tile.getY()  & super.getY() < tile.getY()+80){
                super.setX(super.getX() - deltaX);
            }

            if(tile.getY() < super.getY() & super.getX() + 40 > tile.getX()& super.getX() < tile.getX()+80){
                super.setY(super.getY() - deltaY);
            }
            else if(tile.getY() > super.getY() & super.getX() + 40 > tile.getX()& super.getX() < tile.getX()+80){
                super.setY(super.getY() - deltaY);
            }
        	
            //super.setY(super.getY() - deltaY);
            //super.setX(super.getX() - deltaX);
            
            if (playerNumber == 1) {
                Renderer.setCameraAPos(this.getX()/80+cameraOffset, this.getY()/80+cameraOffset);
            } else if (playerNumber == 2) {
                Renderer.setCameraBPos(this.getX()/80+cameraOffset, this.getY()/80+cameraOffset);
            }
        }
        

        if (collidable instanceof Tile_goal) {
    		// Win!
    		System.out.println("SUCCESS!");
    	}
    }
    
    private void shoot() {   
        double directionX = Math.cos(Renderer.getCameraARotation()/180*Math.PI);
        double directionY = Math.sin(Renderer.getCameraARotation()/180*Math.PI);     
    	boolean hit = RaycastUtil.shoot(Renderer.getCameraAPosX(), Renderer.getCameraAPosY(), directionX, directionY);
    	
    	if (hit) {
    		System.out.println("HIT!");
    	}
    }

    public double getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }
}
