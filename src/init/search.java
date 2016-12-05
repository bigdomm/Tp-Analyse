package init;

import java.util.Iterator;
import java.util.Stack;

import Grammaire.Collector;

public class search {
	
	public static boolean rechercheTypeReference(String toSearch, Collector a){
	      int nombre = 0;
	     
	      for (Iterator < String > t = a.typePrimitif.iterator(); t.hasNext();)
	      {
	        String type = t.next();
	        if (toSearch == type)
	        {
	          nombre++;
	        }
	      }
	      if (nombre == 0)
	      {
	        return true;
	      }
	      else{
	    	return false;  
	      }    
	}
	
	public static boolean rechercheDuplicateAssoc(String toSearch,Stack<String> s){
	      int nombre = 0;
	     
	      for (Iterator < String > t = s.iterator(); t.hasNext();)
	      {
	    	  String item = t.next();
	    	  if(toSearch.equalsIgnoreCase(item))
	    	  {
	    		  nombre++;
	    		  
	    	  }
	      }
	      if (nombre == 0)
	      {
	        return true;
	      }
	      else{
	    	return false;  
	      }    
	}
}
