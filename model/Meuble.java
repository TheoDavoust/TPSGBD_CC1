package model;

public class Meuble {
	
	private int idMeuble;
	private Fournisseur fournisseur;
	private String code;
	private float prix;
	private float largeur;
	private float longueur;
	
	public Meuble(int idMeuble, Fournisseur fournisseur, String code, float prix, float largeur, float longueur) {
		super();
		this.idMeuble = idMeuble;
		this.fournisseur = fournisseur;
		this.code = code;
		this.prix = prix;
		this.largeur = largeur;
		this.longueur = longueur;
	}

	public int getIdMeuble() {
		return idMeuble;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public String getCode() {
		return code;
	}

	public float getPrix() {
		return prix;
	}

	public float getLargeur() {
		return largeur;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setIdMeuble(int idMeuble) {
		this.idMeuble = idMeuble;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	@Override
	public String toString() {
		return "Meuble n°" + idMeuble + ",du fournisseur=" + fournisseur + ", nom du meuble =" + code + ", prix=" + prix
				+ " de largeur=" + largeur + "m et de longueur=" + longueur + "m";
	}
}
