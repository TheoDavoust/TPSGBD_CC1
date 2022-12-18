package controleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Fournisseur;
import model.Meuble;
import utility.Connection;

public class MeubleDAO {

	public static List<Meuble> getInformationMeubleLongeur(float longueur) throws Exception {
		List<Meuble> lm = new ArrayList<Meuble>();
		try {
			Statement s;
			s = Connection.c.createStatement();
			ResultSet rs = s.executeQuery("select * from Meuble natural join Fournisseur where longueur=" + longueur + ";");
			
			if (!rs.next())
				throw new Exception("Aucun meuble n'a �t� trouv� avec cette longueur !");
			
			do  {
				Fournisseur f = new Fournisseur(rs.getInt("idFournisseur"),rs.getString("nom"),rs.getString("ville"));
				Meuble m = new Meuble(rs.getInt("idMeuble"),f,rs.getString("code"),rs.getFloat("prix"),rs.getFloat("largeur"),rs.getFloat("longueur"));
				lm.add(m);
			} while (rs.next());
			
			s.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lm;
	}
	
	public static List<Meuble> getInformationMeubleLargeur(float largeur) throws Exception {
		List<Meuble> lm = new ArrayList<Meuble>();
		try {
			Statement s;
			s = Connection.c.createStatement();
			ResultSet rs = s.executeQuery("select * from Meuble natural join Fournisseur where largeur=" + largeur + ";");
			
			if (!rs.next())
				throw new Exception("Aucun meuble n'a �t� trouv� avec cette longueur !");
			
			do  {
				Fournisseur f = new Fournisseur(rs.getInt("idFournisseur"),rs.getString("nom"),rs.getString("ville"));
				Meuble m = new Meuble(rs.getInt("idMeuble"),f,rs.getString("code"),rs.getFloat("prix"),rs.getFloat("largeur"),rs.getFloat("longueur"));
				lm.add(m);
			} while (rs.next());
			
			s.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lm;
	}

	
	public static Meuble getMeuble(String code) throws Exception{
		try {
			String sql = "SELECT * from Meuble NATURAL JOIN Fournisseur WHERE code = ?;";
			PreparedStatement ps = Connection.c.prepareStatement(sql);
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next())
				throw new Exception("Aucun meuble ne correcpond à ce code");
			
			Fournisseur f = new Fournisseur(rs.getInt("idFournisseur"), rs.getString("nom"), rs.getString("ville"));
			
			return new Meuble(rs.getInt("idMeuble"), f, rs.getString("code"), rs.getFloat("prix"),
					rs.getFloat("largeur"), rs.getFloat("longueur"));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
