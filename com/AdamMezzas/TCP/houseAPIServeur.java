package com.AdamMezzas.TCP;


import java.util.Observable;

public class houseAPIServeur implements InterfaceAPI {
	private int shootX;
	private int shootY;
	public houseAPIServeur() {
		super();
		this.shootX=-1;
		this.shootY=-1;
	}
	
	
	
    @Override
    public void update(Observable o, Object data) {	
    	String reponse = (String) data;
    	System.out.println(reponse);
        String split[] = reponse.split(",");
        
        if(split[0].equals("Tir")) {
        	this.shootX=Integer.valueOf(split[1]);
        	this.shootY=Integer.valueOf(split[2]);
        }
    }
    public int getX() 				{	return this.shootX;	}
    public int getY()				{	return this.shootY;	}
    public void setX(int x)			{	this.shootX=x;		}
    public void setY(int y)			{	this.shootY=y;		}
	public boolean isTour() 		{	return false;		} 	
	public int getNbrGagne() 		{	return 0;			} 		
	public int getNbrPerdu() 		{	return 0;			}	 		
	public boolean isFinPartie() 	{	return false;		}
	public String getMessage() 		{ 	return null;		}
	public String isResult() 		{	return "";			}
}
 