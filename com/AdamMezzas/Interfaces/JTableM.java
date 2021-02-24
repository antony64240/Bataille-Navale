package com.AdamMezzas.Interfaces;

import javax.swing.JTable;


import com.AdamMezzas.WarShip.CaseNavire;
import com.AdamMezzas.WarShip.EnsembleNavire;
import com.AdamMezzas.WarShip.Navire;

@SuppressWarnings("serial")
public class JTableM extends JTable{

	
	private static EnsembleNavire ensembleNavire;
	

	public JTableM() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public void NavireToTable() {
		for(Navire e : ensembleNavire) {
			for(CaseNavire Cn : e.getParts()){
				setTable(Cn.getX(),Cn.getY(),Cn.getValue());		
			}
			for(CaseNavire Ce : e.getAroundParts()) {
				setTable(Ce.getX(),Ce.getY(),Ce.getValue());
			}
		}
		
	}
	
	public void setTable(int x, int y, int value) {
		this.getModel().setValueAt(value,y, x);
	
	}
	
	public void setTableToO() {
		for(int i = 0; i<10;i++) {
			for(int j = 0 ; j<10 ; j++) {
				this.setTable(i,j,0);
			}
		}
	}
	
	public void toucher(int x, int y) {
		
		if(this.getValueTable(x,y)==0) {
			this.setTable(x, y, -6);
		}else {
			this.setTable(x, y, this.getValueTable(x, y)+10);
		}
	}
	
	public boolean PositionnerShip(int x, int y, int value, boolean direction){
		
		if(!direction) {
			if((x+value<11)&&(x>=0)) {
				for(int i = 0; i<value; i++) {
					if(this.getValueTable((x+i), y) != 0){
						System.out.println("Case Numero " + i +" sur bateau");
						return false;
					}
				}
			} else {return false;}
		}else {
			if((y+value<11)&&(y>=0)) {
				for(int i = 0; i<value; i++) {
					if(this.getValueTable(x, (y+i)) != 0){
						System.out.println("Case Numero " + i +" sur bateau");
						return false;
					}
				}
			} else {return false;}
		}
		return true;
	}
	
	public int getValueTable(int x, int y) {
		return (int)this.getModel().getValueAt(y,x);
	}



	public static EnsembleNavire getEnsembleNavire() {
		return ensembleNavire;
	}



	public static void setEnsembleNavire(EnsembleNavire ensembleNavire) {
		JTableM.ensembleNavire = ensembleNavire;
	}

}
