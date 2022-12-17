package model;

public class Client {
	
	private int idClient;
	private String nom;
	
	public Client(int idClient, String nom) {
		super();
		this.idClient = idClient;
		this.nom = nom;
	}

	public int getIdClient() {
		return idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Client n°" + idClient + ", nom : " + nom;
	}
}
