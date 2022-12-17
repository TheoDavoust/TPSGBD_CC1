package controleur;

import java.util.List;

import model.Entreprise;
import model.Particulier;

public class GestionClient {

	public static List<Particulier> extraireParticuliers() {
		return ClientDAO.getInformationParticulier();
	}
	
	public static List<Entreprise> extraireEntreprises() {
		return ClientDAO.getInformationEntreprise();
	}

}
