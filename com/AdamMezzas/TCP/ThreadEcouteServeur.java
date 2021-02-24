package com.AdamMezzas.TCP;

import com.AdamMezzas.Interfaces.Client;

import AdamMezzas.Connection.SocketClient;

public class ThreadEcouteServeur extends Thread {
	
	Worker worker;
	SocketClient Client;
	
	
	
	public ThreadEcouteServeur(InterfaceAPI screenOut, SocketClient client) {
		worker = new Worker();
		worker.addObserver(screenOut);
		this.Client = client;
	}

	public void run() {
		while(!isInterrupted()) {
			worker.work(Client);
		}
	}

	
	
	
	
}
