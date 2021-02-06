public class Grille{

	private static int[][] GrilleGame;
	private static int maxCol;
	private int maxLig;
	
	
	public Grille(int x, int y){
		GrilleGame = new int[x][y];
		maxCol = x;
		maxLig = y;
	}

	

	public int getTab(int x, int y)               		{return GrilleGame[x][y];        }
	public void setTab(int x, int y, int value)         {GrilleGame[x][y] = value   ;     }
	
	
	public void showTab(){ 
		for(int i=0; i < maxCol ; i++) {
			System.out.println("");
				for(int j=0; j < maxCol ; j++) {
					
					System.out.print("|" + GrilleGame[i][j] + "|");		
					
				}
				
		}

	}
	
	
	public static void setTabto0(){ 
		for(int i=0; i < maxCol ; i++) {	
				for(int j=0; j < maxCol ; j++) {
					GrilleGame[i][j]=0;				
				}
		}
	}
	
	public static void setTabto1(int x, int y, int nbr){ 
		for(int i=0; i < nbr ; i++) {	
				GrilleGame[x][y]=1;
				y++;
		}
	}
	
	
	public int PositionnerShip(int x, int y, int codeCase, int nbrCaseShip, boolean Alignement)  {
		int SetErrorMessage = 0;
		boolean succes = true;
		int incrementLigne, incrementColonne;
		if(Alignement) {
			incrementColonne=0;
			incrementLigne = 1;
			}else {
			incrementLigne=0;
			incrementColonne=1;
		}
		
		for(int i =0; i<nbrCaseShip;i++) {
			if(GrilleGame[x+i*incrementLigne][y+i*incrementColonne]==8 || GrilleGame[x+i*incrementLigne][y+i*incrementColonne]!=0) {
				succes=false;
				return (SetErrorMessage=8);
			}
		}
		
		
		
		if((succes)&&(!Alignement)) {
			for(int i=0; i<nbrCaseShip+2;i++) {
				GrilleGame[(x+i*incrementLigne)][(y+i-1)*incrementColonne]=8; 	//ok	
			}
		}
		
		if((succes)&&(Alignement)) {
			for(int i=0; i<nbrCaseShip+2;i++) {
				GrilleGame[(x+i-1)*incrementLigne][y+i*incrementColonne]=8; 		//ok
			}
		}
		
		
		if(succes) {
			for(int i=0; i<nbrCaseShip;i++) {
				GrilleGame[x+i*incrementLigne][y+i*incrementColonne]=codeCase; 		//ok
			}
		}
			
		if((succes)&&(!Alignement)) {
			for(int i=0; i<nbrCaseShip+2;i++) {
				GrilleGame[(x+i*incrementLigne)+1][(y+i-1)*incrementColonne]=8; 		//ok
			}
		}
		
			
			if((succes)&&(Alignement)) {
				for(int i=0; i<nbrCaseShip+2;i++) {
					GrilleGame[(x+i-1)*incrementLigne][y+1]=8; 		//ok
				}
			}
			
			
		if((succes)&&(Alignement)) {
			for(int i=0; i<nbrCaseShip+2;i++) {
				GrilleGame[(x+i-1)*incrementLigne][y-1]=8;  //ok
			}
		}
		
		if((succes)&&(!Alignement)) {
			for(int i=0; i<nbrCaseShip+2;i++) {
				GrilleGame[(x+i*incrementLigne)-1][(y+i-1)*incrementColonne]=8;  //ok
			}
		}
		
		
		
	
		return (SetErrorMessage);
	}
}

