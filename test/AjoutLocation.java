import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cas #2 Gestion des locations - Créér une location
 * 
 * Classe qui simule l'interface de location. Elle communique avec le controleur
 * Auteur: Vincent Gélinas Date de création: 2016-04-11
 * 
 */

public class AjoutLocation {
	public static void gestionLocation() {
		int choix = 0;

		do {
			// Saisie de l'action de l'usager
			choix = menuLocation();
			switch (choix) {

			// Menu 1 - On se rend au cas Gestion location
			case 1:
				creerLocation();
				break;
			case 2:
				listerLocation();
				break;
			case 3:
				Main.gestionMain();
				break;
			}

		} while (choix != 3);
	}

	// Menu de la gestion des location
	private static int menuLocation() {

		System.out.println("----- Gestion location -----\n");
		System.out.println("1 - Démarrer une location");
		System.out.println("2 - Lister les locations en cours");
		System.out.println("3 - Retour au menu principal");

		System.out.print("\nInscrivez le chiffre a la gauche de l'action désiré : ");

		// Scan d'un entier entre 1 et 5
		return ScanEntrer.scannerEntier(1, 4, "Désolé, choix invalide!");

	}

	// Lancement d'une location
	private static void creerLocation() {

		String idClient = "";
		idClient = saisirPermis();

		// On effectue le scénario #1 du cas Gestion de location
		// Dans le graphique on passe normalement le numero de permis ici mais
		// dans le cas du programme console on fait la validation du permis
		// directement ici pour facilité la fluidité du programme. On passe
		// alors l'id du client au controleur
		if (!GestionnaireLocation.demarrerLocation(idClient)) {

			// Saisie de la date de fin de location
			String dateFin = "";
			dateFin = saisirDateFin();

			String codeVehicule = "";
			codeVehicule = saisirInfoVehicule();

			// On effectue le scénario #2 du cas Gestion de location
			if (!GestionnaireLocation.saisirInfoLocation(dateFin, codeVehicule)) {

				// Saisie du mode de paiement
				System.out.print("Saisissez le mode de paiement : ");
				String modePaiement = ScanEntrer.regString();

				// On effectue le scénario #3 et #4 du cas Gestion de location
				GestionnaireLocation.creerPaiement(modePaiement);

				// Le scénario #5 du cas Gestion de location consiste a
				// enregistré la location dans une base de donnée ce qui n'est
				// pas geré dans cette application console.
			}
		}

	}

	// Validation que le code de véhicule est bien entré. Normalement cela se
	// ferait pas ici avec un interface
	// mais dans un soucis de fluidité du programme console je valide
	// l'information lors de la saisie
	private static String inputCodeVehicule() {

		System.out.println("-----  Liste des véhicules ----- ");
		GestionnaireLocation.listerVehicules(Vehicules.getListVehicule());

		System.out.print("Saisissez le code du véhicule à louer : ");
		String codeVehicule = ScanEntrer.regString();

		if (!Vehicules.findVehicule(codeVehicule)) {
			System.out.println("Aucun véhicule avec ce code a été trouvé");
			System.out.println(Main.espaceEntreMenus);
			return "";
		} // Cette validation ne se ferait pas ici normalement mais les besoins
			// du programme console m'oblige a le faire ici pour avoir une
			// experience utilisateur fluide
		else if (!Vehicules.verifDispo(codeVehicule)) {
			System.out.println("Le véhicule n'est pas disponible");
			System.out.println(Main.espaceEntreMenus);
			return "";
		} else {
			return codeVehicule;
		}
	}

	// Validation que la date de fin de location est bien entré. Normalement
	// cela se
	// ferait pas ici avec un interface
	// mais dans un soucis de fluidité du programme console je valide
	// l'information lors de la saisie
	private static String inputDateFin() {

		System.out.print("Saisissez la date de fin de location (YYYY-MM-DD) : ");
		String dateFin = ScanEntrer.regString();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Date today = new Date();

		try {
			date = dateFormat.parse(dateFin);
		} catch (ParseException e) {
			System.out.println("La date saisie n'est pas valide");
			System.out.println(Main.espaceEntreMenus);
			return "";
		}

		if (!dateFin.equals(dateFormat.format(date))) {
			System.out.println("La date saisie n'est pas valide");
			System.out.println(Main.espaceEntreMenus);
			return "";
		} else if (date.before(today)) {
			System.out.println("La date de fin de location doit être dans le futur");
			System.out.println(Main.espaceEntreMenus);
			return "";
		} else {
			return dateFormat.format(date);
		}
	}

	// Validation que le permis entré existe dans la liste
	// Normalement on ferait ca pas ici avec un interface
	// mais dans un soucis de fluidité du programme console je valide
	// l'information lors de la saisie
	private static String inputPermis() {

		// Saisie du permis du client
		System.out.print("Saisissez le permis du client : ");
		String permis = ScanEntrer.regString();
		String idClient = "";

		if (Clients.findClient(permis)) {
			idClient = Clients.getIdClient(permis);
			return idClient;
		} else {
			System.out.println("Aucun client avec ce numéro de permis a été trouvé");
			System.out.println(Main.espaceEntreMenus);
			return "";
		}
	}

	private static String saisirInfoVehicule() {
		// Saisie et validation du code du véhicule
		//Modification : Dominic Lafrance
		//2016-04-18
		String codeVehicule = "";
		do {
			codeVehicule = inputCodeVehicule();
		} while (codeVehicule == "");
		//Mofication
		return codeVehicule.toUpperCase();
	}

	private static String saisirDateFin() {
		// Saisie et validation de la date de fin
		String dateFin = "";
		do {
			dateFin = inputDateFin();
		} while (dateFin == "");

		return dateFin;
	}

	private static String saisirPermis() {
		// Saisie et validation du permis
		String permis = "";
		do {
			permis = inputPermis();
		} while (permis == "");

		return permis;
	}

	// Liste des locations en cours
	private static void listerLocation() {

		System.out.println(Main.espaceEntreMenus);
		System.out.println("-----  Liste des locations ----- ");
		GestionnaireLocation.listerLocations(Locations.getListeLocation());
	}
}
