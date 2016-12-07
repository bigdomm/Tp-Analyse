/*
Application sur la gestion des clients (Cas #1)
M�thode principale : ajout d'un client et recherche de la pr�sence d'un client

j'ai impl�ment� volontairement des fonctionnalit�s sur les affichages des clients
qui ne sont pas contenu dans mes diagrammes.

Fait par : Dominic Lafrance
2016-04-02

La classe GestionnaireClient sert d'interm�diaire � l'appel direct
des m�thodes de la classe Clients. Sa pr�sence accentu la coh�sion et
d�coule du patron de conception Controleur.
*/

public class AjoutClient {
	public int nombre;
	public static void gestionClient(){
		int choix = 0;
		
		do {
			//menu principale
			choix = menuPrincipale();			
			switch (choix) {

				// Ajout d'un nouveau client
			case 1:
				ajout();
				break;

				// V�rifie la pr�sence d'un client dans le syst�me
			case 2:
				rechercheAvance();
				break;
				//Affiche une liste compl�te de tous les clients
			case 3:
				listerClient();
				break;
				//Retour au premier menu de gestion des deux cas
			case 4:
				Main.gestionMain();
				break;
			}

		} while (choix != 4);
	}

	
	//Menu principale de la gestion des clients
	private static int menuPrincipale() {

		
		System.out.println("----- Gestion client -----\n");
		System.out.println("1 - Ajouter un client");
		System.out.println("2 - V�rifier la pr�sence d'un client");
		System.out.println("3 - Lister les clients (compl�ment)");
		System.out.println("4 - Retour au menu principal");

		System.out.print("\nInscrivez le chiffre a la gauche de l'action d�sir� : ");

		//Scan d'un entier entre 1 et 5
		return ScanEntrer.scannerEntier(1, 4, "D�sol�, choix invalide!");

	}
	
	//Appel au gestionnaire pour ajouter un nouveau client avec validation de sa pr�sence avant
	//
		private static void ajout(){
			
			System.out.print("Entrez votre pr�nom : ");
			String prenom = ScanEntrer.regString();
			
			System.out.print("Entrez votre nom : ");
			String nom = ScanEntrer.regString();
			
			System.out.print("Entrez votre date de naissance(YYYYMMJJ) : ");
			int dateN = ScanEntrer.scannerEntier(19000101, 20161231,"Entrez une date valide");
			
			String permis;
			int i=-1;
			
			do{
				if(i >= 0){
					 System.out.println("Notre syst�me a d�tect� que le num�ro de permis est d�j� pr�sent.");
				 }
				
				 System.out.print("Entrez votre num�ro de permis : ");
				 permis = ScanEntrer.regString();
				 i++;
				 
			}while(Clients.isPresent(permis));
			
			System.out.print("Entrez votre num�ro de carte bancaire : ");
			String carte = ScanEntrer.regString();
			
			GestionnaireClient.ajoutClient(nom, prenom, dateN, permis, carte);
		}
		
		//Appel au gestionnaire pour la recherche avancer qui s'effectue sur le permis
		private static void rechercheAvance(){
			
			System.out.print("Entrez le num�ro de permis : ");
			String permis = ScanEntrer.regString();
			
			if(GestionnaireClient.rechercherClient(permis)) 
				GestionnaireClient.listeRecherche(Clients.getClient(),permis);	
			else 
				System.out.println("Il n'y a aucun client de contenu dans le syst�me avec ce num�ro de permis!");
				
			
		}
		
		//Appel du gestionnaire pour lister les clients
		private static void listerClient(){

			//Affiche la liste des clients de l'entreprise
			System.out.println(Main.espaceEntreMenus);
			System.out.println("----- Menu principale >> Lister les clients ----- ");
			GestionnaireClient.listerClients(Clients.getClient());
		}
}
