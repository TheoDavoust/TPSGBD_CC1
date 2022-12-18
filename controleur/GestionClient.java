package controleur;

import java.util.List;

import model.Client;
import model.Entreprise;
import model.Particulier;

public class GestionClient {

	public static List<Particulier> extraireParticuliers() {
		return ClientDAO.getInformationParticulier();
	}

	public static List<Entreprise> extraireEntreprises() {
		return ClientDAO.getInformationEntreprise();
	}
	
	public static Client extraireClient(String nom) throws Exception {
		return ClientDAO.getClient(nom);
	}
}
