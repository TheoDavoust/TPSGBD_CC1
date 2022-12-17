package model;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Contrat {
    
    private int idContrat;
    private Client client;
    private Employe employe;
    private Date dateContrat;
    private String description;
    private List<Commande> commandes;
    private float prixTotal;
    
    public Contrat(int idContrat, Client client, Employe employe, Date dateContrat, String description) {
        super();
        this.idContrat = idContrat;
        this.client = client;
        this.employe = employe;
        this.dateContrat = dateContrat;
        this.description = description;
        this.prixTotal = 0;
        
        this.commandes = new ArrayList<Commande>();
    }

    public float getPrixTotal() {
		return prixTotal;
	}

	public int getIdContrat() {
        return idContrat;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public Client getClient() {
        return client;
    }

    public Employe getEmploye() {
        return employe;
    }

    public Date getDateContrat() {
        return dateContrat;
    }

    public String getDescription() {
        return description;
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
    }
    
    public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public void setDateContrat(Date dateContrat) {
        this.dateContrat = dateContrat;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
	public String toString() {
    	DecimalFormat df = new DecimalFormat("0.00");

		return "Contrat n°" + idContrat + " du client=\n" + client + "\nEt de l'employe=\n" + employe + "\nA la dateContrat="
				+ dateContrat + "\nAyant pour description=" + description + "\nAvec la liste de commandes=\n" + commandes +"\nContrat d'une valeur totale de : "+df.format(prixTotal)+"€";
	}
    
    
}