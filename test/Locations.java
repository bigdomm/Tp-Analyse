/**
 * Classe location
 * 
 * Auteur: Vincent Gélinas
 * Date de création: 2016-04-11
 * 
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Locations{
	
	final public static String affichageFormatage = "%-17s%-17s%-17s%-22s%-18s%-26s";
	
	private int idLocation, idPaiement;
	private String dateDebut, dateFin, idClient, codeVehicule;
	private static ArrayList<Locations> arrayLocation = new ArrayList<Locations>();
	private static int incrementId = 1;
	
	//Constructeur location
	public Locations(String pIdClient){
		idLocation = incrementId++;
		idPaiement = 0;
		dateDebut =  dateFin = "";
		idClient = pIdClient;
		codeVehicule = "";
	}
	
	
	//retourne une liste de tous les locations
	public static ArrayList<Locations> getClient(){
		return arrayLocation ;
	}
	
	
	//Getters and setters
	public int getIdLocation() {
		return idLocation;
	}


	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}


	public int getIdPaiement() {
		return idPaiement;
	}


	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}


	public String getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}


	public String getDateFin() {
		return dateFin;
	}


	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	public String getIdClient() {
		return idClient;
	}


	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}


	public String getCodeVehicule() {
		return codeVehicule;
	}


	public void setCodeVehicule(String codeVehicule) {
		this.codeVehicule = codeVehicule;
	}
	
	//Fonction pour créer une nouvelle location
	public static void createLocation(Locations l) {
		arrayLocation.add(l);
	}
	
	public String enListe() {
		return String.format(affichageFormatage, this.idLocation, this.idClient, this.dateDebut, this.dateFin,
				this.codeVehicule, this.idPaiement);
	}
	
	public static ArrayList<Locations> getListeLocation() {
		return arrayLocation;
	}
		
	private static int getMaxId(){
		return incrementId - 1;
	}
	
	public static void setInfoLocation(String dateFin,String codeVehicule){
		Locations location;
		
		//On va chercher la derniere location créé
		location = arrayLocation.stream().filter(o -> o.getIdLocation() == getMaxId()).findFirst().get();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		location.setDateDebut(dateFormat.format(date));
		location.setDateFin(dateFin);
		location.setCodeVehicule(codeVehicule);
		
	}
	
	public static double calculMontantLocation() throws ParseException
	{
		final double montantDepot = 200;
		Locations location;
		Vehicules vehicule;
		double prixBase, prixLocation, prixApresTaxe, prixTotal;
		long duree;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDebut, dateFin;
		/*Calendar calDebut = Calendar.getInstance();
		Calendar calFin = Calendar.getInstance();*/

		location = arrayLocation.stream().filter(o -> o.getIdLocation() == getMaxId()).findFirst().get();
			
		dateDebut = dateFormat.parse(location.getDateDebut());
		dateFin = dateFormat.parse(location.getDateFin());
		
		/*calDebut.setTime(dateDebut);
		calFin.setTime(dateFin);*/
		
		
		//duree = calFin.DATE - calDebut.DATE;
		duree = dateFin.getDate() - dateDebut.getDate();
		
		//System.out.println("voici la durée entre les 2 jours : " + duree);
		
		vehicule = Vehicules.arrayVehicule.stream().filter(o -> o.getCodeVehicule().equals(location.getCodeVehicule())).findFirst().get();
		prixBase = vehicule.getPrixBase();
		prixLocation = duree * prixBase;
		
		//Mimique un adapteur de taxe
		if (!vehicule.isLuxe()){
			prixApresTaxe = prixLocation + (prixLocation * 0.15);
		}
		else{
			prixApresTaxe = prixLocation + (prixLocation * 0.20);
		}
		
		prixTotal = prixApresTaxe + montantDepot;
			
		
		return prixTotal;
		
		
	}
	
	public static void setPaiementLocation(int idPaiement){
		Locations location;
		//On va chercher la derniere location créé
		location = arrayLocation.stream().filter(o -> o.getIdLocation() == getMaxId()).findFirst().get();
		
		location.setIdPaiement(idPaiement);
		
	}

}
