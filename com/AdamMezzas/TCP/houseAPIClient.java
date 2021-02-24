package com.AdamMezzas.TCP;

import java.util.Observable;

public class houseAPIClient implements InterfaceAPI {
	private boolean Tour;
	private int NbrGagne;
	private int NbrPartie;
	private boolean FinPartie;
	private String Result;
	
	public houseAPIClient() {
		super();
	}

	
    @Override
    public void update(Observable o, Object data) {
       	String reponse = (String) data;
    	System.out.println(reponse);
        String split[] = reponse.split(",");
        
        
        if(split[0].equals("Login")) {
        	NbrGagne = Integer.valueOf(split[1]);
        	NbrPartie = Integer.valueOf(split[2]);
        }
    	
        if(split[0].equals("Tour")) {
        	this.Tour = Boolean.valueOf(split[1]);
        }
        
        if(split[0].equals("Gagnant")) {
        	this.FinPartie = Boolean.valueOf(split[1]);
        }
        
        if(split[0].equals("Result")) {
        	this.Result = split[1];
        }
    }


	public boolean isTour() 		{		return Tour;			}
	public int getNbrGagne() 		{		return NbrGagne;		}
	public int getNbrPerdu() 		{		return NbrPartie;		}
	public boolean isFinPartie() 	{		return FinPartie;		}
	public int getX() 				{ 		return 0;				}
	public String isResult() 		{		return Result;			}
	public int getY()				{		return 0;				}
	public void setX(int x)			{								}	
	public void setY(int y)			{								}
	@Override
	public String toString() {
		return "houseAPIClient [Tour=" + Tour + ", NbrGagne=" + NbrGagne + ", NbrPerdu=" + NbrPartie + ", FinPartie="
				+ FinPartie + "]";
	}


	
}
 