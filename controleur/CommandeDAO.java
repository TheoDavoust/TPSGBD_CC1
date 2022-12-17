package controleur;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Commande;
import utility.Connection;

public class CommandeDAO {
	
    public static void insertCommande(Commande c)
    {
        try {
            PreparedStatement ps;
            String sql = "INSERT INTO Commande(idContrat, idMeuble, quantite)"
                    + " VALUES (?, ?, ?);";
            ps = Connection.c.prepareStatement(sql);
            ps.setInt(1, c.getContrat().getIdContrat());
            ps.setInt(2, c.getMeuble().getIdMeuble());
            ps.setInt(3, c.getQuantite());
            ps.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}