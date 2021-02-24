package com.AdamMezzas.ORM;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public abstract class AbstractDB {
	
	private String urlJdbc;
	private static Connection connection = null;
	
	public AbstractDB(String urlJdbc) {
		this.urlJdbc=urlJdbc;
	}
	
	public Connection getConnexion() throws ClassNotFoundException
	{

		if(connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(urlJdbc);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	
	public abstract boolean UpdatePartie(int Entier, String Username) throws ClassNotFoundException;
	public abstract boolean pushUsers(User user) throws ClassNotFoundException;
	public abstract boolean deletUser(User user) throws ClassNotFoundException;
	public abstract List<User> getUser(String email) throws ClassNotFoundException;
	public abstract boolean RestartSeq() throws ClassNotFoundException;
	public abstract List<User> getallUsers() throws ClassNotFoundException;
	
}

