package view;
import java.util.*;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import model.*;

// pour tester le projet

public class Test {
	public static void main(String args[]) throws Exception {
		
		UIManager.setLookAndFeel( new NimbusLookAndFeel() );
		
		// nom et adresse de la pizzaria
		String n = "Rapizza";
		String ad ="2 Avenue de la Rue Allee Boulevard   91999";
		
		// differentes recette pour les pizzas
		Vector<LigneRecette> recette1=new Vector<LigneRecette>();
		Vector<LigneRecette> recette2=new Vector<LigneRecette>();
		Vector<LigneRecette> recette3=new Vector<LigneRecette>();
		Vector<LigneRecette> recette4=new Vector<LigneRecette>();
		Vector<LigneRecette> recette5=new Vector<LigneRecette>();
		Vector<LigneRecette> recette6=new Vector<LigneRecette>();
		
		// ingredients de la pizzaria
		Vector<Ingredient> ingredient=new Vector<Ingredient>();
		
		// liste livreurs de la pizzaria
		Vector<Livreur> liv = new Vector<Livreur>();
			
		// liste des pizzas du catalogue de la pizzaria
		Vector<Pizza> liste = new Vector<Pizza>();
		
		// liste client de la pizzaria
		Vector<Client> cl = new Vector<Client>();
		
		// creation des ingredients
		Ingredient Tomate=new Ingredient("Tomate",100);
		Ingredient Fromage=new Ingredient("Fromage",100);
		Ingredient Chorizo=new Ingredient("Chorizo",100);
		Ingredient Lardon=new Ingredient("Lardon",100);
		Ingredient Merguez=new Ingredient("Merguez",100);
		Ingredient Poivron=new Ingredient("Poivron",100);
		Ingredient Poulet=new Ingredient("Poulet",1);
		
		// ajout a la liste des ingredients
		ingredient.add(Tomate);
		ingredient.add(Fromage);
		ingredient.add(Chorizo);
		ingredient.add(Lardon);
		ingredient.add(Merguez);
		ingredient.add(Poivron);
		ingredient.add(Poulet);
		
		// creation de differentes lignes recettes
		LigneRecette r1=new LigneRecette(8,Tomate);
		LigneRecette r2=new LigneRecette(4,Fromage);
		LigneRecette r3=new LigneRecette(4,Chorizo);
		LigneRecette r4=new LigneRecette(1,Lardon);
		LigneRecette r5=new LigneRecette(5,Merguez);
		LigneRecette r6=new LigneRecette(3,Poivron);
		LigneRecette r7=new LigneRecette(4,Tomate);
		LigneRecette r8=new LigneRecette(10,Fromage);
		LigneRecette r9=new LigneRecette(1,Poulet);
		
		// ajout des lignes recettes aux recettes
		recette1.add(r1);
		recette1.add(r2);
		recette2.add(r2);
		recette2.add(r5);
		recette2.add(r6);
		recette3.add(r8);
		recette3.add(r7);
		recette4.add(r4);
		recette4.add(r2);
		recette4.add(r1);
		recette4.add(r3);
		recette5.add(r1);
		recette5.add(r2);
		recette5.add(r3);
		recette5.add(r4);
		recette5.add(r5);
		recette5.add(r6);
		recette6.add(r9);
		
		// creation client
		Client c1 = new Client (909088,909);
		Client c2 = new Client (987687,	676);
		Client c3 = new Client (7,0);
		
		// ajout a la liste client
		cl.add(c1);
		cl.add(c2);
		cl.add(c3);
		
		// creation du catalogue avec liste des ingredients et des pizzas
		Catalogue cat = new Catalogue (liste);
		
		// creation de la pizzaria
		Pizzaria pi=new Pizzaria(n,ad,cat,cl,liv,ingredient);
		
		// creation des pizzas
		Pizza p1 = new Pizza ("Reine", 10,recette1,pi);
		Pizza p2 = new Pizza ("Oriental", 6,recette2,pi);
		Pizza p3 = new Pizza ("4 Fromage", 12,recette3,pi);
		Pizza p4 = new Pizza ("Classique", 8,recette4,pi);
		Pizza p5 = new Pizza ("Speciale", 20,recette5,pi);
		Pizza p6 = new Pizza ("Fermiere", 20,recette6,pi);
		
		// ajout des pizzas au catalogue de la pizzaria
		liste.add(p1);
		liste.add(p2);
		liste.add(p3);
		liste.add(p4);
		liste.add(p5);
		liste.add(p6);
		
		// creation des livreurs
		Livreur l1 = new Livreur ("Mouloud", "Quad", pi);
		Livreur l2 = new Livreur ("Mamadou", "Cross", pi);
		Livreur l3 = new Livreur ("Rachid", "Air Max", pi);
		Livreur l4 = new Livreur ("Enderson", "RER D", pi);
		
		// ajout des livreurs a la liste des livreurs de la pizzaria
		liv.add(l1);
		liv.add(l2);
		liv.add(l3);
		liv.add(l4);
		
		// lancement de l'interface graphique
		View1 f1= new View1(pi);
	}
}
