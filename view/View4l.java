package view;
import model.Pizzaria;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

//interface sur la gestion des livreurs (elle va contenir plusieurs sous-affichages)

public class View4l extends JFrame {
	Pizzaria piz;
	
	public View4l (Pizzaria p) {
		piz=p;
		
		JDesktopPane d=new JDesktopPane();
		
		View4ll vll=new View4ll(piz.listLivreur);
		vll.setVisible(true);
		d.add(vll);
		
		View4ls vls=new View4ls(piz, this);
		vls.setVisible(true);
		d.add(vls);
		
		View4la vla=new View4la(piz,this);
		vla.setVisible(true);
		d.add(vla);
		
		View4lcom vlcom=new View4lcom(piz,d);
		vlcom.setVisible(true);
		d.add(vlcom);
		
		this.setPreferredSize(new Dimension(500, 500));
		this.getContentPane().add(d);			
		this.setSize(2000,2000);
		this.show();
	}
}
