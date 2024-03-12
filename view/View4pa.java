package view;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import model.Pizzaria;
import model.LigneRecette;
import controleur.CView4pa;

//sous-affichage de l'interface gestion pizzas de la pizzaria (ajouter des pizzas)

public class View4pa extends JInternalFrame{
	
	public View4p v1;
	
	JLabel j;
	
	JTextField j1=new JTextField("nom");
	
	JTextField j2=new JTextField("10");
	
	JTextField j4=new JTextField("1");
	
	JComboBox<String> jbx;
	
	Pizzaria piz;
	
	Vector<LigneRecette> lnRe=new Vector<LigneRecette> ();
	
	JDesktopPane frame;
	
	public View4pa(View4p vi,Pizzaria pi,JDesktopPane f) {
		v1=vi;
		piz=pi;
		frame=f;
		
		this.setTitle("Ajouter pizza (nom, prix, quantite)");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(800,0);
		
		String nomIng[]=new String[piz.listIngredient.size()];
		for(int i = 0 ; i <piz.listIngredient.size();i++) {
			nomIng[i]=piz.listIngredient.get(i).nom;
		}
		jbx= new JComboBox<String>(nomIng);	
		
		JPanel p=new JPanel();
		JPanel top=new JPanel();
		JPanel bot=new JPanel();
		
		GridLayout gb=new GridLayout(1,2);
		GridLayout topg=new GridLayout(1,3);		
		GridLayout g= new GridLayout(0,1);
		
		BorderLayout b=new BorderLayout();
		
		CView4pa a=new CView4pa(j1,j2,jbx,j4,this,p,lnRe,piz);
		
		top.setLayout(topg);
		
		JButton jb=new JButton("Ajouter");
		JButton jv=new JButton("Creer");
		JButton ja=new JButton("Annuler");
		
		jb.addActionListener(a);
		jv.addActionListener(a);
		ja.addActionListener(a);
		
		p.setLayout(g);
		bot.setLayout(gb);
		
		bot.add(jv);
		bot.add(ja);
		top.add(j1);
		top.add(j2);
		top.add(jbx);
		top.add(j4);
		
		this.setLayout(b);
		this.add(BorderLayout.NORTH,top);
		this.add(BorderLayout.CENTER,p);
		this.add(BorderLayout.EAST,jb);
		this.add(BorderLayout.SOUTH,bot);
		this.setSize(300,300);
		this.show();		
		}
}
