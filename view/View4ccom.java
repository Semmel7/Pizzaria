package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controleur.CView4ccom;
import model.Pizzaria;

//sous-affichage de l'interface gestion clients de la pizzaria (affiche n dernieres commandes du client)

public class View4ccom extends JInternalFrame {

	Pizzaria piz;
	
	JLabel j;
	
	JTextField j1 = new JTextField("1");
	
	JComboBox<String> jbx;
	
	JDesktopPane frame;
	
	public View4ccom (Pizzaria pi, JDesktopPane j) {
		piz=pi;
		frame=j;
		
		this.setTitle("Afficher n dernieres commandes");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(520,400);
		
		String numCli[] = new String[piz.listClient.size()];
		for(int i = 0 ; i <piz.listClient.size();i++) {
			numCli[i]=piz.listClient.get(i).num+"";
		}
		jbx= new JComboBox<String>(numCli);
		
		JPanel p=new JPanel();
		JPanel top=new JPanel();
		JPanel bot=new JPanel();
		
		GridLayout gb=new GridLayout(1,2);
		GridLayout topg=new GridLayout(1,2);		
		GridLayout g= new GridLayout(0,1);
		
		BorderLayout b=new BorderLayout();
		
		CView4ccom a=new CView4ccom(jbx,j1,piz,frame);
		
		JButton jb=new JButton("Afficher");
		
		jb.addActionListener(a);
		
		top.setLayout(topg);
		p.setLayout(g);
		bot.setLayout(gb);
		
		bot.add(jb);
		top.add(jbx);
		top.add(j1);
		
		this.setLayout(b);
		this.add(BorderLayout.NORTH,top);
		this.add(BorderLayout.CENTER,p);
		this.add(BorderLayout.SOUTH,jb);
		this.setSize(300,200);
		this.show();
	}
}
