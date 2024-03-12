package view;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import model.Pizzaria;

// interface sur la gestion des clients (elle va contenir plusieurs sous-affichages)

public class View4c extends JFrame {
	
	Pizzaria piz;
	
	public View4c( Pizzaria p){
		piz=p;
		
		JDesktopPane d=new JDesktopPane();
		
		View4lc vlc=new View4lc(piz.listClient);
		vlc.setVisible(true);
		d.add(vlc);
		
		View4cs vcs=new View4cs(piz,this);
		vcs.setVisible(true);
		d.add(vcs);
		
		View4ca vca=new View4ca(piz,this);
		vca.setVisible(true);
		d.add(vca);
		
		View4cca vcca=new View4cca(piz);
		vcca.setVisible(true);
		d.add(vcca);
		
		View4ccom vccom=new View4ccom(piz,d);
		vccom.setVisible(true);
		d.add(vccom);
		
		View4fidelite vf=new View4fidelite(piz);
		vf.setVisible(true);
		d.add(vf);
				
		this.setPreferredSize(new Dimension(500, 500));
		this.getContentPane().add(d);		
		this.setSize(2000,2000);
		this.show();
	}
}
