package model;
import java.util.*;
import java.lang.Double;

public class Commande {

    public Client client;

    public Livreur livreur;

    public Vector<LigneCommande> lnCom=new Vector<LigneCommande> ();
    
    public Pizzaria piz;
    
    public Commande(Client c,Pizzaria p,Vector <LigneCommande> lc) {
    	client = c;
    	piz=p;
    	livreur = choisirLivreur();
    	lnCom=lc;
    }
    
    public boolean solde() {
        // verifie que le client qui passe la commande a un solde suffisant
    		
        	if(Double.compare(client.solde,Prix())<0) {
        	return false;
    		}else {
    			return true;
    		}
        }
    
    public Livreur choisirLivreur() {
    // choisit aleatoirement un livreur pour livrer la commande
    	
    	int index = (int)(Math.random() * piz.listLivreur.size());   	
    	return piz.listLivreur.get(index);   	
    }
    
    public void ajouterLigneCommande(LigneCommande c) {
    // ajouter une ligne commande
    	
    	lnCom.add(c);
    }
    
    public void retirerLigneCommande(LigneCommande c) {
    // retirer une ligne commande
    	
    	lnCom.remove(c);
    }
   
    public double Prix() {
    //calcule le prix totale de la commande
    
    	double total=0;
    	for(int i=0;i<lnCom.size();i++){
    		total=total+lnCom.get(i).calcPrix();
    	}
    	return total;	
    }
    
    public int nbPizza() {
    //calcule le nombre de pizza commander par le client
    	
    	int nb=0;
    	for(int i=0;i<lnCom.size();i++){
    		nb=nb+lnCom.get(i).qt;
    	}
    	return nb;
    }
    
    public String Faisable() {
    // verifie si une commande est faisable
    	
    	for(int i=0;i<lnCom.size();i++) {
    		if(lnCom.get(i).lnComPossible().equals("oui")) {
    			continue;
    		}else {
    			return lnCom.get(i).lnComPossible();
    		}
    	}
    	return "oui";
    }
}
    
    
    

