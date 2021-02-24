package com.AdamMezzas.Interfaces;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;
    private DataInputStream inn;

 
    
    public void startConnection(String ip, int port) {
        try {
		clientSocket = new Socket(ip, port);
		System.out.println("Connecté au port " + port);
		inn = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());   
        } catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public void send(String message) {
		try {
			out.writeUTF(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String Receive() {
		try {
			String reponse;
			reponse = inn.readUTF();
			return reponse;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				clientSocket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return "Erreur lors de la reception du message";
	}
	 
	public  Socket getSocket() {
	    	return this.clientSocket;
	}

    public void stopConnection() throws IOException {
        inn.close();
        out.close();
        clientSocket.close();
    }
       
    
    
}