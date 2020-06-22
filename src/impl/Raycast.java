package impl;

import javafx.scene.image.Image;

public class Raycast {
	
	private double distance;
	private double distanceX;
	private double distanceY;
	private double startX;
	private double startY;
	private double endX;
	private double endY;
	private double wallPosX;
	private int side;
	private boolean hit = false;
	private Image image;

	public boolean isHit() {
		return hit;
	}
	public void setHit(boolean hit) {
		this.hit = hit;
	}
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getDistanceX() {
		return distanceX;
	}
	public void setDistanceX(double distanceX) {
		this.distanceX = distanceX;
	}
	public double getDistanceY() {
		return distanceY;
	}
	public void setDistanceY(double distanceY) {
		this.distanceY = distanceY;
	}
	public double getStartX() {
		return startX;
	}
	public void setStartX(double startX) {
		this.startX = startX;
	}
	public double getStartY() {
		return startY;
	}
	public void setStartY(double startY) {
		this.startY = startY;
	}
	public double getEndX() {
		return endX;
	}
	public void setEndX(double endX) {
		this.endX = endX;
	}
	public double getEndY() {
		return endY;
	}
	public void setEndY(double endY) {
		this.endY = endY;
	}
	public double getWallPosX() {
		return wallPosX;
	}
	public void setWallPosX(double wallPosX) {
		this.wallPosX = wallPosX;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
}
