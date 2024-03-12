package controleur;
import view.View2;
import view.View3;
import model.Pizzaria;
import java.awt.event.*;
import javax.swing.*;

public class CView1 implements ActionListener {
	
	Pizzaria pi;
	
	public CView1(Pizzaria p) {
	pi=p;
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		
		if(((JButton)e.getSource()).getText().equals("Client")) {
			View3 c=new View3(pi);
			c.show();
		}
		
		if (((JButton)e.getSource()).getText().equals("Pizzaria")) {
			View2 p=new View2(pi);
			p.show();			
		}		
	}
}


