package controleur;

import java.util.List;

import model.Meuble;

public class GestionMeuble {

	public static List<Meuble> extraireMeublesLongueur(float longueur) throws Exception {
		return MeubleDAO.getInformationMeubleLongeur(longueur);
	}
	
	public static List<Meuble> extraireMeublesLargeur(float largeur) throws Exception {
		return MeubleDAO.getInformationMeubleLargeur(largeur);
	}

}
