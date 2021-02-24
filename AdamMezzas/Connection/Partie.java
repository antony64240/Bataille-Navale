package AdamMezzas.Connection;

import java.util.Vector;

import com.AdamMezzas.TCP.*;
import com.AdamMezzas.ORM.DriveIO;
import com.AdamMezzas.WarShip.Navire;

public class Partie extends Thread {

	private Vector<ThreadClient> Partie;
	private SocketClient ecouteJ1;
	private SocketClient ecouteJ2;
	private Vector<Navire> NavireJ1;
	private Vector<Navire> NavireJ2;
	private DriveIO drive;

	
	public Partie(ThreadClient client) {
		this.Partie= new Vector<ThreadClient>();
		this.Partie.add(client);
		this.drive = new DriveIO();
		this.ecouteJ1 = client.getSocketJoueur();
		this.NavireJ1 = client.getNavire();
	}


	public Vector<ThreadClient> getPartie() 			{	return Partie;					}
	public int GetNbrJoueur() 							{ 	return this.Partie.size(); 		}
	public void setPartie(Vector<ThreadClient> partie) 	{	Partie = partie;				}	
	
	public void AddJoueur(ThreadClient client) {
		this.Partie.add(client);
		this.ecouteJ2 = client.getSocketJoueur();
		this.NavireJ2 = client.getNavire();
	}
	
	
	
	public void run() {
		while(true) {
			while(this.getPartie().size()<2) {
				
			}
			InterfaceAPI ApiPlayer1 = new houseAPIServeur();
			InterfaceAPI ApiPlayer2 = new houseAPIServeur();
			ThreadEcouteServeur te = new ThreadEcouteServeur(ApiPlayer1,ecouteJ1);
			ThreadEcouteServeur tee = new ThreadEcouteServeur(ApiPlayer2,Partie.get(1).getSocketJoueur());
	        
			te.start();
			tee.start();
			
			ecouteJ1=Partie.get(0).getSocketJoueur();
			ecouteJ2=Partie.get(1).getSocketJoueur();
			NavireJ1=Partie.get(0).getNavire();
			NavireJ2=Partie.get(1).getNavire();
	
			
			new GestionPartie(ApiPlayer1,ApiPlayer2,ecouteJ1,ecouteJ2,NavireJ1,NavireJ2,this).Start();	
			
			if(ecouteJ1.getSocket().isClosed() || ecouteJ2.getSocket().isClosed()) {
				this.interrupt();
			}
		}
 
//			syncJ1.addObserver(syncJ1.getMessage());
//			syncJ2.getMessage();
		
//		for(ThreadClient e : Partie) {
//			e.getSocketJoueur().send("En Recherche d'un Joueur");			
//		}	
//		
//		while(Partie.size()<2) {
//
//		}
//		for(ThreadClient e : Partie) {
//			e.getSocketJoueur().send("Start");
//		}
//		
//		if(Math.random()>0.5) {
//			ecouteJ1=Partie.get(0).getSocketJoueur();
//			ecouteJ2=Partie.get(1).getSocketJoueur();
//			NavireJ1=Partie.get(0).getNavire();
//			NavireJ2=Partie.get(1).getNavire();
//		}else {
//			ecouteJ1=Partie.get(1).getSocketJoueur();
//			ecouteJ2=Partie.get(0).getSocketJoueur();
//			NavireJ1=Partie.get(1).getNavire();
//			NavireJ2=Partie.get(0).getNavire();
//		}
//		
//		SocketClient Gagnant = new GestionPartie(ecouteJ1,ecouteJ2,NavireJ1,NavireJ2).Start();
//		
//		if(Gagnant == ecouteJ1) {
//			drive.updateUser(1, ecouteJ1.getUsername());
//			drive.updateUser(0, ecouteJ2.getUsername());
//		}else {
//			drive.updateUser(0, ecouteJ1.getUsername());
//			drive.updateUser(1, ecouteJ2.getUsername());
//		}
		
		
	}
	
	
	

}
