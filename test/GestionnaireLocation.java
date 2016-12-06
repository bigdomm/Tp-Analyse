
/**
 * Controleur de la gestion des locations
 * 
 * Auteur: Vincent G�linas
 * Date de cr�ation: 2016-04-11
 * 
 */

import java.text.ParseException;
import java.util.ArrayList;

public class GestionnaireLocation {

	// Sc�nario #1 du cas Gestions des locations
	public static boolean demarrerLocation(String idClient) {
		
		boolean cancel = false;
		

		if (!cancel) {
			Locations.createLocation(new Locations(idClient));
		}

		return cancel;
	}

	// Sc�nario #2 du cas Gestions des locations
	public static boolean saisirInfoLocation(String dateFin, String codeVehicule) {
		public boolean cancel = false;

			Vehicules.reserver(codeVehicule);
			Locations.setInfoLocation(dateFin, codeVehicule);
		
		
		return cancel;

	}

	// Sc�nario #3 et 4 du cas Gestions des locations
	public static void creerPaiement(String modePaiement) {
		int idPaiement = 0;
		double prixTotal = 0; 
		try {
			prixTotal = Locations.calculMontantLocation();
		} catch (ParseException e) {
			//Les valeurs utilis� lors du parse sont g�r� pr�alablement lors de la saisie alors on ne devrait jamais avoir un exception ici
			e.printStackTrace();
		}
		
		idPaiement = Paiement.createPaiement(new Paiement(modePaiement,prixTotal));
		
		Locations.setPaiementLocation(idPaiement);
		

	}

	// Fonction pour lister les locations en cours
	public static void listerLocations(ArrayList<Locations> l) {
		// L'ArrayList ne doit pas etre vide
		if (l.size() > 0) {

			System.out.println("");

			int espaceAllouerCompteur = 5;

			System.out.format("%-" + espaceAllouerCompteur + "s%-20s \n", "",
					String.format(Locations.affichageFormatage, "Id", "Noclient", "Date debut", "Date fin",
							"Code v�hicule", "Id Paiement"));
			System.out.println(
					"----------------------------------------------------------------------------------------------------");

			int compteur = 0;

			for (Locations eachLocations : l)
				System.out.format("%-" + espaceAllouerCompteur + "s%-20s \n", ++compteur, eachLocations.enListe());
		}

		// ArrayList Vide
		else
			System.out.println("Il n'y a aucune location en cours en ce moment");
	}

	// Fonction pour lister les v�hicules
	public static void listerVehicules(ArrayList<Vehicules> v) {
		// L'ArrayList ne doit pas etre vide
		if (v.size() > 0) {

			System.out.println("");

			int espaceAllouerCompteur = 5;

			System.out.format("%-" + espaceAllouerCompteur + "s%-20s \n", "", String
					.format(Vehicules.affichageFormatage, "Code v�hicule", "Marque", "Mod�le", "Ann�e", "Couleur", "�tat"));
			System.out.println(
					"---------------------------------------------------------------------------------------------------------");

			int compteur = 0;

			for (Vehicules eachVehicule : v)
				System.out.format("%-" + espaceAllouerCompteur + "s%-20s \n", ++compteur, eachVehicule.enListe());
		}

		// ArrayList Vide
		else
			System.out.println("Il n'y a aucune location en cours en ce moment");
	}

}
