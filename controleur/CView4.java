package controleur;
import model.Pizzaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import view.View4c;
import view.View4l;
import view.View4p;

public class CView4 implements ActionListener {
	
	Pizzaria piz;
	
	public CView4(Pizzaria p) {
		piz=p;
	}

	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		
		if(((JButton)e.getSource()).getText().equals("Client")) {
			View4c c=new View4c(piz);
			c.show();
		}
		
		if(((JButton)e.getSource()).getText().equals("Pizza")) {
			View4p c=new View4p(piz);
			c.show();
		}
		
		if(((JButton)e.getSource()).getText().equals("Livreur")) {
			View4l c=new View4l(piz);
			c.show();
		}		
	}
}
