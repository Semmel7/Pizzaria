package model;
import java.util.*;

public class Pizzaria {
    
	public Catalogue cat;
    
    public double ca = 0.0;
    
    public String nom;

    public String adresse;
    
    public Vector<Client> listClient;
    
    public Vector<Livreur> listLivreur;
   
    public Vector<Ingredient> listIngredient;
    
    public Pizzaria(String n, String ad,Catalogue c,Vector<Client> cl, Vector<Livreur> ll,Vector <Ingredient> li) {
    	listIngredient=li;
    	nom = n ;
    	adresse = ad;
    	cat = c;
    	listClient=cl;
    	listLivreur=ll;
    }
    
    public void ajouterClient(Client c) {
    // ajoute un client a la liste des clients
    	
    	listClient.add(c);
    }
    
    public void suppClient(Client c) {
    // supprime un client de la liste des clients
    	
    	listClient.remove(c);
    	ca=ca+c.getchiffreAffaire(); // on recupere le ca du client supprimer
    }
    
    public void ajouterIngredient(Ingredient i) {
    // ajoute un ingredient a la liste des ingredients
    	
    	listIngredient.add(i);
    }
    
    public void suppIngredient(Ingredient i) {
    // supprime un ingredient a la liste des ingredients
    	
    	listIngredient.remove(i);
    }
   
    public void ajouterLivreur(Livreur l) {
    // ajoute un livreur a la liste des livreurs
    	
    	listLivreur.add(l);
    }
    
    public void suppLivreur(Livreur l) {
    // supprime un livreur a la liste des livreurs
    	
    	listLivreur.remove(l);
    }
    
    public double CA() {
    //calcule le chiffre d'affaire de la pizzaria
   
    	double somme=0;
    	for(int i=0;i<listClient.size();i++){
    		somme=somme+listClient.get(i).getchiffreAffaire();
    	}
    	return somme+ca;
    }
   
    public boolean LivreurExiste(String name) {
    //verifie si le livreur existe dans la base de donnee (par le nom)
    
    	for(int i=0;i<listLivreur.size();i++){
    	    if(listLivreur.get(i).nom.equals(name)){
    	        return true;
    	    }
    	}
    	return false;
    }
    public boolean LivreurExistet(String transp) {
    //verifie si le livreur existe dans la base de donnee (par le transport)
    	
    	for(int i=0;i<listLivreur.size();i++){
    	    if(listLivreur.get(i).transport.equals(transp)){
    	        return true;
    	    }
    	}
    	return false;
    }
    
    public Livreur TransportNom(String nom_trans) {
    // renvoie le livreur dont le nom et le transport sont donne en parametre
    	
    	for(int i=0;i<listLivreur.size();i++){
    	    if((listLivreur.get(i).nom+" "+listLivreur.get(i).transport).equals(nom_trans)){
    	        return listLivreur.get(i);
    	    }
    	}
    	return null;  	
    }
    
    public Client ClientExiste(int id) {
    //renvoie le client dont le numero est donne en parametre
    	
    	for(int i=0;i<listClient.size();i++){
    	    if(listClient.get(i).num==id){
    	        return listClient.get(i);
    	    }
    	}
    	return null;
    }
    
    public Ingredient IngredientExiste(String nom) {
    //renvoie l'ingredient dont le nom est donne en parametre
    
    	for(int i=0;i<listIngredient.size();i++){
    	    if(listIngredient.get(i).nom.equals(nom)){
    	        return listIngredient.get(i);
    	    }
    	}
    	return null;
    }
   
    public int fidelite(Client c) {
    // renvoie le nombre de pizza gratuite dont un client est eligible
    	
    	return (int)((c.points_fidelite)/10);
    }
}
