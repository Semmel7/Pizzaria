package view;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import model.Client;
import model.Pizza;
import model.Pizzaria;
import model.LigneCommande;
import controleur.CView5co;

// sous-affichage pour passer une commande

public class View5co extends JInternalFrame{
	
	Pizza pizza;
	
	JLabel j;
	
	JComboBox<String> jbx;
	
	JComboBox<String> jcb;
	
	JTextField jtn=new JTextField("1");
	
	Client client;
	
	Pizzaria piz;
	
	Vector<LigneCommande> lnCom=new Vector<LigneCommande> ();
	
	JDesktopPane frame;
	
	public View5co(Client cl,Pizzaria pi,JDesktopPane f) {
		client = cl;
		piz=pi;
		frame=f;
		
		this.setTitle("Commander");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(370,0);
		
		String nomPiz[]=new String[piz.cat.liste.size()];
		for(int i = 0 ; i <piz.cat.liste.size();i++) {
			nomPiz[i]=piz.cat.liste.get(i).nom;
		}
		jbx= new JComboBox<String>(nomPiz);	
		
		String[] taillePiz = new String [] {"naine","humaine","ogresse"};
		jcb=new JComboBox<String>(taillePiz);
		
		JPanel p=new JPanel();
		JPanel top=new JPanel();
		JPanel bot=new JPanel();
		
		GridLayout gb=new GridLayout(1,2);
		GridLayout topg=new GridLayout(1,3);		
		GridLayout g= new GridLayout(0,1);
		
		BorderLayout b=new BorderLayout();
		
		CView5co a=new CView5co(jbx,jcb,jtn,this,p,lnCom,piz,client,frame);
		
		JButton jb=new JButton("Add");
		JButton jv=new JButton("Valider");
		JButton jr=new JButton("Retirer");
		
		jb.addActionListener(a);
		jv.addActionListener(a);
		jr.addActionListener(a);
		
		top.setLayout(topg);
		p.setLayout(g);
		bot.setLayout(gb);
		
		bot.add(jv);
		bot.add(jr);
		top.add(jbx);
		top.add(jcb);
		top.add(jtn);
		
		this.setLayout(b);
		this.add(BorderLayout.NORTH,top);
		this.add(BorderLayout.CENTER,p);
		this.add(BorderLayout.EAST,jb);
		this.add(BorderLayout.SOUTH,bot);
		this.setSize(300,300);
		this.show();		
		}
}
