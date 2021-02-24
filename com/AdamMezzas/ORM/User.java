package com.AdamMezzas.ORM;

import java.sql.Timestamp;

public class User{
	private int nbrgagner;
	private int nbrpartie;
	private String username;
	private int id;
	private Timestamp creele;
	
	
	public User(String username) {
		super();
		this.nbrgagner = 0;
		this.nbrpartie = 0;
		this.username = username;
	}
	
	public User() {
		super();
	}

	public int getNbrgagner() {
		return nbrgagner;
	}
	public void setNbrgagner(int nbrgagner) {
		this.nbrgagner = nbrgagner;
	}
	public int getNbrpartie() {
		return nbrpartie;
	}
	public void setNbrpartie(int nbrpartie) {
		this.nbrpartie = nbrpartie;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Timestamp getCreele() {
		return creele;
	}
	public void setCreele(Timestamp creele) {
		this.creele = creele;
	}
	@Override
	public String toString() {
		return "User [nbrgagner=" + nbrgagner + ", nbrpartie=" + nbrpartie + ", username=" + username + ", id=" + id
				+ ", creele=" + creele + "]";
	}
	
	
	
}
