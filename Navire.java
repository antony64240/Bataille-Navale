package com.AdamMezzas.WarShip;

import java.util.Vector;

public abstract class Navire {

	private static EnsembleNavire ensembleNavire;
	private Vector<CaseNavire> parts;
	
	
	public Navire(int x,int y) {
		super();
		
	}

	public static EnsembleNavire getEnsembleNavire() {
		return ensembleNavire;
	}

	public static void setEnsembleNavire(EnsembleNavire ensembleNavire) {
		Navire.ensembleNavire = ensembleNavire;
	}
	
	
	
	public Vector<CaseNavire> getParts()   {return parts;                }

	public abstract int getTaille();

	
	
	

}
