package Grammaire;


import init.ScanEntrer;
import init.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;



/*
 *Création d'un menu formater afin de pouvoir parcourir et obtenir ce que l'on désir 
 * 
 */
public class menuInterfaces {
	
	public static int menuPrincipale() {
		
		System.out.println("----- Menu principal -----\n");
		System.out.println("1 - Pourcentage des attributs - Numéro 1");
		System.out.println("2 - Attributs simple et référence - Numéro 2");
		System.out.println("3 - Héritage et association - Numéro 3");
		System.out.println("4 - Couplage entre classes - Numéro 4");
		System.out.println("5 - Appels direct - Numéro 5");
		System.out.println("6 - Quitter l'application");

		System.out.print("\nInscrivez le chiffre a la gauche de l'action désiré : ");

		// Scan d'un entier entre 1 et 6
		return ScanEntrer.scannerEntier(1, 6, "Désolé, choix invalide!");
	}
	
	public int listeClasses(ArrayList < Collector > Classes){
		int count = 0;
		System.out.println("------------------------------------------------------");
		for (Iterator < Collector > i = Classes.iterator(); i.hasNext();)
	      {
			count++;
	        Collector item = i.next();
	        item.typePrimitif.clear();
	        item.ajoutTypePrimitif();
	        System.out.println(count + " - " + item.getNomClasse());
	      }
		System.out.println("------------------------------------------------------");
		System.out.print("\nInscrivez le chiffre a la gauche de l'action désiré : ");
		return ScanEntrer.scannerEntier(1, count, "Désolé, choix invalide!");
	}
	
	public void numero1(Collector item){
			System.out.println("------------------------------------------------------");
	        System.out.println("Nombre d'attributs public : " + item.getNb_public());
	        System.out.println("Nombre d'attributs prives : " + item.getNb_private());
	        System.out.println("Nombre d'attributs protected : " + item.getNb_protected());
	        System.out.println("Nombre total d'attributs : " + item.total());
	        System.out.println("Pourcentage de public " + item.Pourcentage(item.getNb_public()) + "%");
	        System.out.println("Pourcentage de privee " + item.Pourcentage(item.getNb_private()) + "%");
	        System.out.println("Pourcentage de protected " + item.Pourcentage(item.getNb_protected()) + "%");
	        System.out.println("------------------------------------------------------");
	}
	
	public void numero2(Collector item){
		item.afficherAttributSimple();
	}
	
	public void numero3(Collector item){
		System.out.println("H\u00e9ritage : " + item.isHasHeritage());
        System.out.println("H\u00e9ritage Multiple : " + item.isHasHeritageMultiple());
        System.out.println("H\u00e9ritage de : " + item.getHeritage());
        System.out.println("A une interface : " + item.isHasInterface());
        if(item.isHasInterface()) {
			System.out.println("Interface(s) : " + item.getInterface());
        }
	}
	
	public void showAssoc(Collector a){
		Stack<String> stackAsso;
		ArrayList<String> references = new ArrayList<String>();
		stackAsso = a.getStackAsso();
		int size  = stackAsso.size();
		
		for (int ite = 0; ite < size ;ite++)
	    {
			String toShow = stackAsso.peek();
			boolean s = search.rechercheTypeReference(toShow,a);
			
			if(!stackAsso.isEmpty() && s){
				references.add(toShow);
			}
			stackAsso.pop();
		
	    }
		Set<String> printed = new HashSet<>();
		for (String s : references) {
		    if (printed.add(s))
		        System.out.println("Association avec " + s + " se produit " + Collections.frequency(references, s) + " fois");

		}
		if(references.isEmpty())
			    	System.out.println("Aucun association!");
	}
	
	
}

