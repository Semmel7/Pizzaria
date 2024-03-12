package controleur;
import view.View5s;
import view.View5c;
import view.View5co;
import model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;

public class CView3c implements ActionListener {
	
	Client c;
	
	Pizzaria piz;

	public CView3c(Client cl,Pizzaria p) {
		c=cl;
		piz=p;		
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
				
		if(((JButton)e.getSource()).getText().equals("solde")) {
			View5s a=new View5s(c);
			a.show();
		}
		
		if(((JButton)e.getSource()).getText().equals("commander")) {
			View5c b=new View5c(c,piz,piz.cat.liste);		
			b.show();		
		}
	}
}
