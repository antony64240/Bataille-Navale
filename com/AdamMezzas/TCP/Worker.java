package com.AdamMezzas.TCP;
import java.util.Observable;

import com.AdamMezzas.Interfaces.Client;

import AdamMezzas.Connection.SocketClient;
 
public class Worker extends Observable {
	
	//Worker côté Serveur
    public void work(SocketClient client) {
        
		String message = client.Receive();
        setChanged();
        notifyObservers(message);
        
    }
    
    
    //Worker côté client
    public void work(Client client) {
    	
		
    	String message = client.Receive();
        setChanged();
        notifyObservers(message);
        
        
    }	
}