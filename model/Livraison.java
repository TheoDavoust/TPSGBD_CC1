package model;

import java.sql.Date;
import java.sql.Time;

public class Livraison {
    
    private int idLivraison;
    private Contrat contrat;
    private String adresse;
    private Date dateLivraison;
    private Time heureLivraison;
    
    public Livraison(int idLivraison, Contrat contrat, String adresse, Date dateLivraison, Time heureLivraison) {
        super();
        this.idLivraison = idLivraison;
        this.contrat = contrat;
        this.adresse = adresse;
        this.dateLivraison = dateLivraison;
        this.heureLivraison = heureLivraison;
    }

    public int getIdLivraison() {
        return idLivraison;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public String getAdresse() {
        return adresse;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setIdLivraison(int idLivraison) {
        this.idLivraison = idLivraison;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Time getHeureLivraison() {
        return heureLivraison;
    }

    public void setHeureLivraison(Time heureLivraison) {
        this.heureLivraison = heureLivraison;
    }

    @Override
    public String toString() {
        return "Livraison n°" + idLivraison + ", liée au contrat=" + contrat + ", adresse=" + adresse
                + ", dateLivraison=" + dateLivraison + ", heureLivraison=" + heureLivraison;
    }
}