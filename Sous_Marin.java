package com.AdamMezzas.WarShip;
import java.util.Vector;

public class Sous_Marin extends Navire{



	private Vector<CaseNavire> parts;
	private int Taille;
		
		public Sous_Marin(int x, int y, boolean Vertical) {
			super(x, y);
			parts = new Vector<CaseNavire>();
			if(!Vertical) {
	
				this.parts.add(new CaseNavire(x,y,4));
				this.parts.add(new CaseNavire(x+1,y,4));
				this.parts.add(new CaseNavire(x+2,y,4));

			}else {

				this.parts.add(new CaseNavire(x,y,4));
				this.parts.add(new CaseNavire(x,y+1,4));
				this.parts.add(new CaseNavire(x,y+2,4));

			}
			this.Taille = 3;
		}

		@Override
		public String toString() {
			return "Sous_Marin [parts=" + parts.toString() + "]";
		}
		

		public Vector<CaseNavire> getParts()   {return this.parts;           }
		public int getTaille() 				   {return this.Taille;    		 }
	}


