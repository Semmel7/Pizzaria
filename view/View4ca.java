package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;
import model.Client;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controleur.CView4ca;
import model.Pizzaria;

// sous-affichage de l'interface gestion clients de la pizzaria (ajouter des clients)

public class View4ca extends JInternalFrame{
		
	Pizzaria piz;
	
	JLabel j;
	
	public View4c v1;
	
	JTextField j1 = new JTextField("06");
	
	JTextField j2 = new JTextField("1");
	
	public Vector<Client> cl=new Vector<Client> ();
	
	public View4ca(Pizzaria pi, View4c vi) {
		piz=pi;
		v1=vi;
		
		this.setTitle("Ajouter clients (numero, solde)");
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
		
		CView4ca a = new CView4ca(j1,j2,this,p,cl,piz);
				
		JButton jb=new JButton("Valider");
		JButton jv=new JButton("Ajouter");
		JButton jr=new JButton("Retirer");
		
		jb.addActionListener(a);
		jv.addActionListener(a);
		jr.addActionListener(a);
		
		top.setLayout(topg);
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
