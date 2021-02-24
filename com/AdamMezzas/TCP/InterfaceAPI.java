package com.AdamMezzas.TCP;

import java.util.Observable;
import java.util.Observer;
 
public interface InterfaceAPI extends Observer {
    public void update(Observable o, Object data);
	public boolean isTour(); 	
	public int getNbrGagne(); 		
	public int getNbrPerdu(); 		
	public boolean isFinPartie(); 	
	public int getX();
	public String isResult();
	public int getY();
	public void setX(int x);		
	public void setY(int y);
}
 

