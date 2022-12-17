package controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Entreprise;
import model.Particulier;
import model.Telephone;
import utility.Connection;


public class ClientDAO {

	public static List<Particulier> getInformationParticulier() {
		List<Particulier> lc = new ArrayList<Particulier>();
		try {
			Statement s;
			s = Connection.c.createStatement();
			ResultSet rs = s.executeQuery("select * from particulier natural join client natural join telephone;");
			
			while(rs.next()) {
				Client c = new Client(rs.getInt("Particulier.idClient"),rs.getString("Particulier.nom"));
				Telephone t = new Telephone(rs.getInt("Telephone.idTelephone"),c,rs.getString("Telephone.telephone"));
				Particulier p = new Particulier(c,rs.getString("Particulier.nom"),rs.getString("Particulier.prenom"),rs.getString("Particulier.mail"),t);
				lc.add(p);
			}
			s.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lc;
	}
	
	public static List<Entreprise> getInformationEntreprise() {
		List<Entreprise> le = new ArrayList<Entreprise>();
		try {
			Statement s;
			s = Connection.c.createStatement();
			ResultSet rs = s.executeQuery("select * from entreprise natural join client natural join telephone;");
			
			while(rs.next()) {
				Client c = new Client(rs.getInt("Entreprise.idClient"),rs.getString("Entreprise.nom"));
				Telephone t = new Telephone(rs.getInt("Telephone.idTelephone"),c,rs.getString("Telephone.telephone"));
				Entreprise e = new Entreprise(c,rs.getString("Entreprise.nom"),rs.getString("Entreprise.numTVA"),rs.getString("Entreprise.adresseSiegeSocial"));
	
				// On verifie si l'entreprise est deja dans la liste, si oui, on a juste un numero de telephone a ajouter a la liste de numero de telephone
				boolean res = false;
				int i = 0;
				int indexClient = 0;
				while (i < le.size() && !res) {
					if (le.get(i).getClient().getIdClient()==e.getClient().getIdClient()) {
						res = true;
						indexClient = i;
					}
					i++;
				}
				if (res) 
					le.get(indexClient).getTelephone().add(t);
				else {
					e.getTelephone().add(t);
					le.add(e);
				}
			}
			s.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return le;
	}

}
