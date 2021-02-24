package com.AdamMezzas.ORM;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.AdamMezzas.WarShip.CaseNavire;
import com.AdamMezzas.WarShip.Contre_Torpilleur;
import com.AdamMezzas.WarShip.Croiseur;
import com.AdamMezzas.WarShip.Navire;
import com.AdamMezzas.WarShip.Porte_Avion;
import com.AdamMezzas.WarShip.Sous_Marin;
import com.AdamMezzas.WarShip.Torpilleur;



public class DriveIO {

	private AbstractDB pgdb;
	
	public DriveIO() {
		this.pgdb = new PgDB("localhost","5432","postgres","postgres","root");

	}

	public boolean createuser(User user) throws ClassNotFoundException {
		AbstractDB pgdb = new PgDB("localhost","5432","postgres","postgres","root");
		boolean result = pgdb.pushUsers(user);
		return result;
	}
	
//	public String changePassword(String email, String newPassword, String oldPassword) throws ClassNotFoundException {	
//		User user = this.login(email, oldPassword);
//		if(user.getMdp().equals(newPassword)) {
//			return "Mot de passe identique à l'ancien";
//		}	
//		if(user == null) {
//			return "Utilisateur introuvable";
//		}
//		else {
//			user.setMdp(newPassword);
//			return  this.pgdb.ResetMdp(user) ? "Mot de passe modifié " : "erreur interne";
//		}		
//	}

	@SuppressWarnings("null")
	public User getUserByUsername(String username) throws ClassNotFoundException {
				List<User> a = pgdb.getUser(username);		
				if (a.isEmpty()) {
					return null;
					
				}else {
					return a.get(0);
				}
	}
	
	public void getUsers() throws ClassNotFoundException {
		List <User> a = pgdb.getallUsers();
		for ( User u : a) {
			System.out.println(u.toString());
		}
	}
	
	public boolean updateUser(int Entier, String username) {
		boolean result = false;
		try {
			 result = pgdb.UpdatePartie(Entier, username);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	
	public User CheckUser(String username) throws ClassNotFoundException {
		List<User> a = pgdb.getUser(username);
		if(a.isEmpty()) {
			User user = new User(username);
			pgdb.pushUsers(user);
			return user;
		}	
		else {
			return a.get(0);		
		}
	}
	
	public Vector<Navire> readJson(String message) throws IOException {
		Vector <Navire> Navires = new Vector<Navire>();
		JSONParser parser = new JSONParser();
		Navire navire = null;
		Object obj;
		try {
			obj = parser.parse(message);
			JSONObject array = (JSONObject) obj;
			int NbrI = Integer.parseInt(array.get("NbrBateau:").toString());
			for(int i=0 ; i< NbrI; i++) {
				boolean Orientation = Boolean.valueOf(String.valueOf(array.get("X:"+String.valueOf(i))));
				int X =  Integer.parseInt(array.get("X:"+String.valueOf(i)).toString());		
				int Y =  Integer.parseInt(array.get("Y:"+String.valueOf(i)).toString());
				String Bateau = String.valueOf(array.get("Bateau:"+i).toString());
				switch(Bateau) {
				case "Porte_Avion" :  navire = new Porte_Avion(X,Y,Orientation);
				break;
				case "Croiseur" :  navire = new Croiseur(X,Y,Orientation);
				break;
				case "Torpilleur" :  navire = new Torpilleur(X,Y,Orientation);
				break;
				case "Sous_Marin" :  navire = new Sous_Marin(X,Y,Orientation);
				break;
				case "Contre_Torpilleur" :  navire = new Contre_Torpilleur(X,Y,Orientation);
				break;
				default :
					System.out.println("Erreur de chargement des bateaux");
				}
				int j = 0;
				for(CaseNavire Cn : navire.getParts()) {
					Cn.estDetruit(Boolean.valueOf(String.valueOf(array.get("VALUE:"+String.valueOf(i)+String.valueOf(j).toString()))));
					j++;
				}
				Navires.add(navire);
			}
			
			return Navires;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(null);
	}
	
	public void DeletAllUsers() throws ClassNotFoundException {
		List <User> a = pgdb.getallUsers();
		if(!a.isEmpty()) {
			for ( User u : a) {
				System.out.println(u.getUsername()+" Supprimé");
				pgdb.deletUser(u);	
			}
			pgdb.RestartSeq();
		}else  {
			System.out.println("Aucun n'utilisateur à supprimer");
		}
	}
}
