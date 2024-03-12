package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controleur.CView4la;
import model.Pizzaria;
import model.Livreur;

//sous-affichage de l'interface gestion clients de la pizzaria (ajouter des livreurs)

public class View4la extends JInternalFrame{
	
	Pizzaria piz;
	
	JLabel j;
	
	public View4l v1;
	
	JTextField j1 = new JTextField("nom");
	
	JTextField j2 = new JTextField("transport");
	
	public Vector<Livreur> liv=new Vector<Livreur> ();
	
	public View4la (Pizzaria pi, View4l vi) {
		piz=pi;
		v1=vi;
		
		this.setTitle("Ajouter livreurs");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(870,0);
		
		JPanel p=new JPanel();
		JPanel top=new JPanel();
		JPanel bot=new JPanel();
		
		GridLayout gb=new GridLayout(1,2);
		GridLayout topg=new GridLayout(1,2);		
		GridLayout g= new GridLayout(0,1);
		
		BorderLayout b=new BorderLayout();
		
		CView4la a= new CView4la(j1,j2,this,p,liv,piz);
		
		top.setLayout(topg);
		
		JButton jb=new JButton("Valider");
		JButton jv=new JButton("Embaucher");
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
