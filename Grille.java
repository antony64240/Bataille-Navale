package com.AdamMezzas.WarShip;
public class Grille{

	private static int[][] GrilleGame;

	
	
	public Grille(int x, int y){
		GrilleGame = new int[x][y];

	}

	

	public int getTab(int x, int y)               		{return GrilleGame[x][y];        }
	public void setTab(int x, int y, int value)         {GrilleGame[x][y] = value   ;     }
	public int getSize()                                {return GrilleGame.length; 		}
	
	public void showTab(){ 
		for(int i=0; i < this.getSize()  ; i++) {
			System.out.println("");
				for(int j=0; j < this.getSize()  ; j++) {
					
					System.out.print("|" + this.getTab(i, j) + "|");		
					
				}
				
		}

	}
	
	
	public static void setTabto0(){ 
		for(int i=0; i < GrilleGame.length  ; i++) {	
				for(int j=0; j < GrilleGame.length  ; j++) {
					GrilleGame[i][j]=0;				
				}
		}
	}
	
	
	public void toucher(int x, int y) {
	
		if(this.getTab(x, y)==0) {
			this.setTab(x, y, -6);
		}else {
			this.setTab(x, y, this.getTab(x, y)+10);
		}
	}
	
	
	
	

	
}

