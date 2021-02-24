package AdamMezzas.Connection;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;


public class SocketClient {
	
	private Socket socket;
	private DataOutputStream out;
    private DataInputStream in;
    private String Username;
    
	@SuppressWarnings("deprecation")
	public String ExchangeServer(String message) {
		try {
			out.writeUTF(message);
			String reponse = in.readLine();
			return reponse;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erreur dans la lecture de la réponse du Client";
	}
	
	public SocketClient(Socket socket) throws IOException {
		super();
		this.socket = socket;
		this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		this.out = new DataOutputStream(socket.getOutputStream());
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
			reponse = in.readUTF();
			return reponse;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return "Erreur lors de la reception du message";
	}

	public DataOutputStream getOut() 					{	return out;					}
	public void setOut(DataOutputStream out) 			{	this.out = out;				}
	public DataInputStream getIn() 						{	return in;					}
	public void setIn(DataInputStream dataInputStream)  {	this.in = dataInputStream;	}
	public Socket getSocket() 							{	return socket;				}	
	public void setSocket(Socket socket) 				{	this.socket = socket;		}
	public String getUsername()							{	return this.Username;		}
	public void setUsername(String username) 			{   this.Username=username;		}

}
