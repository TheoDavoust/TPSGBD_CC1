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
	
	public static Meuble extraireMeuble(String code) throws Exception {
		return MeubleDAO.getMeuble(code);
	}
}
