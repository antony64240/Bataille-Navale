package AdamMezzas.Connection;

import java.util.Vector;


@SuppressWarnings("serial")
public class EnsemblePartie extends Vector<Partie> {

	public EnsemblePartie() 			{	Serveur.SetEnsemblePartie(this);		}

}
