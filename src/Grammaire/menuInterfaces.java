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

		Set<method> method = new HashSet<method>() ;
        method.addAll(a.listMethod) ;
        ArrayList<method> methodlist = new ArrayList<method>(method) ;
        
        Iterator<Grammaire.Collector.method> methodIterator = methodlist.iterator();
        ArrayList<String> classExeptYou = new ArrayList<String>() ;
        a.instanceDeClasse.clear();
        
        //showing class with extension (no extension = calling intern function)
        while(methodIterator.hasNext()){
        	method m = methodIterator.next();
        	//To do - ne pas afficher et compter le nombre d'appel si c'est ta propre classe
        	if(!a.typeNomMap.containsKey(m.classe) && !a.map.get(m.classe).equals(a.getNomClasse())){
        		if(a.map.containsKey(m.classe)){
            		classExeptYou.add(a.map.get(m.classe));
            		a.instanceDeClasse.put(a.map.get(m.classe), "Class");
            	}else{
            		classExeptYou.add(m.classe);
            		a.instanceDeClasse.put(m.classe, "Class");
            	}
        	}
        }
        Iterator<String> instanceDeClasseIterator = a.instanceDeClasse.keySet().iterator();
        
        while(instanceDeClasseIterator.hasNext()){
        	String t = instanceDeClasseIterator.next();
        	System.out.println("La classe " + a.getNomClasse() + " appel " + Collections.frequency(classExeptYou, t) + " fois la classe " + t);
        	
        }
        
        if(a.instanceDeClasse.isEmpty()){
        	System.out.println("Il n'y a aucun appel direct pour la classe " + a.getNomClasse());
        }


	}

	public void numero5(Collector a){
		ArrayList<String> list = new ArrayList<String>() ;
		System.out.println(a.map);
		System.out.println(a.typeNomMap);
		System.out.println(a.instanceDeClasseList);
		
		if(!a.instanceDeClasseList.isEmpty() || !a.map.isEmpty()){
			for (Iterator<method> t = a.listMethod.iterator(); t.hasNext();)
			{
				method type = t.next();
				System.out.println("Map : " + a.map.get(type.classe) + "nom classe : " + a.getNomClasse());
				if(!a.typeNomMap.containsKey(type.classe) ){
					
					if(a.map.get(type.classe)==null && !type.classe.equals(a.getNomClasse()))
					{
						list.add("La méthode " + type.methodeGeneral + " de la classe " +
								a.getNomClasse() + " appel directement la classe " + type.classe + " via la méthode " + type.nom);
						//System.out.println();

					}
					else
					{
						if(!a.map.get(type.classe).equals(a.getNomClasse()))
						list.add("La méthode " + type.methodeGeneral + " de la classe " +
								a.getNomClasse() + " appel directement la classe " + a.map.get(type.classe) + " via la méthode " + type.nom);
					}
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
		
		if(distinctList.isEmpty())
			System.out.println("Aucun appel direct pour la classe " + a.getNomClasse());
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

