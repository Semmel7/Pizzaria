package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Pizzaria;
import controleur.CView4lcom;

// sous-affichage de la gestion livreur pour afficher les commandes d'un livreur

public class View4lcom extends JInternalFrame{

	Pizzaria piz;
	
	JLabel j;
	
	JComboBox<String> jbx;
	
	JDesktopPane frame;
	
	public View4lcom (Pizzaria pi,JDesktopPane j) {
		piz=pi;
		frame=j;
		
		this.setTitle("Afficher n dernieres commandes");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(870,320);
		
		String nomLiv[] = new String[piz.listLivreur.size()];
		for(int i = 0 ; i <piz.listLivreur.size();i++) {
			nomLiv[i]=piz.listLivreur.get(i).nom+" "+piz.listLivreur.get(i).transport;
		}
		jbx= new JComboBox<String>(nomLiv);
		
		JPanel p=new JPanel();
		JPanel top=new JPanel();
		JPanel bot=new JPanel();
		
		GridLayout gb=new GridLayout(1,2);
		GridLayout topg=new GridLayout(1,2);		
		GridLayout g= new GridLayout(0,1);
		
		BorderLayout b=new BorderLayout();
		
		CView4lcom a = new CView4lcom(jbx,piz,frame);
		
		JButton jb=new JButton("Afficher");
		
		jb.addActionListener(a);
		
		top.setLayout(topg);
		p.setLayout(g);
		bot.setLayout(gb);
		
		bot.add(jb);
		top.add(jbx);
		
		this.setLayout(b);
		this.add(BorderLayout.NORTH,top);
		this.add(BorderLayout.CENTER,p);
		this.add(BorderLayout.SOUTH,jb);
		this.setSize(300,200);
		this.show();		
	}	
}
