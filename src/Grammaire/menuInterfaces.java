package Grammaire;


import init.ScanEntrer;
import init.diskFileExplorer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Grammaire.Collector.method;



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
		System.out.println("6 - Revenir en arrière");

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
	
	public void numero4(Collector a){
		System.out.println(a.instanceDeClasseList);
		
		System.out.println(a.instanceDeClasse);
		System.out.println(a.map);
		
	}
	/*public void numero4(Collector a){
		Iterator<String> keySetIterator = a.map.keySet().iterator();
		System.out.println(a.map);
		System.out.println(a.assoRecurrency);
		Set<String> set = new HashSet<String>() ;
        set.addAll(a.assoRecurrency) ;
        ArrayList<String> distinctList = new ArrayList<String>(set) ;

		while(keySetIterator.hasNext()){
		  int staticCall = 0;
		  int toShow = 0;
		  boolean lookahead = false;
		  String key = keySetIterator.next();

		  if(distinctList.contains(a.map.get(key)) && Collections.frequency(a.map.values(), a.map.get(key)) <= 1){
			  lookahead = true;
		  }
				if(distinctList.contains(key) || lookahead ){
					if(distinctList.contains(a.map.get(key))){
						staticCall = Collections.frequency(distinctList, a.map.get(key));
					}
					toShow = Collections.frequency(a.assoRecurrency, key)+ staticCall;
					System.out.println("La classe " + a.getNomClasse() + " appel " + toShow + " fois la classe " + a.map.get(key));
				}

		}



	}
	*/
	/*public void numero4(Collector a){

		System.out.println(a.map);
		System.out.println(a.assoRecurrency);
		
		Set<method> method = new HashSet<method>() ;
        method.addAll(a.listMethod) ;
        
        ArrayList<method> methodlist = new ArrayList<method>(method) ;
        ArrayList<String> methodTo = new ArrayList<String>();
		ArrayList<String> classes = new ArrayList<String>();
		
		Iterator<Grammaire.Collector.method> methodIterator = methodlist.iterator();
        Iterator<String> assoRecurrencyIterator = a.assoRecurrency.iterator();
		
		String classe = "";
		
		while(methodIterator.hasNext()){
			method m = methodIterator.next();
			methodTo.add(m.classe);
		}
		System.out.println("methode : " + methodTo);
		while(assoRecurrencyIterator.hasNext()){
			
			String type = assoRecurrencyIterator.next();
			
			if(a.map.containsValue(type) && !a.typePrimitif.contains(type)){
				classe = type;
				System.out.println(classe);
				classes.add(classe);
			}
			else if(a.map.containsKey(type) && !a.typePrimitif.contains(a.map.get(type))){
				classe = a.map.get(type);
				System.out.println(classe);
				classes.add(classe);
			}
		}
		if(!a.map.containsValue(a.assoRecurrency)){
			System.out.println("Appels static !");	
			
		}
		System.out.println(classes);
		
		Set<String> set = new HashSet<String>() ;
        set.addAll(methodTo) ;
        ArrayList<String> distinctList = new ArrayList<String>(set) ;
        Iterator<String> keySetIterator = distinctList.iterator();

		while(keySetIterator.hasNext()){
        	String key = keySetIterator.next();
        	System.out.println("La classe " + a.getNomClasse() + " appel " +
        	Collections.frequency(methodTo, key) + " la classe " + key);
        		classes.add(key);

        }
		set = new HashSet<String>() ;
        set.addAll(classes) ;
        
        ArrayList<String> classesNoDouble = new ArrayList<String>(set) ;
		/*for(int te = 0; te < classesNoDouble.size()-1;te++){
			System.out.println("La classe " + a.getNomClasse() + " appel " + Collections.frequency(classes, classesNoDouble.get(te)) + " fois la classe " + classesNoDouble.get(te));
		}
		
		int ite = 0;
		while(methodIterator.hasNext()){
			method m = methodIterator.next();
			
		}
		
	}*/
	/*public void numero4(Collector a){


		Set<String> set = new HashSet<String>() ;
        set.addAll(a.assoRecurrency) ;
        ArrayList<String> distinctList = new ArrayList<String>(set) ;
        Set<method> method = new HashSet<method>() ;
        method.addAll(a.listMethod) ;
        ArrayList<method> methodlist = new ArrayList<method>(method) ;

        Iterator<String> keySetIterator = distinctList.iterator();
        Iterator<Grammaire.Collector.method> methodIterator = methodlist.iterator();

        ArrayList<String> methodTo = new ArrayList<String>();

        int staticCall = 0;
        method type = null;

        while(methodIterator.hasNext()){
        	type = methodIterator.next();
        	methodTo.add(type.methodeGeneral);
        }
        while(keySetIterator.hasNext()){
        	staticCall = 0;
        	String key = keySetIterator.next();
        	if(methodIterator.hasNext()){
        		type = methodIterator.next();
        	}

        	if(Collections.frequency(methodTo, key) == 0 ){
        		if(distinctList.contains(key)){
					if(distinctList.contains(a.map.get(key))){
						staticCall = Collections.frequency(distinctList, a.map.get(key));
					}
					int toShow = Collections.frequency(a.assoRecurrency, key)+ staticCall;
					if (a.map.get(key)== null){

						System.out.println("La classe " + a.getNomClasse() + " appel " + toShow + " fois la classe " + key);   
					}
					if(!a.typePrimitif.contains(a.map.get(key))&& a.map.get(key)!= null){
						System.out.println("La classe " + a.getNomClasse() + " appel " + toShow + " fois la classe " + a.map.get(key));   
					}
				}
        	}
        }
	}*/

	public void numero5(Collector a){
		ArrayList<String> list = new ArrayList<String>() ;

		if(!a.instanceDeClasseList.isEmpty()){
			for (Iterator<method> t = a.listMethod.iterator(); t.hasNext();)
			{
				method type = t.next();

				if(a.map.get(type.classe)==null)
				{
					list.add("La méthode " + type.methodeGeneral + " de la classe " +
							a.getNomClasse() + " appel directement la classe " + type.classe + " via la méthode " + type.nom);
					//System.out.println();

				}
				else
				{
					list.add("La méthode " + type.methodeGeneral + " de la classe " +
							a.getNomClasse() + " appel directement la classe " + a.map.get(type.classe) + " via la méthode " + type.nom);
					//System.out.println();
				}
			}
		}
		else{
			System.out.println("Aucun appel direct pour la classe " + a.getNomClasse());
		}
		Set<String> set = new HashSet<String>() ;
		set.addAll(list) ;
		ArrayList<String> distinctList = new ArrayList<String>(set) ;

		for (Iterator<String> t = distinctList.iterator(); t.hasNext();)
		{
			String type = t.next();
			System.out.println(type);
		}

	}

	public String afficherDossier(String pathToExplore){
		diskFileExplorer diskFileExplorer = new diskFileExplorer(pathToExplore, true);
		Long start = System.currentTimeMillis();
		String choice = diskFileExplorer.list();
		System.out.println("----------");
		System.out.println("Analyse de " + pathToExplore + " en " + (System.currentTimeMillis() - start) + " mses");
		System.out.println(diskFileExplorer.filecount + " fichiers");
		System.out.println("------------------------");
		System.out.println("------------------------");

		return choice;
	}
}

