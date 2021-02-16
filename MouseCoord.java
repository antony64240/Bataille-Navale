package com.AdamMezzas.WarShip;

public class MouseCoord {
	
	private int x;
	private int y;
	
		
	
	public MouseCoord(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void setMouseCoord(int x, int y) {this.x = x;this.y = y;}
	public int getMouseCoordX() {return this.x;}
	public int getMouseCoordY() {return this.y;}

	@Override
	public String toString() {
		return "MouseCoord [x=" + x + ", y=" + y + "]";
	}



	

}
