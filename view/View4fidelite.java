package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controleur.CView4fidelite;
import model.Pizzaria;

//sous-affichage de l'interface gestion clients de la pizzaria (voir points fidelite et nb pizzas gratuite du client)

public class View4fidelite extends JInternalFrame {

	Pizzaria piz;
	
	JLabel j;
	
	JComboBox<String> jbx;
	
	public View4fidelite (Pizzaria pi) {
		piz=pi;
		
		this.setTitle("Fidelite");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(0,400);
		
		String numCli[] = new String[piz.listClient.size()+1];
		for(int i = 0 ; i <piz.listClient.size();i++) {
			numCli[i]=piz.listClient.get(i).num+"";
		}
		jbx= new JComboBox<String>(numCli);
		
		JPanel p=new JPanel();
		
		GridLayout g= new GridLayout(6,2);
		
		BorderLayout b=new BorderLayout();
		
		JButton jv=new JButton("Voir pizza gratuite");
		
		CView4fidelite a=new CView4fidelite(jbx,piz,p);
		
		jv.addActionListener(a);
		
		p.setLayout(g);
		
		p.add(jbx);
		
		this.setLayout(b);
		this.add(BorderLayout.CENTER,p);
		this.add(BorderLayout.SOUTH,jv);
		this.setSize(300,200);
		this.show();
	}
}
