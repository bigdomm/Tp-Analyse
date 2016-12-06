
/**
 * Main du programme de location de véhicule
 * 
 * Auteur: Dominic Lafrance 
 * Date de création: 2016-04-02 
 * Modifié par: Vincent Gélinas 
 * Date de modification: 2016-04-11
 * 
 */

public class Main {

	final static String espaceEntreMenus = "\n\n\n";

	public static void main(String[] args) {

		// Données initiales de l'application
		GestionnaireClient.ajoutClient("Caron", "Bob", 19750324, "123", "123456789");
		Vehicules.createVehicule(new Vehicules("NIS01","Sentra","Nissan",5, "2009","PZD 5P4","rouge",Vehicules.Etat.LIBRE,false,350));
		Vehicules.createVehicule(new Vehicules("NIS02","Versa","Nissan",5, "2011","HIK 8T1","bleu",Vehicules.Etat.ENLOCATION,false,250));
		Vehicules.createVehicule(new Vehicules("HYU01","Accent","Hyundai",5, "2005","J8L 5M4","gris",Vehicules.Etat.LIBRE,false,200));
		Vehicules.createVehicule(new Vehicules("MER01","SLK","Mercedes",4, "2014","G2D 2J3","noir",Vehicules.Etat.LIBRE,true,750));
		
		gestionMain();

	}

	public static void gestionMain() {
		int choix = 0;

		// boucle qui reccomencera tant que l'utilisateur ne veut pas quitter le
		// programme
		do {
			// menu principale
			choix = menuPrincipale();
			switch (choix) {

			// Menu 1 - On se rend au cas Gestion client
			case 1:
				AjoutClient.gestionClient();
				break;

			// Menu 2 - On se rend au cas Gestion location
			case 2:
				AjoutLocation.gestionLocation();
				break;
			case 3: 
				System.exit(0);
				break;
			}
			// Affiche une espace entre les menus lorsque on reviens au menu
			// principale
			System.out.println(espaceEntreMenus);

		} while (choix != 4);
	}

	private static int menuPrincipale() {

		System.out.println("----- Menu principal -----\n");
		System.out.println("1 - Cas #1 Gestion client");
		System.out.println("2 - Cas #2 Gestion location");
		System.out.println("3 - Quitter l'application");

		System.out.print("\nInscrivez le chiffre a la gauche de l'action désiré : ");

		// Scan d'un entier entre 1 et 2
		return ScanEntrer.scannerEntier(1, 3, "Désolé, choix invalide!");
	}

}