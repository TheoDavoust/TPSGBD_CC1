package model;

public class Employe {
	
	private int idEmploye;
	private String nom;
	private String prenom;
	private Type type;
	
	public Employe(int idEmploye, String nom, String prenom, Type type) {
		super();
		this.idEmploye = idEmploye;
		this.nom = nom;
		this.prenom = prenom;
		this.type = type;
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Type getType() {
		return type;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Employe n°" + idEmploye + ", nom=" + nom + ", prenom=" + prenom + ", type=" + type;
	}
}
