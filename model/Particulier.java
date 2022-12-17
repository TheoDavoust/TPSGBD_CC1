package model;

public class Particulier {
	
	private Client client;
	private String nom;
	private String prenom;
	private String mail;
	private Telephone telephone;
	
	public Particulier(Client client, String nom, String prenom, String mail, Telephone telephone) {
		super();
		this.client = client;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
	}

	public Client getClient() {
		return client;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getMail() {
		return mail;
	}
	
	public Telephone getTelephone() {
		return telephone;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Particulier n°" + client + " de nom=" + nom + " et prenom=" + prenom + " mail=" + mail + " telephone=" + telephone;
	}
}
