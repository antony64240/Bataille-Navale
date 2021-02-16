package com.AdamMezzas.WarShip;

import java.util.Vector;

public class Croiseur extends Navire{
	
	private Vector<CaseNavire> parts;
	private int taille;
	
	public Croiseur(int x, int y, boolean Vertical) {
		super(x, y);
		parts = new Vector<CaseNavire>();
		System.out.println(Vertical);
		if(!Vertical) {
			parts.add(new CaseNavire(x,y,2));
			parts.add(new CaseNavire(x+1,y,2));
			parts.add(new CaseNavire(x+2,y,2));
			parts.add(new CaseNavire(x+3,y,2));
		}else {
			parts.add(new CaseNavire(x,y,2));
			parts.add(new CaseNavire(x,y+1,2));
			parts.add(new CaseNavire(x,y+2,2));
			parts.add(new CaseNavire(x,y+3,2));
		}
		this.taille=4;
	}
	public String toString() {
		return "Croiseur [parts=" + parts.toString() + "]";
	}
	public Vector<CaseNavire> getParts()   {return this.parts;                }
	public int getTaille()  			   {return this.taille;          }



}
