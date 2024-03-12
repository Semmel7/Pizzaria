package controleur;
import java.awt.event.*;
import model.Livreur;
import model.Pizzaria;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import view.View4l;
import view.View4la;

public class CView4la implements ActionListener{
	
	JTextField j1;
	
	JTextField j2;
	
	JLabel jLabel;
	
	View4la v;
	
	JPanel jp;
	
	Vector<Livreur> liv;
	
	Pizzaria piz;
	
	Vector <JLabel> jla = new Vector <JLabel>();
	
	public CView4la (JTextField t1, JTextField t2, View4la vi, JPanel jpa, Vector<Livreur> li, Pizzaria p) {
		j1=t1;
		j2=t2;
		v=vi;
		jp=jpa;
		liv=li;
		piz=p;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals("Valider")) {
			
			// on cree un livreur
			Livreur l = new Livreur(j1.getText(),j2.getText(),piz);
			
			// on l'ajoute a la liste des livreurss que l'on veut ajouter
			liv.add(l);
			
			// on cree un JLabel1 qui va corespondre au livreur que l'on vient d'entrer
			jLabel=new JLabel(j1.getText()+" "+j2.getText());
			
			// on l'ajoute au vector de JLabel
			jla.add(jLabel);
			
			// et on l'ajoute au panel
			jp.add(jla.get(jla.size()-1));			
			
			// on met a jour l'affichage du panel
			SwingUtilities.updateComponentTreeUI(jp);			
		}
		
		if(((JButton)e.getSource()).getText().equals("Embaucher")) {
			if(liv.isEmpty()==false) {
				
				// on parcoure la liste des livreurss que l'on veut ajouter
				for(int i=0;i<liv.size();i++) {
					
					// si le i eme livreur n'existe pas on l'ajoute a la liste de livreur de la pizzaria
					if(piz.LivreurExiste(liv.get(i).nom)==false){
							piz.ajouterLivreur(liv.get(i));
					}else {
						
						// on verifie qu'il ne s'agit pas de 2 livreurs avec le meme nom mais un transport different
						if(piz.LivreurExistet(liv.get(i).transport)==false) {
							piz.ajouterLivreur(liv.get(i));
						}else {
							
							// si le livreur existe on affiche un message d'erreur
							JFrame jFrame = new JFrame();
					        JOptionPane.showMessageDialog(jFrame,"Le livreur "+j1.getText()+" avec le transport "+j2.getText()+" existe deja");
						}
					}
				}
				
				// on ferme la page et on la reouvre avec l'actualisation de la liste livreur 
				v.v1.dispose();
				View4l c=new View4l(piz);
				c.show();
			}
		}
		if(((JButton)e.getSource()).getText().equals("Annuler")) {
			if(liv.isEmpty()==false) {
				
				// on retire de la liste des livreurs a ajouter le dernier livreur que l'on a ajouter
				liv.remove(liv.get(liv.size()-1));
				
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
