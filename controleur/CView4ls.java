package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.Pizzaria;
import model.Livreur;
import view.View4l;
import view.View4ls;

public class CView4ls implements ActionListener{
	
	JComboBox<String> jt;
	
	JLabel jl;
	
	JPanel jp;
	
	View4ls v1;
	
	Pizzaria piz;
	
	Vector<Livreur> bye = new Vector<Livreur>();
	
	Vector<JLabel> jla = new Vector<JLabel>();
	
	public CView4ls (JComboBox<String> c, View4ls vi1, Pizzaria p, JPanel j) {
		jt=c;
		v1=vi1;
		piz=p;
		jp=j;
	}

	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals("Select")) {
			
			// on ajoute au vector jlabel j1 correspondant au livreur selectionne
			jl=new JLabel(jt.getSelectedItem()+"");
			jla.add(jl);
			
			// on parcoure la liste des livreurs
			for(int i=0;i<piz.listLivreur.size();i++) {
				
				// si le livreur selectionne correspond au i eme livreur de la liste
				if(jl.getText().equals(piz.listLivreur.get(i).nom+" "+piz.listLivreur.get(i).transport)) {
					
					// on l'ajoute dans la liste des livreurs a supprimer, puis on quitte la boucle
					bye.add(piz.listLivreur.get(i));
					break;
				}
			}
			
			// on rajoute au panel le dernier element ajouter dans le vector jla, puis on le raffraichi
			jp.add(jla.get(jla.size()-1));
			SwingUtilities.updateComponentTreeUI(jp);
		}
		
		if(((JButton)e.getSource()).getText().equals("Virer")) {
			if(bye.isEmpty()==false) {
				
				// on parcoure la liste des livreurs a supprimer
				for(int j=0;j<bye.size();j++) {
					
					// puis on supprime les les clients de la liste client de la pizzaria
					piz.suppLivreur(bye.get(j));
				}
				
				// on ferme et on raffiche la page apres modification de la liste
				v1.v.dispose();
				View4l c=new View4l(piz);
				c.show();		
			}			
		}
		
		if(((JButton)e.getSource()).getText().equals("Annuler")) {
			if(bye.isEmpty()==false) {
				
				// on retire de la liste des livreurs a supprimer le dernier livreur que l'on a ajouter
				bye.remove(bye.get(bye.size()-1));
				
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
