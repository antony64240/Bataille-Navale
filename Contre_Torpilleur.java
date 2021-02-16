package com.AdamMezzas.WarShip;

import java.util.Vector;

public class Contre_Torpilleur extends Navire {

	private Vector<CaseNavire> parts;
	private int Taille;
	
	public Contre_Torpilleur(int x, int y, boolean Vertical) {
		super(x, y);
		parts = new Vector<CaseNavire>();
		if(!Vertical) {
			parts.add(new CaseNavire(x,y,1));
			parts.add(new CaseNavire(x+1,y,1));	
		}else {
			parts.add(new CaseNavire(x,y,1));
			parts.add(new CaseNavire(x,y+1,1));
		}
		this.Taille= 2;
	}
	

	public String toString() {
		return "Contre_Torpilleur [parts=" + parts.toString() + "]";
	}

	public Vector<CaseNavire> getParts()   {return parts;                }
	public int getTaille() { return Taille;}
}
