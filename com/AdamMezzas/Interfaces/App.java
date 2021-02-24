package com.AdamMezzas.Interfaces;
import com.AdamMezzas.Interfaces.Client;
import com.AdamMezzas.Interfaces.InterfaceClient;
import com.AdamMezzas.Interfaces.InterfaceConnection;
import com.AdamMezzas.Interfaces.InterfaceJeu;
import com.AdamMezzas.TCP.InterfaceAPI;
import com.AdamMezzas.TCP.ThreadEcouteClient;
import com.AdamMezzas.TCP.houseAPIClient;

public class App {

	private static Client client;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		
			client = new Client();
	        client.startConnection("localhost", 6666);
	        InterfaceAPI screen = new houseAPIClient();
	        
	        ThreadEcouteClient td = new ThreadEcouteClient(screen,client);
			td.start();
	          
	        InterfaceJeu interfaceJeu = new InterfaceJeu(client,screen);
	        interfaceJeu.setVisible(false);
	        
	        InterfaceClient Interfaceclient= new InterfaceClient(client,interfaceJeu);
	        Interfaceclient.setVisible(false);
	        
	        InterfaceConnection interfaceConnexion = new InterfaceConnection(client,Interfaceclient,screen);
	        interfaceConnexion.setVisible(true);

//	        InterfaceJeu interfaceJeu = new InterfaceJeu();
//	        interfaceJeu.setVisible(false);
	        
	        
//			if(!interfaceConnexion.isVisible()) {
//				InterfaceClient.setVisible(true);
//			}
			
			
	}
}
