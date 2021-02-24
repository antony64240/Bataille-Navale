package com.AdamMezzas.WarShip;

import java.util.Vector;

public class Torpilleur extends Navire{
			private Vector<CaseNavire> AroundNavire;
			private Vector<CaseNavire> parts;
			private int Taille;
			private boolean Orientation;
	
	public Torpilleur(int x, int y, boolean Vertical) {
		super();
		this.Taille= 3;
		Orientation = Vertical;
		parts = new Vector<CaseNavire>();
		AroundNavire = new Vector<CaseNavire>();
		if(!Vertical) {
			parts.add(new CaseNavire(x,y,3));
			parts.add(new CaseNavire(x+1,y,3));
			parts.add(new CaseNavire(x+2,y,3));
		}else {
			parts.add(new CaseNavire(x,y,3));
			parts.add(new CaseNavire(x,y+1,3));
			parts.add(new CaseNavire(x,y+2,3));
		}
		pushAroundCase();
	}
	
	public Torpilleur() {
		super();
		parts = new Vector<CaseNavire>();
		this.Taille = 3;
	}

	public String toString() {
		return "Torpilleur [parts=" + this.parts.toString() + "partsAround=" + this.AroundNavire.toString() + "]";
	}
	
	public Vector<CaseNavire> getAroundParts()  {return this.AroundNavire;   			    }
	public Vector<CaseNavire> getParts()   {return this.parts;                }
	public int getTaille() 				   {return this.Taille;			 }
	public void addPart(int x, int y)      {this.parts.add(new CaseNavire(x,y,3));}
	public boolean getOrientation() { return this.Orientation;}
	
	
	@Override
	  public boolean contains(CaseNavire a) {
		if(this.parts.contains(a))
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
		if(!Orientation) {
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
