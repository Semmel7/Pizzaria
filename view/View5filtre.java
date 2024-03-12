package view;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Vector;
import model.Client;
import model.Pizza;
import model.Pizzaria;
import controleur.CView5filtre;

// sous affichage pour filtrer les pizzas 

public class View5filtre extends JInternalFrame {
	
	Client client;
	
	Pizzaria piz;
	
	Vector<Pizza> lpizza;
	
	JComboBox<String> filtre;
	
	JButton v=new JButton("Filtrer");

	View5c v5c;
	
	public View5filtre(Client cl,Pizzaria pi,Vector<Pizza> lp,View5c v5) {
		client =cl;		
		piz=pi;
		lpizza=lp;
		v5c=v5;
		
		this.setTitle("Filtre");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(0,350);
		
		Vector<String> ingPiz=new Vector<String>();
		for(int i = 0 ; i <piz.listIngredient.size();i++) {
			ingPiz.add(piz.listIngredient.get(i).nom);
		}
		ingPiz.add("Restore");
		
		LinkedHashSet<String> ing= new LinkedHashSet<String>(ingPiz);
		ingPiz.clear();
		ingPiz.addAll(ing);
		
		filtre= new JComboBox<String>(ingPiz);	
		
		CView5filtre a=new CView5filtre(filtre,client,piz,lpizza,v5c);
		
		GridLayout g=new GridLayout(1,2);
		
		v.addActionListener(a);
		
		this.setLayout(g);
		this.add(filtre);
		this.add(v);
		this.setSize(250,60);
		this.show();
	}
}
