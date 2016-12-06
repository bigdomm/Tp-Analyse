/*
 * Controleur de la gestion des clients
 * 
 * Auteur : Dominic Lafrance
 * 2016-04-02 
 * 
 * */
import java.util.ArrayList;

public class GestionnaireClient {
	final static String espaceEntreMenus = "\n\n\n";
	
	//ajout via le constructeur de client
	public static void ajoutClient(String nom,String prenom,int dateN,String permis,String carte){
		
		Clients.createClient(new Clients(nom,prenom,dateN,permis,carte));
	}
	
	//Recherche de la présence d'un client avec le permis de conduire (champ unique)
	public static boolean rechercherClient(String permis){
		
		return Clients.isPresent(permis);
	}
	
	//Non obligatoire mais lister les clients (tous les clients)
	public static void listerClients(ArrayList<Clients> c){
				//L'ArrayList ne doit pas etre vide  
				if(c.size() > 0){

					System.out.println("");

					//Marge a gauche réservé au compteur
					int espaceAllouerCompteur = 5;

					//Entete du tableau avec l'espace pour le compteur
					System.out.format("%-" + espaceAllouerCompteur + "s%-20s \n", "",String.format(Clients.affichageFormatage,"Numéro client","Prénom","Nom","Date naissance","Permis"));
					System.out.println("------------------------------------------------------------------------------------");

					
					int compteur = 0;
					
					//Affiche tous les clients
					for(Clients eachClient : c)
						System.out.format("%-" + espaceAllouerCompteur + "s%-20s \n", ++compteur, eachClient.enListe());
				}

				//ArrayList Vide
				else
					System.out.println("Il n'y a aucun client de contenu dans le système");
	}
	
	/* Non obligatoire, listage de tous les clients le permis entré, en cas d'aucune affichage, 
	 * le client n'est pas présent et peut donc être ajouté
	 */
	public static void listeRecherche(ArrayList<Clients> c,String permis){
		
		//L'ArrayList ne doit pas etre vide 
		if(c.size() > 0){
			
			//Création d'une arraylist temporaire pour ajouter le client ayant le même permis
			ArrayList<Clients> temp = new ArrayList<Clients>();

			for(Clients eachClient : c){
				if(eachClient.getPermis().equals(permis))
					temp.add(eachClient);
			}
				//Marge a gauche réservé au compteur
				int espaceAllouerCompteur = 5;
	
				//Entete du tableau avec l'espace pour le compteur
				System.out.format("%-" + espaceAllouerCompteur + "s%-20s \n", "",String.format(Clients.affichageFormatage,"Numéro client","Prénom","Nom","Date naissance","Permis"));
				System.out.println("------------------------------------------------------------------------------------");
	
				
				int compteur = 0;
				
				for(Clients e : temp)
					System.out.format("%-" + espaceAllouerCompteur + "s%-20s \n", ++compteur, e.enListe());
			}

		//ArrayList Vide
		else
			System.out.println("Il n'y a aucun client de contenu dans le système");
}
}
