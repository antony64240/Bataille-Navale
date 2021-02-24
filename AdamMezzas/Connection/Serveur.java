package AdamMezzas.Connection;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.Vector;




public class Serveur extends Thread{

	
	private static EnsemblePartie EnsembleDesPartie;
	private Vector<ThreadClient> Client;
    private ServerSocket server;
    private int nbclients = 0;
    private int port;
    
    
    public Serveur(int p) {
		port = p;
		EnsembleDesPartie = new EnsemblePartie();
		Client = new Vector<ThreadClient>();
		try{
			server = new ServerSocket(port, 32);
		}
		catch(IOException e){
			System.out.println("[SERVEUR] ERREUR : IO Serveur");
			e.printStackTrace();
			System.exit(1);
		}
	}
    


    public void stopConnection() {
        try {
        	server.close();
        
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public ServerSocket getServerSocket() 				{		return server;			}
    public int GetNbrJoueur() 							{		return this.nbclients;  }
    public static EnsemblePartie GetEnsemblePartie() 	{	return EnsembleDesPartie;	}
    public static void SetEnsemblePartie(EnsemblePartie ensembleServeur) { EnsembleDesPartie = ensembleServeur;	}
	
	public void run() {
				
			while(true){
				System.out.println("[SERVEUR] En attente d'un client.");
				try {
					SocketClient client = new SocketClient(server.accept());
					nbclients+=1;
					System.out.println("[SERVEUR] Client "+nbclients+" accepte.");
					ThreadClient tc = new ThreadClient(client, this.nbclients, this);
					tc.start();
					Client.add(tc);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		
	}
	
	
	

	

}