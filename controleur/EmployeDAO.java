package controleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employe;
import model.Type;
import utility.Connection;

public class EmployeDAO {
	public static Employe getEmploye(String nom) throws Exception{
		try {
			String sql = "SELECT * from Employe WHERE nom = ?;";
			PreparedStatement ps = Connection.c.prepareStatement(sql);
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next())
				throw new Exception("Aucun employé ne correcpond à ce nom");
			
			Type type = Type.Commerciaux;
			switch (rs.getString("type")) {
				case "Commerciaux":
					type = Type.Commerciaux;
					break;
				case "Administratif":
					type = Type.Administratif;
					break;
				case "Fabricant":
					type = Type.Fabricant;
					break;
			}
			
			return new Employe(rs.getInt("idEmploye"), rs.getString("nom"),
					rs.getString("prenom"), type);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
