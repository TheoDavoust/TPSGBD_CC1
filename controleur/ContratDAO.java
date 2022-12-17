package controleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Commande;
import model.Contrat;
import model.Employe;
import model.Fournisseur;
import model.Meuble;
import model.Type;
import utility.Connection;

public class ContratDAO {
	
    public static void insertContrat(Contrat c) {
        try {
            PreparedStatement ps;
            String sql = "INSERT INTO Contrat(idClient, idEmploye, dateContrat, description)"
                    + " VALUES (?, ?, ?, ?);";
            ps = Connection.c.prepareStatement(sql);
            ps.setInt(1, c.getClient().getIdClient());
            ps.setInt(2, c.getEmploye().getIdEmploye());
            ps.setDate(3, c.getDateContrat());
            ps.setString(4, c.getDescription());
            ps.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Contrat> getInformationContrat(String nom) throws Exception {
    	List<Contrat> lc = new ArrayList<Contrat>();
		try {
			Statement s;
			s = Connection.c.createStatement();
			ResultSet rs = s.executeQuery(" select * from client natural join contrat as c natural join commande natural join meuble as m join fournisseur as f join employe as e where client.nom='"+nom+"' and e.idEmploye=c.idEmploye and m.idFournisseur=f.idFournisseur;");
			
			if (!rs.next())
				throw new Exception("Aucun client ne correspond à ce nom !");
			
			do  {
				Client client = new Client(rs.getInt("idClient"),rs.getString("Client.nom"));
				Type t = Type.valueOf(rs.getString("type"));
				Employe employe = new Employe(rs.getInt("idEmploye"),rs.getString("e.nom"),rs.getString("e.prenom"),t);
				Fournisseur fournisseur = new Fournisseur(rs.getInt("idFournisseur"),rs.getString("nom"),rs.getString("ville"));
				Meuble meuble = new Meuble(rs.getInt("idMeuble"),fournisseur,rs.getString("code"),rs.getFloat("prix"),rs.getFloat("largeur"),rs.getFloat("longueur"));
				Contrat contrat = new Contrat(rs.getInt("idContrat"),client,employe,rs.getDate("dateContrat"),rs.getString("description"));
				Commande commande = new Commande(rs.getInt("idCommande"),contrat,meuble,rs.getInt("quantite"));
				
				// On verifie si l'entreprise est deja dans la liste, si oui, on a juste un numero de telephone a ajouter a la liste de numero de telephone
				boolean res = false;
				int i = 0;
				int indexCommande = 0;
				while (i < lc.size() && !res) {
					if (lc.get(i).getIdContrat()==contrat.getIdContrat()) {
						res = true;
						indexCommande = i;
					}
					i++;
				}
				if (res) {
					lc.get(indexCommande).getCommandes().add(commande);
					lc.get(indexCommande).setPrixTotal(lc.get(indexCommande).getPrixTotal()+meuble.getPrix()*commande.getQuantite());
				} else {
					contrat.getCommandes().add(commande);
					contrat.setPrixTotal(meuble.getPrix()*commande.getQuantite());
					lc.add(contrat);
				}
			} while (rs.next());
			
			s.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lc;
    }
}