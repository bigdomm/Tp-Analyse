package Grammaire;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Stack;

public class Collector {
	
	private int nb_public = 0;
	private int nb_private = 0;
	private int nb_protected = 0;
	private int nb_attribut = 0;
	private String nomClasse = "";
	private int attributPrimitif = 0;
	private int attributReference = 0;
	private boolean hasHeritage = false;
	private boolean hasInterface = false;
	private boolean hasHeritageMultiple = false;
	private String heriteFrom = "";
	private String Interface = "";
	
	Stack<String> stackAsso = new Stack<String>();
	Stack<String> stackMethod = new Stack<String>();
	
	ArrayList<String> assoRecurrency = new ArrayList<String>();
	ArrayList<method> listMethod = new ArrayList<method>();
	ArrayList<String> instanceDeClasseList = new ArrayList<String>();
	
	Hashtable<String, String> source = new Hashtable<String,String>();
	HashMap<String, String>  map = new HashMap<String, String>(source);
	HashMap<String, String>  instanceDeClasse = new HashMap<String, String>(source);
	HashMap<String, String>  typeNomMap = new HashMap<String, String>(source);
	
	public class method{
		public String nom = "";
		public String classe = "";
		public String methodeGeneral = "";
		
		public method(String n,String c,String genMethod){
			nom = n;
			classe = c;
			methodeGeneral = genMethod;
		}
	}

	public ArrayList<String> getAssoRecurrency() {
		return assoRecurrency;
	}

	public Stack<String> getStackAsso() {
		return stackAsso;
	}

	public int getNb_public() {
		return nb_public;
	}

	public boolean isHasInterface() {
		return hasInterface;
	}

	public void setHasInterface(boolean hasInterface) {
		this.hasInterface = hasInterface;
	}

	public String getInterface() {
		return Interface;
	}

	public void setInterface(String interface1) {
		Interface += interface1;
	}

	public void setNb_public() {
		this.nb_public++;
	}

	public int getNb_private() {
		return nb_private;
	}

	public void setNb_private() {
		this.nb_private++;
	}

	public int getNb_protected() {
		return nb_protected;
	}

	public void setNb_protected() {
		this.nb_protected++;
	}

	public int getNb_attribut() {
		return nb_attribut;
	}

	public void setNb_attribut() {
		this.nb_attribut++;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public int getAttributPrimitif() {
		return attributPrimitif;
	}

	public void setAttributPrimitif(int attributPrimitif) {
		this.attributPrimitif = attributPrimitif;
	}

	public int getAttributReference() {
		return attributReference;
	}

	public void setAttributReference(int attributReference) {
		this.attributReference = attributReference;
	}

	public boolean isHasHeritage() {
		return hasHeritage;
	}

	public void setHasHeritage(boolean hasHeritage) {
		this.hasHeritage = hasHeritage;
	}

	public boolean isHasHeritageMultiple() {
		return hasHeritageMultiple;
	}

	public void setHasHeritageMultiple(boolean hasHeritageMultiple) {
		this.hasHeritageMultiple = hasHeritageMultiple;
	}

	public String getHeriteFrom() {
		return heriteFrom;
	}

	public void setHeriteFrom(String heriteFrom) {
		this.heriteFrom += heriteFrom;
	}

	ArrayList < String > Type = new ArrayList < String > ();
	public ArrayList < String > typePrimitif = new ArrayList < String > ();

	public Collector(String n) 
	 {
	    this.nomClasse = n;
	  }

	  public String Pourcentage(double a)
	  {
	    DecimalFormat df = new DecimalFormat("#.##");
	    if(total() != 0)
	    	return String.valueOf(df.format(100 * (a / (total() - nb_attribut))));
	    else
	    	return String.valueOf(0);
	  }

	  public String PourcentageReference(double a)
	  {
	    DecimalFormat df = new DecimalFormat("#.##");
	    return String.valueOf(df.format(100 * (a / (total())))) + "%";
	  }

	  public int total()
	  {
	    return nb_public + nb_protected + nb_private + nb_attribut;
	  }

	  public void afficherAttributSimple()
	  {
		int Pri = 0;
		int Ref = 0;
		int nombre = 0;
	    for (Iterator < String > i = Type.iterator(); i.hasNext();)
	    {
	      String item = i.next();
	      nombre = 0;
	      for (Iterator < String > t = typePrimitif.iterator(); t.hasNext();)
	      {
	        String type = t.next();
	        if (item == type)
	        {
	          Pri++;
	          nombre++;
	        }
	      }
	      if (nombre == 0)
	      {
	    	  Ref++;
	        System.out.println("Attribut de référence : " + item);
	      }
	    }
	    System.out.println("Pourcentage d'attribut simple : " +
	    		Pri + "/" + total() + " = " +
	    PourcentageReference(Pri));
	    
	    System.out.println("Pourcentage d'attribut reference : " +
	    		Ref + "/" + total() + " = " +
	    PourcentageReference(Ref));}
	  
		public String getHeritage(){
		  
			if(hasHeritage) { 
				return heriteFrom.toString();
			}
			else
			{
		   		return "Aucune héritage";
			}
	  	}
	  public void ajoutTypePrimitif()
	  {
	    typePrimitif.add("short");
	    typePrimitif.add("int");
	    typePrimitif.add("double");
	    typePrimitif.add("float");
	    typePrimitif.add("byte");
	    typePrimitif.add("long");
	    typePrimitif.add("char");
	    typePrimitif.add("boolean");
	  }

}
