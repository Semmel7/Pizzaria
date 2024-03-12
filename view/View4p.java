package view;
import model.Pizzaria;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

//interface sur la gestion des pizzas (elle va contenir plusieurs sous-affichages)

public class View4p extends JFrame{
	Pizzaria piz;
	
	public View4p (Pizzaria pi) {
		piz=pi;
		
		JDesktopPane d=new JDesktopPane();
		
		View5cat vcat=new View5cat(piz.cat.liste);
		vcat.setVisible(true);		
		d.add(vcat);
		
		View4ps vps=new View4ps(piz,this);
		vps.setVisible(true);
		d.add(vps);
		
		View4pi vpi = new View4pi(piz.listIngredient);
		vpi.setVisible(true);
		d.add(vpi);
		
		View4pia vpia = new View4pia(piz,this);
		vpia.setVisible(true);
		d.add(vpia);

		View4pis vis = new View4pis(piz,this);
		vis.setVisible(true);
		d.add(vis);
		
		View4pa vpa=new View4pa(this,piz,d);
		vpa.setVisible(true);	
		d.add(vpa);
				
		this.setPreferredSize(new Dimension(500, 500));
		this.getContentPane().add(d);				
		this.setSize(2000,2000);		
		this.show();
	}
}
