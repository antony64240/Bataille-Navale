package com.AdamMezzas.TCP;

import com.AdamMezzas.Interfaces.Client;

import AdamMezzas.Connection.SocketClient;

public class ThreadEcouteClient extends Thread {
	
	private Worker worker;
	private Client client;
	
	
	public ThreadEcouteClient(InterfaceAPI screenOut, Client client) {
		worker = new Worker();
		worker.addObserver(screenOut);
		this.client = client;
		
	}
	
	
	public void run() {
		
		
		
		while(!isInterrupted()) {
			worker.work(client);
		}
	}

	
	
	
	
}
