package AdamMezzas.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.AdamMezzas.ORM.DriveIO;
import com.AdamMezzas.ORM.User;
import com.AdamMezzas.WarShip.CaseNavire;
import com.AdamMezzas.WarShip.Contre_Torpilleur;
import com.AdamMezzas.WarShip.Croiseur;
import com.AdamMezzas.WarShip.Navire;
import com.AdamMezzas.WarShip.Porte_Avion;
import com.AdamMezzas.WarShip.Sous_Marin;
import com.AdamMezzas.WarShip.Torpilleur;

public class ThreadClient extends Thread {

	@SuppressWarnings("unused")
	private Serveur serveur;
	private SocketClient SocketJoueur;
	private int numeroJoueur;
	private Vector<Navire> navire;
	private User Joueur;
	private DriveIO drive;

	
	public ThreadClient(SocketClient socketJoueur, int nbclients, Serveur server) {
		this.SocketJoueur=socketJoueur;
		this.numeroJoueur=nbclients;
		this.Joueur = new User();
		this.drive = new DriveIO();
		this.navire = new Vector<Navire>();
		this.serveur = server;
	}
	
	public SocketClient getSocketJoueur() 	{		return SocketJoueur;	}
	public Vector<Navire> getNavire() 		{		return navire;			}
	
	
	public void run() {
		String Nomjoueur = SocketJoueur.Receive();
		try {
			Joueur = drive.CheckUser(Nomjoueur);
			SocketJoueur.setUsername(Nomjoueur);
			SocketJoueur.send(String.valueOf(Joueur.getNbrgagner())+","+String.valueOf(Joueur.getNbrpartie()));
			String Ship = SocketJoueur.Receive();
			this.navire= drive.readJson(Ship);
			Vector<ThreadClient> Partie = this.checkPartie();
			if(Partie == null) {
				Serveur.GetEnsemblePartie().add((new Partie(this)));
				Serveur.GetEnsemblePartie().get(Serveur.GetEnsemblePartie().size()-1).start();
				SocketJoueur.send("Partie crée, vous êtes l'hôtes !");
				
			}else {
				Partie.add(this);
				SocketJoueur.send("Partie trouvée !");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return "ThreadClient [SocketJoueur=" + SocketJoueur + ", numeroJoueur=" + numeroJoueur + ", navire=" + navire
				+ ", Joueur=" + Joueur.getUsername() + ", drive=" + drive +"]";
	}

	public Vector<ThreadClient> checkPartie() {
		if(Serveur.GetEnsemblePartie().size()==0) {
			return null;
		}
		for (Partie game :Serveur.GetEnsemblePartie()) {
			if(game.getPartie().size()<2) {
				return game.getPartie();
			}
		}
		return null;
	}



	


	

	
	
	

	
	

}
