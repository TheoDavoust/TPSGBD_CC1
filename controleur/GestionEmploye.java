package controleur;

import model.Employe;

public class GestionEmploye {
	public static Employe extraireEmploye(String nom) throws Exception {
		return EmployeDAO.getEmploye(nom);
	}
}
