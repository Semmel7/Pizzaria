package model;
import java.util.*;

public class Client {

    public int num;

    public int nbCommande=0;
    
    public int points_fidelite=0;

    public double solde;
    
    public Vector<Commande> listCom= new Vector<Commande>();
   
    public Client(int n,double s) {
    	num=n;
    	solde=s;
    }
    
    public void ajouterCom(Commande c) {
    // ajoute une commande a la liste de commande
    	
    	listCom.add(c);
    }
    
    public double getchiffreAffaire() {
    //return le chiffre d affaire du client
    	
    	double ca=0;
    	for(int i=0;i<listCom.size();i++){
    	    ca=ca+listCom.get(i).Prix(); 
    	}
    	return ca;
    }
    
    public Vector<Commande> getCom(int n) {
    //renvoie la liste des n derniere commandes du client
    	
    	Vector<Commande> listComClient=new Vector<Commande>();
    	if (n>listCom.size()) {
    		n=listCom.size();
    	}
    	
    	for(int i=listCom.size()-1;i>=0;i--){
    	        listComClient.add(listCom.get(i));
    	        if(listComClient.size()==n) {
    	        	return listComClient;
    	        }
    	}
    	
    	return listComClient;
    }
      
    public void cred(double c) {
    // credite sur le compte du client une certaine somme
    	
    	solde = solde+c;
    }
}