
/**
 * Classe paiement
 * 
 * Auteur: Vincent G�linas
 * Date de cr�ation: 2016-04-12
 * 
 */

import java.util.ArrayList;

public class Paiement {

	final public static String affichageFormatage = "%-17s%-17s%-18s%-26s";
	
	private int idPaiement;
	private double prixTotal;
	private String modePaiement;
	private static int incrementId = 1;
	public static ArrayList<Paiement> arrayPaiement = new ArrayList<Paiement>();

	// Constructeur Paiement
	public Paiement(String pModePaiement, double pPrixTotal) {

		this.idPaiement = incrementId++;
		this.modePaiement = pModePaiement;
		this.prixTotal = pPrixTotal;
	}


	//Getters et setters 
	public int getIdPaiement() {
		return idPaiement;
	}

	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public String getModePaiement() {
		return modePaiement.toString();
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	//Fonction pour cr�er un paiement
	public static int createPaiement(Paiement p) {
		arrayPaiement.add(p);
		
		return p.getIdPaiement();
	}

	
}
