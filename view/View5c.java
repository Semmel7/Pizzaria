package view;
import model.Client;
import model.Pizzaria;
import model.Pizza;
import java.awt.*;
import java.util.*;
import javax.swing.*;

// affichage pour passer les commandes (partie client)

public class View5c extends JFrame{
	
	Client client;
	
	Pizzaria piz;
	
	Vector<Pizza> lpizza;
	
	public View5c (Client cl,Pizzaria p,Vector<Pizza> lp) {
		lpizza=lp;
		client = cl;
		piz=p;
		
		JDesktopPane d=new JDesktopPane();
		
		d.setBackground(Color.gray);
		
		View5co vco=new View5co(client,piz,d);
		vco.setVisible(true);
		d.add(vco);
		
		View5cat vcat=new View5cat(lpizza);
		vcat.setVisible(true);
		d.add(vcat);
		
		View5filtre vf=new View5filtre(client,piz,lpizza,this);
		vf.setVisible(true);
		d.add(vf);
		
		View5ing ving=new View5ing(piz);
		ving.setVisible(true);
		d.add(ving);
		
		this.setPreferredSize(new Dimension(500, 500));
		this.getContentPane().add(d);		
		this.setSize(2000,2000);		
		this.show();        
	}
}
