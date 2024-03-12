package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.Pizzaria;

public class CView4fidelite implements ActionListener{
	
	JComboBox<String> jt;
	
	JLabel j1;
	
	JLabel j2;
	
	JLabel j3;
	
	JPanel jp;
	
	Pizzaria piz;
	
	public CView4fidelite (JComboBox<String> co, Pizzaria p, JPanel j) {
		jt=co;
		piz=p;
		jp=j;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals("Voir pizza gratuite")) {
			
			// on ecrit dans le JLabel le numero de client selectionne
			j1=new JLabel(jt.getSelectedItem()+"");
			
			// on cree un entier correspondant au nombre de pizzas gratuites dont le client est eligible
			int s=piz.fidelite(piz.ClientExiste(Integer.parseInt(jt.getSelectedItem()+"")));
			
			// on ecrit dans le deuxieme JLabel le nombre de points fidelite du client
			j2=new JLabel(jt.getSelectedItem()+" "+piz.ClientExiste(Integer.parseInt(jt.getSelectedItem()+"")).points_fidelite+" "+" points fidelite");
			
			// et ici on ecrit le nombre de pizzas gratuite dont il est eligible
			j3=new JLabel(jt.getSelectedItem()+" "+s+""+" pizzas gratuites");
			
			// on ajoute au panel les deux JLabel cree et on le reactualise
			jp.add(j2);
			jp.add(j3);
			SwingUtilities.updateComponentTreeUI(jp);
		}
	}
}
