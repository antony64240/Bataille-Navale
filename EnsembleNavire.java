package com.AdamMezzas.WarShip;



import java.io.File;
import java.io.IOException;
import java.util.Vector;

import fr.sofianelecubeur.dataserializer.CompilationType;
import fr.sofianelecubeur.dataserializer.FileSerializerBuilder;
import fr.sofianelecubeur.dataserializer.JsonFileSerializer;




@SuppressWarnings("serial")
public class EnsembleNavire extends Vector<Navire> {
	
	public EnsembleNavire() {
		Navire.setEnsembleNavire(this);
	}

	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < this.size();i++)
		{
			result += this.get(i).toString() + "\n";
		}
		return result;
	}
	
	void Write() throws IOException{
		System.out.println(this.size());
		int nbrCaseTotal = 0;
		for (int i = 0;i<this.size();i++){
			nbrCaseTotal += this.get(i).getTaille();
		
		}
		JsonFileSerializer serializer = (JsonFileSerializer) new FileSerializerBuilder().type(CompilationType.JSON).get();
		serializer.writeObject("NbrCase:", nbrCaseTotal);
		serializer.writeObject("NbrBateau:", this.size());
		for (int i = 0 ; i < this.size(); i++){
			System.out.println("Bateau " + i + " " + this.size());
			serializer.writeObject("NbrCaseBateau:"+i, this.get(i).getTaille());
			for (int j = 0 ; j < this.get(i).getTaille(); j++){
				String Index= String.valueOf(i);
				String Index1= String.valueOf(j);
				serializer.writeObject("X:"+Index+Index1, this.get(i).getParts().get(j).getX());
				serializer.writeObject("Y:"+Index+Index1, this.get(i).getParts().get(j).getY());
				System.out.println();
			}
		}
		long execTime = serializer.compile(new File("C:\\Users\\anton\\Desktop\\gitHub\\Bataille-Navale\\src\\Save.json")); 
		serializer.close();

	}	
}
