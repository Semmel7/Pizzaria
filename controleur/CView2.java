package controleur;
import model.Pizzaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import view.View2;
import view.View4;

public class CView2 implements  ActionListener {
	
	Pizzaria piz;
	
	JTextField j;
	
	View2 v;
	
	public CView2(JTextField jt, Pizzaria p, View2 vi) {
	j=jt;
	piz=p;
	v=vi;
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		
		if(j.getText().equals("jsp")) {
			View4 c=new View4(piz);
			c.show();
			v.dispose();
		}else {
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame," Mot de passe incorrect");       
		}
	}
}
