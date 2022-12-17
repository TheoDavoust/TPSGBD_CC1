package model;

import java.util.ArrayList;
import java.util.List;

public class Entreprise {
	
	private Client client;
	private String nom;
	private String numTVA;
	private String adresseSiegeSocial;
	private List<Telephone> telephone;
	
	public Entreprise(Client client, String nom, String numTVA, String adresseSiegeSocial) {
		super();
		this.client = client;
		this.nom = nom;
		this.numTVA = numTVA;
		this.adresseSiegeSocial = adresseSiegeSocial;
		this.telephone = new ArrayList<Telephone>();
	}

	public Client getClient() {
		return client;
	}

	public String getNom() {
		return nom;
	}

	public String getNumTVA() {
		return numTVA;
	}

	public String getAdresseSiegeSocial() {
		return adresseSiegeSocial;
	}
	
	public List<Telephone> getTelephone() {
		return telephone;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNumTVA(String numTVA) {
		this.numTVA = numTVA;
	}

	public void setAdresseSiegeSocial(String adresseSiegeSocial) {
		this.adresseSiegeSocial = adresseSiegeSocial;
	}

	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		String res = "Entreprise n°" + client + " de nom=" + nom + ", numTVA=" + numTVA + ", adresseSiegeSocial="
				+ adresseSiegeSocial +" avec la liste de numero de telephone : \n" + telephone;
		
		return res;
	}
}
