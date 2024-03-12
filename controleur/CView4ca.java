package controleur;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import model.Client;
import model.Pizzaria;
import view.View4ca;
import view.View4c;

public class CView4ca implements ActionListener{
	
	JTextField j1;
	
	JTextField j2;
	
	JLabel jLabel;
	
	View4ca v;
	
	JPanel jp;
	
	Vector<Client> cl;
	
	Pizzaria piz;
	
	Vector <JLabel> jla = new Vector <JLabel>();
	
	public CView4ca(JTextField t1,JTextField t2,View4ca vi,JPanel jpa, Vector<Client> lc, Pizzaria pi) {
		j1=t1;
		j2=t2;
		v=vi;
		jp=jpa;
		cl=lc;
		piz=pi;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(((JButton)e.getSource()).getText().equals("Valider")) {
			
			// on cree un client
			Client c = new Client(Integer.parseInt(j1.getText()),Double.parseDouble(j2.getText()));
			
			// on l'ajoute a la liste des clients que l'on veut ajouter
			cl.add(c);
			
			// on cree un JLabel1 qui va corespondre au client que l'on vient d'entrer 
			jLabel=new JLabel(j1.getText()+"      "+j2.getText()+" €");			
			
			// on l'ajoute au vector de JLabel
			jla.add(jLabel);
			
			// et on l'ajoute au panel
			jp.add(jla.get(jla.size()-1));				
			
			// on met a jour l'affichage du panel
			SwingUtilities.updateComponentTreeUI(jp);			
		}
		
		if(((JButton)e.getSource()).getText().equals("Ajouter")) {
			if(cl.isEmpty()==false) {
			
				// on parcoure la liste des clients que l'on veut ajouter
				for(int i=0;i<cl.size();i++) {
				
					// si le i eme client n'existe pas on l'ajoute a la liste de client de la pizzaria
					if(piz.ClientExiste(cl.get(i).num)==null){
						piz.ajouterClient(cl.get(i));
					}else {
						// si le client existe on affiche un message d'erreur
						JFrame jFrame = new JFrame();
						JOptionPane.showMessageDialog(jFrame,"Le client avec le numero "+j1.getText()+" existe deja");
					}
				}
				
				// on ferme la page et on la reouvre avec l'actualisation de la liste client 
				v.v1.dispose();
				View4c c=new View4c(piz);
				c.show();
			}
		}
		
		if(((JButton)e.getSource()).getText().equals("Retirer")) {
			if(cl.isEmpty()==false) {
				
				// on retire de la liste des client a ajouter le dernier client que l'on a ajouter
				cl.remove(cl.get(cl.size()-1));
				
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
