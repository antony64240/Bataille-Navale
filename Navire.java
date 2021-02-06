import java.util.Vector;



/*
 * Classe representant un sous-marin (constitue de parties ou "ShipPart")
 * d'un joueur.
 */
public class Navire{
	private Vector<NavirePart> parts;
	private boolean estPret;
	private int nbrCase;

	public Navire(int c) {
		parts = new Vector<NavirePart>();
		estPret = false;
		nbrCase = c;
	}
	
	public void addPart(int x, int y, int value)    {parts.add(new NavirePart(x,y,value));}
	public Vector<NavirePart> getParts()   {return parts;                }
	public void setTaille(int x)         {nbrCase = x;     			   }
	public boolean estPret()             {return estPret;              }
	public void estPret(boolean b)       {estPret = b;                 }
	public int getTaille()               {return nbrCase;			   }
	

	
}