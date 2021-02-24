package AdamMezzas.Connection;

import java.util.Vector;

import com.AdamMezzas.TCP.InterfaceAPI;
import com.AdamMezzas.WarShip.CaseNavire;
import com.AdamMezzas.WarShip.Navire;

public class GestionPartie {
	private boolean FinDePartie;
	private SocketClient Joueur1;
	private SocketClient Joueur2;
	private Vector<Navire> NavireJ1;
	private Vector<Navire> NavireJ2;
	private SocketClient Winner ;
	private InterfaceAPI APIJ1;
	private InterfaceAPI APIJ2;
	private Partie partie;
	
	public GestionPartie(InterfaceAPI Apij1,InterfaceAPI Apij2, SocketClient Joueur1, SocketClient Joueur2, Vector<Navire> NavireJ1,Vector<Navire>  NavireJ2, Partie partie) {		
		this.Joueur1 = Joueur1;
		this.Joueur2 = Joueur2;
		this.NavireJ1 = NavireJ1;
		this.NavireJ2 = NavireJ2;
		this.APIJ1=Apij1;
		this.APIJ2=Apij2;
		FinDePartie = false;
		this.partie = partie;
	}
	
	public boolean isFinDePartie() 					{	return FinDePartie;				}
	public void setFinDePartie(boolean finDePartie) {	FinDePartie = finDePartie;		}
	
	public boolean impact(int x, int y, Vector<Navire> navire) {		
		for( Navire e : navire) {
			for (CaseNavire part : e.getParts()) {
				if((part.getX()==x)&&(part.getY()==y)){
					part.estDetruit(true);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkFinPartie(Vector<Navire> navire) {
		if(!this.FinDePartie) {
		for( Navire e : navire) {
			for (CaseNavire part : e.getParts()) {
				if(!part.estDetruit()) {
					return false;
				}
			}
		}
		this.FinDePartie = true;
		}
		return true;
	}
	
	

	
	public void Start() {
		boolean Result = false; 
		boolean FinPartie = false;
		while(!Joueur1.getSocket().isClosed() || !Joueur2.getSocket().isClosed()) {
		
			Joueur1.send("Tour"+","+true);
			Joueur2.send("Tour"+","+false);
			while(APIJ1.getX()==-1) {
				System.out.println("X : " +APIJ1.getX());
				System.out.println("Y ; " +APIJ1.getY());
				System.out.println("X2 : " +APIJ2.getX());
				System.out.println("Y2 ; " +APIJ2.getY());
			}
			Result = impact(APIJ1.getX(),APIJ1.getY(),NavireJ2);
			APIJ1.setX(-1);
			APIJ1.setY(-1);
			Joueur1.send("Tour"+","+false);
			Joueur2.send("Tour"+","+true);
			if(Result) {
				Joueur1.send("Result"+","+"Bateau touché !");
		    	Joueur2.send("Result"+","+"Votre adversaire à touché ! ");
			}else {
				Joueur1.send("Result"+","+"Manqué !");
		    	Joueur2.send("Result"+","+"Votre adversaire à manqué ça cible ! ");
			}
	
			while(APIJ2.getX()==-1) {
				System.out.println("X : " +APIJ1.getX());
				System.out.println("Y ; " +APIJ1.getY());
				System.out.println("X2 : " +APIJ2.getX());
				System.out.println("Y2 ; " +APIJ2.getY());
			}
			Result = impact(APIJ2.getX(),APIJ2.getY(),NavireJ1);
			APIJ2.setX(-1);
			APIJ2.setY(-1);
			if(Result) {
				Joueur2.send("Result"+","+"Bateau touché !");
		    	Joueur1.send("Result"+","+"Votre adversaire à touché ! ");
			}else {
				Joueur2.send("Result"+","+"Manqué !");
		    	Joueur1.send("Result"+","+"Votre adversaire à manqué ça cible ! ");
			}
		}
		
		
		
		
		
		
//		while(!FinDePartie){
//			
//			Joueur1.send("A vous de jouer");
//			Joueur2.send("En Attente de tir du joueur2");
//			X = Integer.parseInt(Joueur1.Receive());
//			Y = Integer.parseInt(Joueur1.Receive());
//			System.out.println(X+Y);
//			Result = impact(X,Y,NavireJ2);
//			FinPartie = checkFinPartie(NavireJ2);
//			Joueur1.send(Boolean.toString(Result));
//			Joueur2.send(Boolean.toString(Result));
//			if(FinPartie) {
//				this.Winner=Joueur1;
//				break;
//			}
//			
//			
//			Joueur2.send("A vous de jouer");
//			Joueur1.send("En Attente de tir du joueur1");
//			X = Integer.parseInt(Joueur2.Receive());
//			Y = Integer.parseInt(Joueur2.Receive());
//			System.out.println(X+Y);
//			Result = impact(X,Y,NavireJ1);
//			FinPartie = checkFinPartie(NavireJ1);
//			Joueur2.send(Boolean.toString(Result));
//			Joueur1.send(Boolean.toString(Result));
//			if(FinPartie) {
//				this.Winner=Joueur2;
//				break;
//			}	
//		}
		
		
		
		
	}
	
}
