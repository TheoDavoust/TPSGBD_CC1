package controleur;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Livraison;
import utility.Connection;

public class LivraisonDAO {
    public static void insertLivraison(Livraison l) {
        try {
            PreparedStatement ps;
            String sql = "INSERT INTO Livraison(idContrat, adresse, dateLivraison, heureLivraison)"
                    + " VALUES (?, ?, ?, ?);";
            ps = Connection.c.prepareStatement(sql);
            ps.setInt(1, l.getContrat().getIdContrat());
            ps.setString(2, l.getAdresse());
            ps.setDate(3, l.getDateLivraison());
            ps.setTime(4, l.getHeureLivraison());
            ps.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}