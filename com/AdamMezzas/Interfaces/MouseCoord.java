package com.AdamMezzas.Interfaces;

public class MouseCoord {
	
	private int x;
	private int y;
	
		
	
	public MouseCoord(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public MouseCoord() {
		
	}
	
	public void setMouseCoord(int x, int y) {this.x = (x/36);this.y = (y/16);}
	public int getMouseCoordX() {return this.x;}
	public int getMouseCoordY() {return this.y;}

	@Override
	public String toString() {
		return "MouseCoord [x=" + x + ", y=" + y + "]";
	}



	

}
