package controleur;
import java.awt.event.*;
import model.Ingredient;
import model.Pizzaria;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import view.View4p;
import view.View4pia;

public class CView4pia implements ActionListener{
	
	JTextField j1;
	
	JTextField j2;
	
	JLabel jLabel;
	
	View4pia v;
	
	JPanel jp;
	
	Vector<Ingredient> lii;
	
	Pizzaria piz;
	
	Vector <JLabel> jla = new Vector <JLabel>();
	
	public CView4pia (JTextField t1, JTextField t2, View4pia vi, JPanel jpa, Vector<Ingredient> li, Pizzaria p) {
		j1=t1;
		j2=t2;
		v=vi;
		jp=jpa;
		lii=li;
		piz=p;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals("Valider")) {
			
			// on cree un ingredient
			Ingredient ing = new Ingredient(j1.getText(),Integer.parseInt(j2.getText()));
			
			// on l'ajoute a la liste des ingredients que l'on veut ajouter
			lii.add(ing);
			
			// on cree un JLabel1 qui va corespondre a l'ingredient que l'on vient d'entrer 
			jLabel=new JLabel(j1.getText()+" "+j2.getText());
			
			// on ajoute le jlabel au vector et au panel
			jla.add(jLabel);
			jp.add(jla.get(jla.size()-1));
			
			// puis on met a jour le panel
			SwingUtilities.updateComponentTreeUI(jp);			
		}
		
		if(((JButton)e.getSource()).getText().equals("Ajouter")) {
			if(lii.isEmpty()==false) {
				
				// on parcoure la liste des ingredients que l'on veut ajouter
				for(int i=0;i<lii.size();i++) {
					
					// si le i eme ingredient n'existe pas on l'ajoute a la liste d'ingredient de la pizzaria
					if(piz.IngredientExiste(lii.get(i).nom)==null){
							piz.ajouterIngredient(lii.get(i));
					}else {
						// si l'ingredient existe on reapprovisionne le stock
						piz.IngredientExiste(lii.get(i).nom).qt=piz.IngredientExiste(lii.get(i).nom).qt+Integer.parseInt(j2.getText());
					}
				}
				
				// on ferme la page et on la reouvre avec l'actualisation de la liste ingredient 
				v.v1.dispose();
				View4p c=new View4p(piz);
				c.show();
			}
		}
		
		if(((JButton)e.getSource()).getText().equals("Annuler")) {
			if(lii.isEmpty()==false) {
				
				// on retire de la liste des ingredients a ajouter le dernier ingredient que l'on a ajouter
				lii.remove(lii.get(lii.size()-1));
				
				// on retire du jpanel le dernier jlabel
				jp.remove(jla.get(jla.size()-1));
				
				// et on retire de la liste des jlabel le dernier element
				jla.remove(jla.size()-1);
				
				// on met a jour l'affichage du panel
				SwingUtilities.updateComponentTreeUI(jp);
			}
		}	
	}
}
