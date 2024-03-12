package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import view.View4p;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.Pizzaria;
import model.Pizza;
import view.View4ps;

public class CView4ps implements ActionListener{
	
	JComboBox<String> jt;
	
	JLabel jl;
	
	JPanel jp;
	
	View4ps v1;
	
	Pizzaria piz;
	
	Vector<Pizza> sup = new Vector<Pizza>();
	
	Vector<JLabel> jla = new Vector<JLabel>();
	
	public CView4ps (JComboBox<String> co, View4ps vi1, Pizzaria p, JPanel j) {
		jt=co;
		v1=vi1;
		piz=p;
		jp=j;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(((JButton)e.getSource()).getText().equals("Select")) {
			
			// on ajoute au vector jlabel j1 correspondant a la pizza selectionne
			jl=new JLabel(jt.getSelectedItem()+"");
			jla.add(jl);
			
			// on parcoure la liste des pizzas
			for(int i=0;i<piz.cat.liste.size();i++) {
				
				// si le pizza selectionne correspond a la i eme pizza de la liste
				if(jl.getText().equals(piz.cat.liste.get(i).nom)) {
					
					// on l'ajoute dans la liste des pizzas a supprimer, puis on quitte la boucle
					sup.add(piz.cat.liste.get(i));
					break;
				}
			}
			
			// on rajoute au panel le dernier element ajouter dans le vector jla, puis on le raffraichi
			jp.add(jla.get(jla.size()-1));
			SwingUtilities.updateComponentTreeUI(jp);
		}
		
		if(((JButton)e.getSource()).getText().equals("Supprimer")) {
			if(sup.isEmpty()==false) {
				
				// on parcoure la liste des pizzas a supprimer
				for(int j=0;j<sup.size();j++) {
					
					// puis on supprime les pizzas de la liste pizza du catalogue de la pizzaria
					piz.cat.suppPizza(sup.get(j));
				}
				
				// on ferme et on raffiche la page apres modification de la liste
				v1.v.dispose();
				View4p c=new View4p(piz);
				c.show();
			}		
		}
		
		if(((JButton)e.getSource()).getText().equals("Annuler")) {
			if(sup.isEmpty()==false) {
				
				// on retire de la liste des pizzas a supprimer la derniere pizza que l'on a ajouter
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
