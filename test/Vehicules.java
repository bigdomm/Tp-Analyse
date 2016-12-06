
/**
 * Classe vehicule
 * 
 * Auteur: Vincent Gélinas
 * Date de création: 2016-04-11
 * 
 */

import java.util.ArrayList;

public class Vehicules {

	final public static String affichageFormatage = "%-17s%-17s%-17s%-22s%-18s%-26s";
	
	private Etat etat;
	private boolean isLuxe;
	private int capacite;
	private double prixBase;
	private String codeVehicule, marque, fabricant, annee, immatriculation, couleur;
	public static ArrayList<Vehicules> arrayVehicule = new ArrayList<Vehicules>();

	// Constructeur vehicule
	public Vehicules(String codeVehicule, String marque, String fabricant, int capacite, String annee,
			String immatriculation, String couleur, Etat etat, boolean isLuxe, double prixBase) {

		this.codeVehicule = codeVehicule;
		this.marque = marque;
		this.fabricant = fabricant;
		this.capacite = capacite;
		this.annee = annee;
		this.immatriculation = immatriculation;
		this.couleur = couleur;
		this.etat = etat;
		this.isLuxe = isLuxe;
		this.prixBase = prixBase;
	}

	//Getters et setters necessaires
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public String getCodeVehicule() {
		return codeVehicule;
	}

	public double getPrixBase() {
		return prixBase;
	}

	public void setPrixBase(double prixBase) {
		this.prixBase = prixBase;
	}

	public boolean isLuxe() {
		return isLuxe;
	}

	public void setLuxe(boolean isLuxe) {
		this.isLuxe = isLuxe;
	}

	// ajoute un véhicule
	public static void createVehicule(Vehicules v) {
		arrayVehicule.add(v);
	}

	// retourne une liste de tous les clients
	public static ArrayList<Vehicules> getListVehicule() {
		return arrayVehicule;
	}
	
	public String enListe() {
		return String.format(affichageFormatage, this.codeVehicule, this.fabricant, this.marque, this.annee,
				this.couleur, this.etat);
	}
	
	public static boolean findVehicule(String codeVehicule) {
		return arrayVehicule.stream().filter(o -> o.getCodeVehicule().equalsIgnoreCase(codeVehicule)).findFirst().isPresent();
	}
	
	public static boolean verifDispo(String codeVehicule){
		Vehicules vehicule;
		
		vehicule = arrayVehicule.stream().filter(o -> o.getCodeVehicule().equalsIgnoreCase(codeVehicule)).findFirst().get();
		
		if (vehicule.etat == Etat.LIBRE)
		{
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void reserver(String codeVehicule){
		Vehicules vehicule;
		
		vehicule = arrayVehicule.stream().filter(o -> o.getCodeVehicule().equalsIgnoreCase(codeVehicule)).findFirst().get();
		
		vehicule.setEtat(Etat.ENLOCATION);
		
	}
	
	public enum Etat {
		LIBRE, ENLOCATION, RESERVER, ENDOMMAGE
	}
}
