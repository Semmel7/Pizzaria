package model;
import java.util.*;

public class Catalogue {
	
	public Vector<Pizza> liste;
	
	public Catalogue(Vector<Pizza> l) {
    	liste=l;
    }
        
	public void ajouterPizza(Pizza p) {
	// ajoute une pizza au catalogue
    	
		liste.add(p);
    }
		
    public void suppPizza(Pizza p) {
    // supprime une pizza du catalogue	
    	
    	liste.remove(p);
    }
	
    public Pizza byname(String name) {
	// retourne une pizza dont le nom est entre en parametre	
		
    	for(int i = 0;i<liste.size();i++) {			
			if(name.equals(liste.get(i).nom) ) {
				Pizza pi = liste.get(i);
				return pi;
			}			
		}    	
    	return null;
    }
	
	public Vector<Pizza> getPizza(Ingredient ing) {
	//filtre les pizzas par ingredient
		
		Vector<Pizza> pizzaFilter=new Vector<Pizza>();
		for(int i=0;i<liste.size();i++){
		    if(liste.get(i).getIng().contains(ing)){
		        pizzaFilter.add(liste.get(i));
		    }
		}
		return pizzaFilter;
	}
	
	
}