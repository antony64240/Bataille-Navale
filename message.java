public class message {
	
	private static final String message1 = "A l'eau !";
	private static final String message2 ="Porte-avion touché !";
	private static final String message3 ="Croiseur touché !";
	private static final String message4="Contre-torpilleur touché !";
	private static final String message5="Sous-marin touché !";
	private static final String message6="Torpilleur touché !";
	private static final String message7="Case déjà jouée !";
	private static final String message8="Case trop proche de l'autre bateau !";
	private static final String message9="Bateau crée !";
	private static final String message11="Porte-avion coulé !";
	private static final String message12="Croiseur coulé !";
	private static final String message13="Contre-torpilleur coulé !";
	private static final String message14="Sous-marin coulé !";
	private static final String message15="Torpilleur coulé !";
	
	

	void getmessage (int X) {
		switch (X) {
			case 1 :  System.out.println(message1);
			break;
			case 2 :  System.out.println(message2);
			break;
			case 3 :  System.out.println(message3);
			break;
			case 4 :  System.out.println(message4);
			break;
			case 5 :  System.out.println(message5);
			break;
			case 6 :  System.out.println(message6);
			break;
			case 7 :  System.out.println(message7);
			break;
			case 8 :  System.out.println(message8);
			break;
			case 11 :  System.out.println(message11);
			break;
			case 12  :  System.out.println(message12);
			break;
			case 13 :  System.out.println(message13);
			break;
			case 14 :  System.out.println(message14);
			break;
			case 15 :  System.out.println(message15);
			break;
			default :  System.out.println("error");
		}
	}

		
		 		
		

}