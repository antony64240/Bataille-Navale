package com.AdamMezzas.WarShip;

import java.util.Vector;

public class Torpilleur extends Navire{

private Vector<CaseNavire> parts;
private int Taille;
	
	public Torpilleur(int x, int y, boolean Vertical) {
		super(x, y);
		parts = new Vector<CaseNavire>();
		if(!Vertical) {
			parts.add(new CaseNavire(x,y,3));
			parts.add(new CaseNavire(x+1,y,3));
			parts.add(new CaseNavire(x+2,y,3));
		}else {
			parts.add(new CaseNavire(x,y,3));
			parts.add(new CaseNavire(x,y+1,3));
			parts.add(new CaseNavire(x,y+2,3));
		}
		this.Taille= 3;
	}

	public String toString() {
		return "Torpilleur [parts=" + parts.toString() + "]";
	}

	public Vector<CaseNavire> getParts()   {return parts;                }
	public int getTaille() 				   {return this.Taille;			 }
}
