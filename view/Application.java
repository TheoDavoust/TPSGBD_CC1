package view;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controleur.GestionClient;
import controleur.GestionContrat;
import controleur.GestionEmploye;
import controleur.GestionMeuble;
import model.Client;
import model.Commande;
import model.Contrat;
import model.Employe;
import model.Entreprise;
import model.Meuble;
import model.Particulier;
import utility.Connection;

public class Application {
	
	private static Map<Integer, String> choix_principales;
	private static Map<Integer, String> choix_ajout;
	private static Map<Integer, String> choix_affichage;
	
	private static String delimiter = "\n";
	
	private static void initMaps()
	{
		choix_principales = new HashMap<Integer, String>() {{
			put(1, "ajouter");
			put(2, "afficher");
		}};
		
		choix_affichage = new HashMap<Integer, String>() {{
			put(1, "clients");
			put(2, "contrats liés à  un client");
			put(3, "meubles d'une certaines longueur");
			put(4, "meubles d'une certaines largeur");
		}};
		
		choix_ajout = new HashMap<Integer, String>() {{
			put(1, "téléphone");
			put(2, "client");
			put(3, "particulier");
			put(4, "entreprise");
			put(5, "employé");
			put(6, "fournisseur");
			put(7, "contrat");
		}};
	}
	
	public static void main(String args[]) throws Exception {
		Connection.connection();
		initMaps();

		showMenuGlobal();
		Scanner scanner = new Scanner(System.in);
		int choix = scanner.nextInt();

		switch (choix){
		case 1:
			showMenuAjout();
			Scanner scan = new Scanner(System.in);
			int choix2 = scan.nextInt();
			switch (choix2) {
			case 1:
				System.out.println("Not yet implemented");
				break;
			case 2:
				System.out.println("Not yet implemented");
				break;
			case 3:
				System.out.println("Not yet implemented");
				break;
			case 4:
				System.out.println("Not yet implemented");
				break;
			case 5:
				System.out.println("Not yet implemented");
				break;
			case 6:
				System.out.println("Not yet implemented");
				break;
			case 7:
				System.out.println("Saisir le nom du client : ");
				Scanner Scan = new Scanner(System.in);
				String clientNom = Scan.next();
				
				Client c = GestionClient.extraireClient(clientNom);
				
				System.out.println("Saisir le nom de l'employé : ");
				String employeNom = Scan.next();
				
				Employe e = GestionEmploye.extraireEmploye(employeNom);
				
				System.out.println("Saisir la date du contrat au format yyyy-mm-dd : ");
				Date d = Date.valueOf(Scan.next());
				
				System.out.println("Saisir la description du contrat : ");
				String desc = Scan.next();
				
				Contrat contrat = new Contrat(0, c, e, d, desc);
				
				System.out.println("Saisir le nombre de meuble à ajouter au contrat : ");
				int i = Integer.parseInt(Scan.next());
				
				for(int j = 0; j < i; j++)
				{
					System.out.println("Saisir le code du meuble : ");
					String code = Scan.next();
					Meuble m = GestionMeuble.extraireMeuble(code);
					
					System.out.println("Saisir la quantité : ");
					int qte = Scan.nextInt();
					contrat.setPrixTotal(contrat.getPrixTotal()+m.getPrix()*qte);
					contrat.getCommandes().add(new Commande(0, contrat, m, qte));
				}
				
				GestionContrat.insertContrat(contrat);
				System.out.println("Contrat ajouté : \n");
				System.out.println(contrat);
				Scan.close();
				break;
			}
			break;
		case 2:
			showMenuAffichage();
			Scanner scan2 = new Scanner(System.in);
			int choix3 = scan2.nextInt();
			switch (choix3) {
			case 1:
				showClients();
				break;
			case 2:
				System.out.println("Saisir le nom du client : ");
				Scanner clientNom = new Scanner(System.in);
				String nomCli = clientNom.next();
				clientNom.close();
				List<Contrat> lcom = GestionContrat.extraireContrat(nomCli);
				showContrat(lcom);
				break;
			case 3:
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
			case 4:
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
		choix_principales.forEach((key, value) -> System.out.println(String.format("%d : %s des données", key, value)));
	}

	private static void showMenuAjout() {
		choix_ajout.forEach((key, value) -> System.out.println(String.format("%d : Ajouter %s", key, value)));
	}

	private static void showMenuAffichage() {
		choix_affichage.forEach((key, value) -> System.out.println(String.format("%d : Afficher %s", key, value)));
	}

	private static void showClients() {
		List<Particulier> lp = GestionClient.extraireParticuliers();
		List<Entreprise> le = GestionClient.extraireEntreprises();
		
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
