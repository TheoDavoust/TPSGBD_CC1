package controleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Commande;
import utility.Connection;

public class CommandeDAO {
	
    public static void insertCommande(Commande c) throws Exception
    {
        try {
            PreparedStatement ps;
            String sql = "INSERT INTO Commande(idContrat, idMeuble, quantite)"
                    + " VALUES (?, ?, ?);";
            ps = Connection.c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.getContrat().getIdContrat());
            ps.setInt(2, c.getMeuble().getIdMeuble());
            ps.setInt(3, c.getQuantite());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next())
            	c.setIdCommande(rs.getInt(1));
            else
            	throw new Exception("L'insertion de la commande s'est mal passé");
            
            ps.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}