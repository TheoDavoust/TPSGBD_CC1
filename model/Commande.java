package model;

public class Commande {
	
	private int idCommande;
	private Contrat contrat;
	private Meuble meuble;
	private int quantite;
	
	public Commande(int idCommande, Contrat contrat, Meuble meuble, int quantite) {
		super();
		this.idCommande = idCommande;
		this.contrat = contrat;
		this.meuble = meuble;
		this.quantite = quantite;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public Meuble getMeuble() {
		return meuble;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public void setMeuble(Meuble meuble) {
		this.meuble = meuble;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "\nCommande n°" + idCommande + ", et liée au meuble=" + meuble + " commandé en "
				+ quantite+" exemplaire(s)";
	}
}
