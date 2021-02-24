package com.AdamMezzas.WarShip;



import java.io.File;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fr.sofianelecubeur.dataserializer.CompilationType;
import fr.sofianelecubeur.dataserializer.FileDeserializerBuilder;
import fr.sofianelecubeur.dataserializer.FileSerializerBuilder;
import fr.sofianelecubeur.dataserializer.JsonFileDeserializer;
import fr.sofianelecubeur.dataserializer.JsonFileSerializer;




@SuppressWarnings("serial")
public class EnsembleNavire extends Vector<Navire> {
	
	private static int []TailleNavire= {5,4,3,3,2};
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
	
	@SuppressWarnings("unchecked")
	public String Write() throws IOException{
		JSONObject json = new JSONObject();
//		JsonFileSerializer serializer = (JsonFileSerializer) new FileSerializerBuilder().type(CompilationType.JSON).get();
		int i = 0;
		json.put("NbrBateau:", this.size());
		for(Navire e : this) {
			json.put("Bateau:"+ String.valueOf(i), e.getClass().getSimpleName());
			json.put("X:"+String.valueOf(i),  e.getParts().get(0).getX());
			json.put("Y:"+String.valueOf(i),  e.getParts().get(0).getY());
			json.put("Orientation:"+String.valueOf(i),  e.getOrientation());
//			serializer.writeObject("Bateau:"+ String.valueOf(i), e.getClass().getSimpleName());
//			serializer.writeObject("X:"+String.valueOf(i), e.getParts().get(0).getX());
//			serializer.writeObject("Y:"+String.valueOf(i), e.getParts().get(0).getY());
//			serializer.writeObject("Orientation:"+String.valueOf(i), e.getOrientation());
			i+=1;
		}
		i=0;
		for(Navire e : this) {
			int j = 0;
			for(CaseNavire c : e.getParts()) {
//			serializer.writeObject("VALUE:"+String.valueOf(i)+String.valueOf(j), c.getValue());
			json.put("VALUE:"+String.valueOf(i)+String.valueOf(j), c.estDetruit() );
				j++;
			}
		}
//		serializer.writeObject("NbrBateau:", this.size());
//		long execTime = serializer.compile(new File("C:\\Users\\anton\\Desktop\\gitHub\\Bataille-Navale\\src\\Save.json")); 
//		serializer.close();
		return json.toString();
	}	
	
//	public void readJson(String message) throws IOException {
//		JSONParser parser = new JSONParser();
//		Navire navire = null;
//		Object obj;
//		Ici je convertis mon String en JSONObject
//		try {
//			obj = parser.parse(message);
//			@SuppressWarnings("unused")
//			JSONObject array = (JSONObject) obj;
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		Ici je map recupères toute les éléments liés à la construction de mes navires
//		JsonFileDeserializer deserializer = (JsonFileDeserializer) new FileDeserializerBuilder().type(CompilationType.JSON).file(new File("C:\\\\Users\\\\anton\\\\Desktop\\\\gitHub\\\\Bataille-Navale\\\\src\\\\Save.json")).get();	
//		int NbrI = deserializer.readInt("NbrBateau:");
//		for(int i=0 ; i< NbrI; i++) {
//			boolean Orientation = deserializer.readBoolean("X:"+String.valueOf(i));
//			int X =  deserializer.readInt("X:"+String.valueOf(i));		
//			int Y =  deserializer.readInt("Y:"+String.valueOf(i));
//			String Bateau = deserializer.readUTF("Bateau:"+i);
//			switch(Bateau) {
//			case "Porte_Avion" :  navire = new Porte_Avion(X,Y,Orientation);
//			break;
//			case "Croiseur" :  navire = new Croiseur(X,Y,Orientation);
//			break;
//			case "Torpilleur" :  navire = new Torpilleur(X,Y,Orientation);
//			break;
//			case "Sous_Marin" :  navire = new Sous_Marin(X,Y,Orientation);
//			break;
//			case "Contre_Torpilleur" :  navire = new Contre_Torpilleur(X,Y,Orientation);
//			break;
//			default :
//				System.out.println("Erreur de chargement des bateaux");
//			}
//			int j = 0;
//			for(CaseNavire Cn : navire.getParts()) {
//				Cn.estDetruit(deserializer.readBoolean("VALUE:"+String.valueOf(i)+String.valueOf(j)));
//				j++;
//			}
//			this.add(navire);
//		}			
//		deserializer.close();	
//	}
	
	
	public void read() throws IOException {
		Navire navire = null;
		JsonFileDeserializer deserializer = (JsonFileDeserializer) new FileDeserializerBuilder().type(CompilationType.JSON).file(new File("C:\\\\Users\\\\anton\\\\Desktop\\\\gitHub\\\\Bataille-Navale\\\\src\\\\Save.json")).get();	
		int NbrI = deserializer.readInt("NbrBateau:");
		for(int i=0 ; i< NbrI; i++) {
			boolean Orientation = deserializer.readBoolean("X:"+String.valueOf(i));
			int X =  deserializer.readInt("X:"+String.valueOf(i));		
			int Y =  deserializer.readInt("Y:"+String.valueOf(i));
			String Bateau = deserializer.readUTF("Bateau:"+i);
			switch(Bateau) {
			case "Porte_Avion" :  navire = new Porte_Avion(X,Y,Orientation);
			break;
			case "Croiseur" :  navire = new Croiseur(X,Y,Orientation);
			break;
			case "Torpilleur" :  navire = new Torpilleur(X,Y,Orientation);
			break;
			case "Sous_Marin" :  navire = new Sous_Marin(X,Y,Orientation);
			break;
			case "Contre_Torpilleur" :  navire = new Contre_Torpilleur(X,Y,Orientation);
			break;
			default :
				System.out.println("Erreur de chargement des bateaux");
			}
			int j = 0;
			for(CaseNavire Cn : navire.getParts()) {
				Cn.estDetruit(deserializer.readBoolean("VALUE:"+String.valueOf(i)+String.valueOf(j)));
				j++;
			}
			this.add(navire);
		}	
		
		deserializer.close();
		
	}
	
	public boolean contains(CaseNavire c) {
		for(Navire D : this) {
			if(D.contains(c)) {
				return true;
			}
		}
		return false;
	}
	
	public void randomPos() {
		Navire navire = null;
		for (int i = 0; i <5; i++) {
			int taille = TailleNavire[i];
			
			boolean direction = false;
			if(Math.random()>0.5) {
				direction = true;
			}else {
				direction = false;
			}
			
			int x = (int) (Math.random()*(11-taille));
			int y = (int) (Math.random()*(11-taille));
			
			
			switch(i) {
			case 0 : navire=(new Porte_Avion(x,y,direction)); break;
			case 1 : navire=(new Croiseur(x,y,direction)); break;
			case 2 : navire=(new Sous_Marin(x,y,direction));break;
			case 3 : navire=(new Torpilleur(x,y,direction));break;
			case 4 : navire=(new Contre_Torpilleur(x,y,direction)); break;
			default : System.out.println("Erreur dans le chargement des navires");
			}
			
			
			if(!checkNavire(navire)) {
				this.add(navire);
			}
			else{
				i--;
			}			
			
		}
	}
	




	boolean checkNavire(Navire e) {
		for(CaseNavire Cs : e.getParts()) {
			if(this.contains(Cs)) {
				return true;
			}
		}
		for(CaseNavire C : e.getAroundParts()) {
			if(this.contains(C)) {
				return true;
			}
		}
		return false;
	}
	
	

	
	
}
