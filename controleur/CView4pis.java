package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import view.View4p;
import view.View4pis;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.Ingredient;
import model.Pizzaria;

public class CView4pis implements ActionListener{
	
	JComboBox<String> jt;
	
	JLabel jl;
	
	JPanel jp;
	
	View4pis v1;
	
	Pizzaria piz;
	
	Vector<Ingredient> sup = new Vector<Ingredient>();
	
	Vector<JLabel> jla = new Vector<JLabel>();
	
	public CView4pis (JComboBox<String> co, View4pis vi1, Pizzaria p, JPanel j) {
		jt=co;
		v1=vi1;
		piz=p;
		jp=j;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals("Select")) {
			
			// on ajoute au vector jlabel j1 correspondant a l'ingredient selectionne
			jl=new JLabel(jt.getSelectedItem()+"");
			jla.add(jl);
			
			// on parcoure la liste des ingredients
			for(int i=0;i<piz.listIngredient.size();i++) {
				
				// si lingredient selectionne correspond au i eme ingredient de la liste
				if(jl.getText().equals(piz.listIngredient.get(i).nom)) {
					
					// on l'ajoute dans la liste des ingredients a supprimer, puis on quitte la boucle
					sup.add(piz.listIngredient.get(i));
					break;
				}
			}
			
			// on rajoute au panel le dernier element ajouter dans le vector jla, puis on le raffraichi
			jp.add(jla.get(jla.size()-1));
			SwingUtilities.updateComponentTreeUI(jp);
		}
		
		if(((JButton)e.getSource()).getText().equals("Supprimer")) {
			if(sup.isEmpty()==false) {
				
				// on parcoure la liste des ingredients a supprimer
				for(int j=0;j<sup.size();j++) {
					
					// puis on supprime les les ingredients de la liste ingredient de la pizzaria
					piz.suppIngredient(sup.get(j));
					
					// si une pizza contient l'ingredient a supprimer, on supprime aussi la pizza du catalogue
					for(int i=0;i<piz.cat.liste.size();i++) {
						if(piz.cat.liste.get(i).getIng().contains(sup.get(j))) {
							piz.cat.liste.remove(piz.cat.liste.get(i));
							i=0;
						}
					}
				}
				
				// on ferme et on raffiche la page apres modification de la liste
				v1.v.dispose();
				View4p c=new View4p(piz);
				c.show();
			}
		}
		
		if(((JButton)e.getSource()).getText().equals("Annuler")) {
			if(sup.isEmpty()==false) {
				
				// on retire de la liste des ingredients a supprimer le dernier ingredient que l'on a ajouter
				sup.remove(sup.get(sup.size()-1));
				
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
