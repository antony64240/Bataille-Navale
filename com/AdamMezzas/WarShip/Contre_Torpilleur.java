package com.AdamMezzas.WarShip;

import java.util.Vector;

public class Contre_Torpilleur extends Navire {

	private Vector<CaseNavire> parts;
	private Vector<CaseNavire> AroundNavire;
	private int Taille;
	private boolean Orientation;
	
	
	public Contre_Torpilleur(int x, int y, boolean Vertical) {
		super();
		this.parts = new Vector<CaseNavire>();
		this.AroundNavire = new Vector<CaseNavire>();
		this.Orientation = Vertical;
		if(!Vertical) {
			parts.add(new CaseNavire(x,y,1));
			parts.add(new CaseNavire(x+1,y,1));	
		}else {
			parts.add(new CaseNavire(x,y,1));
			parts.add(new CaseNavire(x,y+1,1));
		}
		this.Taille= 2;
		pushAroundCase();
	}
	
	public Contre_Torpilleur() {
		super();
		parts = new Vector<CaseNavire>();
		this.Taille= 2;
	}
	
	public Vector<CaseNavire> getAroundParts()  {return AroundNavire;   			    }
	public Vector<CaseNavire> getParts()   {return parts;                }
	public int getTaille() { return Taille;}
	public void addPart(int x, int y)      {this.parts.add(new CaseNavire(x,y,1));}
	public boolean getOrientation() { return this.Orientation;}

	
	public String toString() {
		return "Contre_Torpilleur [parts=" + parts.toString() + AroundNavire.toString() +"]";
	}
	
	@Override
	public boolean contains(CaseNavire a) {
		if(parts.contains(a))
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public void pushAroundCase() {
		if(this.Orientation) {
			for(CaseNavire e :this.parts) {
				if(e.getX()>0) {this.AroundNavire.add(new CaseNavire(e.getX()-1,e.getY(),8));}	
				if(e.getX()<9) {this.AroundNavire.add(new CaseNavire(e.getX()+1,e.getY(),8));}
			}
			if(this.getParts().get(0).getY()>0)this.AroundNavire.add(new CaseNavire(this.getParts().get(0).getX(),this.getParts().get(0).getY()-1,8));
			if(this.getParts().get(this.getTaille()-1).getY()<9)this.AroundNavire.add(new CaseNavire(this.getParts().get(0).getX(),this.getParts().get(this.getTaille()-1).getY()+1,8));
			if((this.getParts().get(0).getY()>0)&&(this.getParts().get(0).getX()>0)) {this.AroundNavire.add(new CaseNavire(this.getParts().get(0).getX()-1,this.getParts().get(0).getY()-1,8));}
			if((this.getParts().get(0).getY()>0)&&(this.getParts().get(0).getX()<9)) {this.AroundNavire.add(new CaseNavire(this.getParts().get(0).getX()+1,this.getParts().get(0).getY()-1,8));}
			if((this.getParts().get(this.getTaille()-1).getY()<9)&&(this.getParts().get(0).getX()<9)) {this.AroundNavire.add(new CaseNavire(this.getParts().get(this.getTaille()-1).getX()+1,this.getParts().get(this.getTaille()-1).getY()+1,8));}
			if((this.getParts().get(this.getTaille()-1).getY()<9)&&(this.getParts().get(0).getX()>0)) {this.AroundNavire.add(new CaseNavire(this.getParts().get(this.getTaille()-1).getX()-1,this.getParts().get(this.getTaille()-1).getY()+1,8));}
		}
		if(!this.Orientation) {
			for(CaseNavire e :this.parts) {
				if(e.getY()>0) {this.AroundNavire.add(new CaseNavire(e.getX(),e.getY()-1,8));}
				if(e.getY()<9) {this.AroundNavire.add(new CaseNavire(e.getX(),e.getY()+1,8));}
			}
			if(this.getParts().get(0).getX()>0)this.AroundNavire.add(new CaseNavire(this.getParts().get(0).getX()-1,this.getParts().get(0).getY(),8));
			if(this.getParts().get(this.getTaille()-1).getX()<9)this.AroundNavire.add(new CaseNavire(this.getParts().get(this.getTaille()-1).getX()+1,this.getParts().get(0).getY(),8));
			if((this.getParts().get(0).getY()>0)&&(this.getParts().get(0).getX()>0)) {this.AroundNavire.add(new CaseNavire(this.getParts().get(0).getX()-1,this.getParts().get(0).getY()-1,8));}
			if((this.getParts().get(0).getY()<9)&&(this.getParts().get(0).getX()>0)) {this.AroundNavire.add(new CaseNavire(this.getParts().get(0).getX()-1,this.getParts().get(0).getY()+1,8));}
			if((this.getParts().get(0).getY()>0)&&(this.getParts().get(this.getTaille()-1).getX()<9)) {this.AroundNavire.add(new CaseNavire(this.getParts().get(this.getTaille()-1).getX()+1,this.getParts().get(this.getTaille()-1).getY()-1,8));}
			if((this.getParts().get(0).getY()<9)&&(this.getParts().get(this.getTaille()-1).getX()<9)) {this.AroundNavire.add(new CaseNavire(this.getParts().get(this.getTaille()-1).getX()+1,this.getParts().get(this.getTaille()-1).getY()+1,8));}
		}
	
	}
}