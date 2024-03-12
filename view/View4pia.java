package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controleur.CView4pia;
import model.Pizzaria;
import model.Ingredient;

//sous-affichage de l'interface gestion pizzas de la pizzaria (ajouter ingredients)

public class View4pia extends JInternalFrame{
	
	Pizzaria piz;
	
	JLabel j;
	
	public View4p v1;
	
	JTextField j1 = new JTextField("nom");
	
	JTextField j2 = new JTextField("1");
	
	public Vector<Ingredient> ing=new Vector<Ingredient> ();
	
	public View4pia (Pizzaria pi, View4p vi) {
		piz=pi;
		v1=vi;
		
		this.setTitle("Ajouter ingredients (nom, quantite)");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(800,330);
		
		JPanel p=new JPanel();
		JPanel top=new JPanel();
		JPanel bot=new JPanel();
		
		GridLayout gb=new GridLayout(1,2);
		GridLayout topg=new GridLayout(1,2);		
		GridLayout g= new GridLayout(0,1);
		
		BorderLayout b=new BorderLayout();
		
		CView4pia a= new CView4pia(j1,j2,this,p,ing,piz);
		
		top.setLayout(topg);
		
		JButton jb=new JButton("Valider");
		JButton jv=new JButton("Ajouter");
		JButton jr=new JButton("Annuler");
		
		jb.addActionListener(a);
		jv.addActionListener(a);
		jr.addActionListener(a);
		
		p.setLayout(g);
		bot.setLayout(gb);
		
		bot.add(jv);
		bot.add(jr);
		top.add(j1);
		top.add(j2);
		
		this.setLayout(b);
		this.add(BorderLayout.NORTH,top);
		this.add(BorderLayout.CENTER,p);
		this.add(BorderLayout.EAST,jb);
		this.add(BorderLayout.SOUTH,bot);
		this.setSize(300,300);
		this.show();
	}
}
