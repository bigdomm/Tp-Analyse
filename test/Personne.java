
public class Personne {
	private String nom,prenom,ville,adresse,telephone;
	private int dateNais;
	
	public Personne(String nom,String prenom,int dateNais){
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getDateNais() {
		return dateNais;
	}

	public void setDateNais(int dateNais) {
		this.dateNais = dateNais;
	}
	
	public String toString() {
		
		return this.nom + " " + this.prenom;
	} 
		
	
}
