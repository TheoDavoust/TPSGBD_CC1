package controleur;

import java.util.List;

import model.Commande;
import model.Contrat;

public class GestionContrat {

	public static List<Contrat> extraireContrat(String nom) throws Exception {
		return ContratDAO.getInformationContrat(nom);
	}
	
	public static void insertContrat(Contrat c) throws Exception {
		ContratDAO.insertContrat(c);
		System.out.println(c);
		for(Commande com : c.getCommandes()) {
			CommandeDAO.insertCommande(com);
		}
	}
}
