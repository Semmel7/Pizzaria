package model;
import java.util.*;

public class Pizza {

    public String nom;

    public double prix;
    
    public Vector<LigneRecette> listRecette;
    
    public Pizza(String n,double p,Vector<LigneRecette> lr, Pizzaria pi) {
    	nom = n;
    	prix= p;
    	listRecette=lr;
    }
    
    public String Possible() {
    // verifie si une pizza est faisable
    	
    	for(int i=0;i<listRecette.size();i++) {
    		if(listRecette.get(i).ing.qt>=listRecette.get(i).qt) {
    			listRecette.get(i).ing.suppqt(listRecette.get(i).qt);
    			continue;
    		}else {
				return "il manque "+listRecette.get(i).ing.nom+" pour la pizza "+nom;
			}
		}
    	return "oui";
    }
       
    public Vector<Ingredient> getIng(){
    // renvoie les ingredients d une pizza
    
    	Vector<Ingredient> ingt=new Vector<Ingredient>();
    	for(int i=0;i<listRecette.size();i++){
    	    ingt.add(listRecette.get(i).ing);
    	}
    	return ingt;
    }
}