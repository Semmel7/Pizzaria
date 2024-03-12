package model;
import java.util.*;

public class Livreur {

    public String nom;

    public String transport;

    public Pizzaria pizzaria;
    
    public Vector<Commande> listCom=new Vector<Commande>();

    public Livreur(String n , String t,Pizzaria p) {
    	nom = n;
    	transport= t;
    	pizzaria = p;
    }
    
    public void ajouterCommande(Commande c) {
    // ajoute une commande a la liste de commande du livreur
    	
    	listCom.add(c);
    }
}