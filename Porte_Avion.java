package com.AdamMezzas.WarShip;

import java.util.Vector;

public class Porte_Avion extends Navire {

private Vector<CaseNavire> parts;
private int taille;
	
	public Porte_Avion(int x, int y, boolean Vertical) {
		super(x, y);
		parts = new Vector<CaseNavire>();
		System.out.println(Vertical);
		if(Vertical==true) {
			this.parts.add(new CaseNavire(x,y,5));
			this.parts.add(new CaseNavire(x,y+1,5));
			this.parts.add(new CaseNavire(x,y+2,5));
			this.parts.add(new CaseNavire(x,y+3,5));
			this.parts.add(new CaseNavire(x,y+4,5));
			
		}else {
			this.parts.add(new CaseNavire(x,y,5));
			this.parts.add(new CaseNavire(x+1,y,5));
			this.parts.add(new CaseNavire(x+2,y,5));
			this.parts.add(new CaseNavire(x+3,y,5));
			this.parts.add(new CaseNavire(x+4,y,5));
		}
		this.taille = 5;
	}

	@Override
	public String toString() {
		return "Porte_Avion [parts=" + parts.toString() + "]";
	}
	
	public Vector<CaseNavire> getParts()   {return parts;                }
	public int getTaille()  			   {return this.taille;          }

}
