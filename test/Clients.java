import java.util.ArrayList;

public class Clients extends Personne {

	final public static String affichageFormatage = "%-17s%-17s%-22s%-18s%-26s";
	private String permisAccom;
	private String idClient, permis, carte;
	private static ArrayList<Clients> arrayClient = new ArrayList<Clients>();

	// Constructeur client
	public Clients(String nom, String prenom, int dateNais, String permis, String carte) {
		super(nom, prenom, dateNais);
		this.permis = permis;
		this.carte = carte;
		this.idClient = idClient(this.getNom(), this.getPrenom(), this.getDateNais());
	}

	public Clients() {
		super("test", "test", 19601230);
	}

	// Get and set

	public String getPermis() {
		return permis;
	}

	public void setPermis(String permis) {
		this.permis = permis;
	}

	public String getCarte() {
		return carte;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setCarte(String carte) {
		this.carte = carte;
	}

	public String getPermisAccom() {
		return permisAccom;
	}

	public void setPermisAccom(String permisAccom) {

		this.permisAccom = permisAccom;
	}

	// end Get and set

	//Création de l'idclient avec une combinaison du nom,prénom et date de naissance
	public String idClient(String nom, String prenom, int dateNais) {
		String date = Integer.toString(dateNais);
		int i;

		if (nom.length() > 3) {
			i = 2;
		} else {
			i = nom.length();
		}
		return nom.substring(0, i) + prenom.substring(0, 1) + date.substring(0, 5);
	}

	// Ajout d'un client
	public static void createClient(Clients cl) {
		arrayClient.add(cl);
	}

	// Retourne une liste de tous les clients
	public static ArrayList<Clients> getClient() {
		return arrayClient;
	}

	// Retourne vrai si le client est present
	public static boolean isPresent(String permis) {
		return findClient(permis);
	}

	public static boolean findClient(String permis) {
		return arrayClient.stream().filter(o -> o.getPermis().equalsIgnoreCase(permis)).findFirst().isPresent();
	}

	public String enListe() {
		return String.format(affichageFormatage, this.idClient, super.getPrenom(), super.getNom(), super.getDateNais(),
				this.permis);
	}
	
	//Retourne l'identifiant du client avec son permis de conduire
	// Modification par : Vincent Gélinas
	// Date de modication : 2016-04-11
	public static String getIdClient(String permis) {
		Clients client;
		String idClient = "";

		client = arrayClient.stream().filter(o -> o.getPermis().equalsIgnoreCase(permis)).findFirst().get();
		idClient = client.getIdClient();

		return idClient;

	}

}
