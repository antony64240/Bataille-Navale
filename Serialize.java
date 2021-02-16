import java.io.File;
import java.io.IOException;
import java.util.Vector;

import fr.sofianelecubeur.dataserializer.CompilationType;
import fr.sofianelecubeur.dataserializer.FileDeserializerBuilder;
import fr.sofianelecubeur.dataserializer.FileSerializerBuilder;
import fr.sofianelecubeur.dataserializer.JsonFileDeserializer;
import fr.sofianelecubeur.dataserializer.JsonFileSerializer;

public class Serialize {



	void Write(Vector<EnsembleNavire> ensembleNavire) throws IOException{
		System.out.println(ensembleNavire.size());
		int nbrCaseTotal = 0;
		for (int i = 0;i<ensembleNavire.size();i++){
			nbrCaseTotal += ensembleNavire.get(i).size();
		}
		JsonFileSerializer serializer = (JsonFileSerializer) new FileSerializerBuilder().type(CompilationType.JSON).get();
		serializer.writeObject("NbrCase:", nbrCaseTotal);
		for (int i = 0 ; i < ensembleNavire.size(); i++){
			serializer.writeObject("NbrCaseBateau:"+i, ensembleNavire.get(i).size());
			for (int j = 0 ; j < ensembleNavire.get(i).size(); j++){
				String Index= String.valueOf(i);
				String Index1= String.valueOf(j);
				serializer.writeObject("X:"+Index+Index1, ensembleNavire.get(i).get(i).getParts().get(j).getX());
				serializer.writeObject("Y:"+Index+Index1, ensembleNavire.get(i).get(i).getParts().get(j).getY());
			}
		}
		long execTime = serializer.compile(new File("C:\\Users\\anton\\Desktop\\gitHub\\Bataille-Navale\\src\\Save.json")); 
		serializer.close();
		System.out.println(execTime);

	}	
	
//	Vector<Navire> read() throws IOException {
//		Vector<Navire> VectorNavire = new Vector<Navire>();
//		JsonFileDeserializer deserializer = (JsonFileDeserializer) new FileDeserializerBuilder().type(CompilationType.JSON).file(new File("C:\\\\Users\\\\anton\\\\Desktop\\\\gitHub\\\\Bataille-Navale\\\\src\\\\Save.json")).get();	
//		int NbrJ = deserializer.readInt("NbrCase:");
//		int NbrI = deserializer.readInt("NbrBateau:");
//		for(int i=0 ; i< NbrI; i++) {
//			int NbrCaseShip = 0 ;
//			NbrCaseShip = deserializer.readInt("NbrCaseBateau:"+i);
//			Navire Bateau = new Navire(NbrCaseShip);
//			for(int j = 0; i<NbrJ; j++) {
//				String Index= String.valueOf(i);
//				String Index1= String.valueOf(j);
//				int X =  deserializer.readInt("X:"+Index+Index1);		
//				int Y =  deserializer.readInt("Y:"+Index+Index1);
//				Bateau.addPart(X, Y, NbrCaseShip);
//			}
//			VectorNavire.add(Bateau);
//		}		
//		deserializer.close();
//		
//		
//		
//		return VectorNavire;
//		
//		
//	}
	
}