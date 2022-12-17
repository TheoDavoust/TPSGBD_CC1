package model;

public class Fournisseur {
	
	private int idFournisseur;
	private String nom;
	private String ville;
	
	public Fournisseur(int idFournisseur, String nom, String ville) {
		super();
		this.idFournisseur = idFournisseur;
		this.nom = nom;
		this.ville = ville;
	}

	public int getIdFournisseur() {
		return idFournisseur;
	}

	public String getNom() {
		return nom;
	}

	public String getVille() {
		return ville;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Fournisseur n°" + idFournisseur + " de nom=" + nom + ", ville=" + ville;
	}
}
