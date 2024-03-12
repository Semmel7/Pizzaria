package controleur;
import view.Vie5comm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import model.Client;
import model.Commande;
import model.Pizzaria;

public class CView4ccom implements ActionListener{
	
	JComboBox<String> jt;
	
	JTextField j1;
	
	Pizzaria piz;
	
	JDesktopPane frame;
	
	public CView4ccom (JComboBox<String> co,JTextField t1, Pizzaria p, JDesktopPane j) {
		jt=co;
		j1=t1;
		piz=p;
		frame=j;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals("Afficher")) {
			
			// numero de client
			int n = Integer.parseInt(jt.getSelectedItem()+"");
			
			// nombre de commande a afficher
			int c= Integer.parseInt(j1.getText());
			
			// nombre de commande effectue par le client
			int taille=piz.ClientExiste(n).getCom(c).size();
			
			if(c>taille) {
				c=taille;
			}
			
			// on affiche les c dernieres commandes
			for(int i=0;i<c;i++) {
				Commande vc=piz.ClientExiste(n).getCom(c).get(i);
				Vie5comm com=new Vie5comm(vc,frame);
				com.setLocation(310,0);
				com.show();
			}
		}
	}
}
