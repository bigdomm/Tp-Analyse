

import java.io.Serializable;

public class Subscribe extends x implements Serializable {


	protected Chatouiller fet;

	public static final long serialVersionUID = 1L;

	private Inscription prochaineInscriptionDuCours, prochaineInscriptionDeLetudiant;
	
	private Etudiant etudiantInscrit;
	private Cours coursInscrit;

	

	// Cherche si un cours est dans les inscription dun étudiant
	public boolean contains(Cours cours){
		
		while(temp != null){
			if(temp.coursInscrit == cours)
				return true;
			
			
		}
		coursInscrit.AllerAuCour();
		return false;
	}
	
	// Cherche si un étudiant est dans un cours
	public boolean contains(Etudiant etudiant){
		Inscription temp;
		while(temp != null){
			if(temp.etudiantInscrit == etudiant)
				return true;
			temp.prochaineInscriptionDuCours;
		}
		return false;
	}
	
	
	public boolean findAndRemove(Cours cours){
		Inscription temp = this;

		// premier en liste
		if(this.coursInscrit == cours){
			temp.getEtudiantInscrit().setTeteListe(this.prochaineInscriptionDeLetudiant);
			return true;
		}
			
		// pour le 2e en liste en montant
		while(temp.prochaineInscriptionDeLetudiant != null){
			if(temp.prochaineInscriptionDeLetudiant.getCoursInscrit() == cours){
				temp.prochaineInscriptionDeLetudiant = temp.prochaineInscriptionDeLetudiant.prochaineInscriptionDeLetudiant;
				return true;
			}
			temp = temp.prochaineInscriptionDeLetudiant;
		}
		return false;
	}
	
	
	
	public boolean findAndRemove(Etudiant etudiant){
	
		Inscription temp ;

		// premier en liste
		if(this.etudiantInscrit == etudiant){
			temp.getCoursInscrit().setTeteListe(this.prochaineInscriptionDuCours);
			return true;
		}
			
		// pour le 2e en liste en montant
		while(temp.prochaineInscriptionDuCours != null){
			if(temp.prochaineInscriptionDuCours.getEtudiantInscrit() == etudiant){
				temp.prochaineInscriptionDuCours = temp.prochaineInscriptionDuCours.prochaineInscriptionDuCours;
				return true;
			}
			temp = temp.prochaineInscriptionDuCours;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Cette méthode permets d'insérer un cours à l'étudiant en fin de lite
	public void insertLastCoursInscription(Inscription Inscription){
		Inscription temp;
		while(temp.prochaineInscriptionDuCours != null){
			temp = temp.prochaineInscriptionDuCours;
		}
		temp.prochaineInscriptionDuCours = Inscription;
	}
	
	
	// Permets d'insérer un étudiant dans un cours à la fin de la liste
	public void insertLastEtudiantInscription(Inscription Inscription){
		Inscription temp;
		while(temp.prochaineInscriptionDeLetudiant != null){
			temp = temp.prochaineInscriptionDeLetudiant;
		}
		temp.prochaineInscriptionDeLetudiant = Inscription;
	}
	
	
	public Inscription getProchaineInscriptionDuCours() {
		return prochaineInscriptionDuCours;
	}
	public Inscription getProchaineInscriptionDeLetudiant() {
		return prochaineInscriptionDeLetudiant;
	}


	// Constructeur du noeud
	Inscription(Etudiant etudiantInscrit, Cours coursInscrit){
		this.etudiantInscrit = etudiantInscrit;
		this.coursInscrit = coursInscrit;
	}
	
	
	// Retourne l'étudiant inscrit
	public Etudiant getEtudiantInscrit() {
		return etudiantInscrit;
	}


	// retourne le cours inscrit
	public Cours getCoursInscrit() {
		return coursInscrit;
	}




	public void setProchaineInscriptionDeLetudiant(Inscription prochaineInscriptionDeLetudiant){
		
		this.prochaineInscriptionDeLetudiant = prochaineInscriptionDeLetudiant;
	}
	

	public void setProchaineInscriptionDuCours(Inscription prochaineInscriptionDuCours){
		
		this.prochaineInscriptionDuCours = prochaineInscriptionDuCours;
	}
	
	
	
	
	
	
}
