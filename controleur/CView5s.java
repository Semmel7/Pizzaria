package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Client;

public class CView5s implements ActionListener {
	
	JTextField val;
	
	Client cl;
	
	JLabel text;
	
	public CView5s(JTextField v,Client c,JLabel t) {
		val=v;
		cl=c;
		text=t;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// on recupere la somme entree par le client
		double som = Double.parseDouble(val.getText());
		if(((JButton)e.getSource()).getText().equals("Crediter")) {
			
			// et on credite la somme sur le compte du client
			cl.cred(som);
		}
		
		// on met a jour l'affichhage du texte indiquant le solde du client
		text.setText(cl.solde+" €");		
	}
}
