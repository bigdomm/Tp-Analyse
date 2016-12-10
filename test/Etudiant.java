

import java.io.Serializable;
import java.util.ArrayList;

public class Etudiant implements Comparable<Etudiant>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Informations de l'étudiant
	private String codePermanent, nom, prenom;	
	private int creditsAccumules;
	public int getCreditsAccumules() {
		return creditsAccumules;
	}


	public void setCreditsAccumules(int creditsAccumules) {
		this.creditsAccumules = creditsAccumules;
	}


	public double getMoyenneCumulative() {
		return moyenneCumulative;
	}


	public void setMoyenneCumulative(double moyenneCumulative) {
		this.moyenneCumulative = moyenneCumulative;
	}


	private double moyenneCumulative;
	

	private Inscription teteListe;
	
	
	
	public Inscription getTeteListe() {
		return teteListe;
	}


	public void setTeteListe(Inscription teteListe) {
		this.teteListe = teteListe;
	}

	
	public ArrayList<Cours> getCoursSuivisReussi() {
		return coursSuivisReussi;
	}


	// Cours suivi et réussi par le passé par l'étudiant
	private ArrayList<Cours> coursSuivisReussi = new ArrayList<Cours>();

	
	
	/* 
	 * 
	 * Constructeurs
	 * 
	 */


	
	public Etudiant(String codePermanent, String nom, String prenom) {
		this.codePermanent = codePermanent;
		this.nom = nom;
		this.prenom = prenom;
		this.creditsAccumules = 0;
		this.creditsAccumules = 0;
	}
	
	public Etudiant(String codePermanent, String nom, String prenom,
			int creditsAccumules, double moyenneCumulative) {
		this.codePermanent = codePermanent;
		this.nom = nom;
		this.prenom = prenom;
		this.creditsAccumules = creditsAccumules;
		this.moyenneCumulative = moyenneCumulative;
	}

	

	
	public String getCodePermanent(){
		return codePermanent;
	}


		
	
	
	public int compareTo(Etudiant comparable){
		
		return this.nom.compareTo(comparable.getCodePermanent());
	}


	public String getPrenom() {
		// TODO Auto-generated method stub
		return prenom;
	}


	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}
	
	

}
