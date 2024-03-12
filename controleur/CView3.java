package controleur;
import model.Pizzaria;
import model.Client;
import view.View3c;
import view.View3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CView3 implements ActionListener {
	
	JTextField j;
	
	Pizzaria piz;
	
	View3 v;
	
	public CView3(JTextField jt,Pizzaria p, View3 vi) {
		piz=p;
		j=jt;
		v=vi;
	}

	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		Client clientC=piz.ClientExiste(Integer.parseInt(j.getText()));
	
		if(clientC!=null) {	
			View3c a=new View3c(clientC,piz);
			a.show();
			
			// on ferme la page d'identifiacation
			v.dispose();
		}else {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame," Numero inconnu");       
		}
	}
}

