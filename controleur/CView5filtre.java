package controleur;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import model.Client;
import model.Pizzaria;
import model.Pizza;
import model.Ingredient;
import view.View5c;

public class CView5filtre implements ActionListener {
	
	JComboBox<String> fil;
		
	Client client;
	
	Pizzaria piz;
	
	Vector<Pizza> lpizza;
	
	View5c v5c;
	
	public CView5filtre(JComboBox<String> jc,Client cl,Pizzaria pi,Vector<Pizza> lp,View5c v5) {				
		fil=jc;
		client = cl;
		piz=pi;
		lpizza=lp;
		v5c=v5;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// nom de l'ingredient selectionne
		String ning=fil.getSelectedItem()+"";
		
		// si on a selectionne restore
		if(ning.equals("Restore")) {
			
			// on raffiche la page avec toutes les pizzas du catalogue
			Vector<Pizza> lpizza=piz.cat.liste;
			v5c.dispose();
			View5c v5=new View5c(client,piz,lpizza);
			v5.show();
		}else {
			
			// sinon, on recupere l'ingredient selectionne
			Ingredient ingredient=piz.IngredientExiste(ning);
			
			// on ajoute au vector pizza toutes les pizzas du catalogue qui contiennent l'ingredient selectionne
			Vector<Pizza> lpizza=piz.cat.getPizza(ingredient);
			
			// on raffraichi la page
			v5c.dispose();
			View5c v5=new View5c(client,piz,lpizza);
			v5.show();
		}
	}
}
