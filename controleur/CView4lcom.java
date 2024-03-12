package controleur;
import view.Vie5comm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import model.Livreur;
import model.Commande;
import model.Pizzaria;

public class CView4lcom implements ActionListener{
	
	JComboBox<String> jt;
	
	Pizzaria piz;
	
	JDesktopPane frame;
	
	public CView4lcom (JComboBox<String> co, Pizzaria p, JDesktopPane j) {
		jt=co;
		piz=p;
		frame=j;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals("Afficher")) {
			
			// nom livreur
			String s = jt.getSelectedItem()+"";
			
			// on recupere le livreur selectionne
			Livreur l = piz.TransportNom(s);
			
			// on affiche les commandes du livreur
			for(int i=0;i<l.listCom.size();i++) {
				Commande vc=l.listCom.get(i);
				Vie5comm com=new Vie5comm(vc,frame);
				com.setLocation(0,320);
				com.show();
			}
		}
	}
}
