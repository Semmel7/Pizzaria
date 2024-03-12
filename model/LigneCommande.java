package model;


public class LigneCommande {
   
    public int qt;

    public String taille;
    
    public Commande listCom;
    
    public Pizza pizza;
   
    public LigneCommande(int q,String t,Pizza p,Commande c) {
    	qt = q;
    	taille = t;
    	pizza=p;
    	listCom=c;
    
    }    
   
    public double calcPrix() {
    //calcule le prix de la lignes de commandes
    
    	double result=pizza.prix;
    	if(taille.equals("naine")){
    		result=((result)*2/3)*qt;   
    	}
    	if(taille.equals("humaine")){
    		result=result*qt;
    	}
    	if(taille.equals("ogresse")){
    		result=(result*4/3)*qt;
    	}
    	return result;
    }
    
    public String lnComPossible() {
    // verifie si la ligne de commande est faisable
    	
    	for(int i=0;i<qt;i++) {
    		if(pizza.Possible().equals("oui")) {
    			continue;
    		}else {
    			return pizza.Possible();
    		}
    	}
    	return "oui";
    }
}
    
