package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.Client;
import model.Pizzaria;
import view.View4cs;
import view.View4c;

public class CView4cs implements ActionListener{
	
	JComboBox<String> jt;
	
	JLabel jl;
	
	JPanel jp;
	
	View4cs v1;
	
	Pizzaria piz;
	
	Vector<Client> bye = new Vector<Client>();
	
	Vector<JLabel> jla = new Vector<JLabel>();
	
	public CView4cs (JComboBox<String> co, View4cs vi1, Pizzaria p, JPanel j) {
		jt=co;
		v1=vi1;
		piz=p;
		jp=j;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(((JButton)e.getSource()).getText().equals("Select")) {
			
			// on ajoute au vector jlabel j1 correspondant au num client selectionne
			jl=new JLabel(jt.getSelectedItem()+"");
			jla.add(jl);
			
			// on parcoure la liste des clients
			for(int i=0;i<piz.listClient.size();i++) {
				
				// si le client selectionne correspond au i eme client de la liste
				if(jl.getText().equals(piz.listClient.get(i).num+"")) {
					
					// on l'ajoute dans la liste des clients a supprimer, puis on quitte la boucle
					bye.add(piz.listClient.get(i));
					break;
				}
			}
			
			// on rajoute au panel le dernier element ajouter dans le vector jla, puis on le raffraichi
			jp.add(jla.get(jla.size()-1));
			SwingUtilities.updateComponentTreeUI(jp);
		}
		
		if(((JButton)e.getSource()).getText().equals("Supprimer")) {
			if(bye.isEmpty()==false) {
				
				// on parcoure la liste des clients a supprimer
				for(int j=0;j<bye.size();j++) {
				
					// puis on supprime les les clients de la liste client de la pizzaria
					piz.suppClient(bye.get(j));
				}
			
				// on ferme et on raffiche la page apres modification de la liste
				v1.v.dispose();
				View4c c=new View4c(piz);
				c.show();
			}
		}
		
		if(((JButton)e.getSource()).getText().equals("Annuler")) {
			if(bye.isEmpty()==false) {
				
				// on retire de la liste des client a supprimer le dernier client que l'on a ajouter
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
