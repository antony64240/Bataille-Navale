package com.AdamMezzas.ORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



public class PgDB extends AbstractDB {
	
	
	public PgDB(String host, String port, String dbname, String username, String password){
		super("jdbc:postgresql://"+host+":"+port+"/"+dbname+"?user="+username+"&password="+password);
	}
		// TODO Auto-generated constructor stub

	@Override
	public List<User> getallUsers() throws ClassNotFoundException {
		Connection connection = getConnexion();
		Statement statement;
		ResultSet resultSet=null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from usernavale");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		Mapper<User> mapper=new Mapper<User>(User.class.getName());
		return mapper.get(resultSet); 
	}
	
	
	@Override
	public List<User> getUser(String username) throws ClassNotFoundException{
		Connection connection = getConnexion();
		Statement statement;
		ResultSet resultSet=null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from usernavale WHERE username = '"+username+"'");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		Mapper<User> mapper=new Mapper<User>(User.class.getName());
		return mapper.get(resultSet); 
	}
	
	public boolean pushUsers(User user) throws ClassNotFoundException {
		Connection connection = getConnexion();
		String sql = "insert into usernavale(username,nbrpartie,nbrgagner) "+"values(?,?,?)";
		int resultSet = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setInt(2,user.getNbrpartie());
			ps.setInt(3,user.getNbrgagner());
			resultSet = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();	
		}
		return Boolean.valueOf(String.valueOf(resultSet));
	}
	
	public boolean deletUser(User user) throws ClassNotFoundException {
		Connection connection = getConnexion();
		String sql = "DELETE FROM usernavale WHERE email = ?";
		int resultSet = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			resultSet = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return Boolean.valueOf(String.valueOf(resultSet));	
	}
	
	public boolean UpdatePartie(int Entier, String Username) throws ClassNotFoundException {
		String sql = "update UserNavale set nbrpartie=nbrpartie+1, nbrgagner=nbrgagner+? where username = ?";
		PreparedStatement ps = null;
		Connection connection = getConnexion();
		int resultSet=0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1,Entier);
			ps.setString(2,Username);
			System.out.println(ps.toString());
			resultSet = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return Boolean.valueOf(String.valueOf(resultSet));	
	}
	
	public boolean RestartSeq() throws ClassNotFoundException {
		Connection connection = getConnexion();
		Statement statement;
		int resultSet=0;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeUpdate("ALTER SEQUENCE usernavale_id_seq"+ "RESTART WITH 1;");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return Boolean.valueOf(String.valueOf(resultSet));	
	}

}