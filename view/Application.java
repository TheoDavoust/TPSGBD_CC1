package view;

import java.util.List;
import java.util.Scanner;

import controleur.GestionClient;
import controleur.GestionContrat;
import controleur.GestionMeuble;
import model.Contrat;
import model.Entreprise;
import model.Meuble;
import model.Particulier;
import utility.Connection;

public class Application {

	public static void main(String args[]) throws Exception {
		Connection.connection();
		
		showMenuGlobal();
		Scanner scanner = new Scanner(System.in);
		int choix = scanner.nextInt();
		
		switch(choix) {
			case 1 : 
				showMenuAjout();
				Scanner scan = new Scanner(System.in);
				int choix2 = scan.nextInt();
				switch(choix2) {
					case 1 : 
						
						break;
					case 2 : 
						
						break; 
				}
				break;
			case 2 : 
				showMenuAffichage();
				Scanner scan2 = new Scanner(System.in);
				int choix3 = scan2.nextInt();
				switch(choix3) {
					case 1 : 
						List<Particulier> lp = GestionClient.extraireParticuliers();
						List<Entreprise> le = GestionClient.extraireEntreprises();
						showClients(lp,le);
						break;
					case 2 : 
						System.out.println("Saisir le nom du client : ");
						Scanner clientNom = new Scanner(System.in);
						String nomCli = clientNom.next();
						clientNom.close();
						List<Contrat> lcom = GestionContrat.extraireContrat(nomCli);
						showContrat(lcom);
						break; 
					case 3 : 
						System.out.println("Saisir une longueur de meuble positive");
						Scanner longueurMeuble = new Scanner(System.in);
						float longMeuble = longueurMeuble.nextFloat();
						longueurMeuble.close();
						while (longMeuble <= 0) {
							System.out.println("Erreur : Veuillez saisir une longueur positive");
							longueurMeuble = new Scanner(System.in);
							longMeuble = longueurMeuble.nextFloat();
						}
						List<Meuble> lm = GestionMeuble.extraireMeublesLongueur(longMeuble);
						showMeuble(lm);
						break;
					case 4 : 
						System.out.println("Saisir une largeur de meuble positive");
						Scanner largeurMeuble = new Scanner(System.in);
						float largMeuble = largeurMeuble.nextFloat();
						largeurMeuble.close();
						while (largMeuble <= 0) {
							System.out.println("Erreur : Veuillez saisir une largeur positive");
							largeurMeuble = new Scanner(System.in);
							largMeuble = largeurMeuble.nextFloat();
						}
						List<Meuble> lm2 = GestionMeuble.extraireMeublesLargeur(largMeuble);
						showMeuble(lm2);
						break;
				}
				break;
		}
		scanner.close();
	}
	
	private static void showMenuGlobal() {
		System.out.println("1 : Ajouter des données");
		System.out.println("2 : Afficher des données");
	}
	
	private static void showMenuAjout() {
		System.out.println("1 : Ajouter un telephone");
		System.out.println("2 : Ajouter un client");
		System.out.println("3 : Ajouter un particulier");
		System.out.println("4 : Ajouter une entreprise");
		System.out.println("5 : Ajouter un employe");
		System.out.println("6 : Ajouter un fournisseur");
		System.out.println("7 : Ajouter un contrat");
		//...
	}
	
	private static void showMenuAffichage() {
		System.out.println("1 : Afficher les clients");
		System.out.println("2 : Afficher les contrats lié à un client");
		System.out.println("3 : Afficher les meubles d'une certaine longueur");
		System.out.println("4 : Afficher les meubles d'une certaine largeur");
		//...
	}
	
	private static void showClients(List<Particulier> lp, List<Entreprise> le) {
		System.out.println("Liste de clients : ");
		for (Particulier p : lp)
			System.out.println(p);
		for (Entreprise e : le)
			System.out.println(e);
	}
	
	private static void showMeuble(List<Meuble> lm) {
		System.out.println("Liste de meubles : ");
		for (Meuble m : lm)
			System.out.println(m);
	}
	
	private static void showContrat(List<Contrat> lcat) {
		System.out.println("Liste des contrats : ");
		for (Contrat c : lcat)
			System.out.println(c);
	}

}
