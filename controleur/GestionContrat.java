package controleur;

import java.util.List;

import model.Contrat;

public class GestionContrat {

	public static List<Contrat> extraireContrat(String nom) throws Exception {
		return ContratDAO.getInformationContrat(nom);
	}

}
