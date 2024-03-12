package view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;
import model.Client;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//sous-affichage de l'interface gestion clients de la pizzaria (affiche la liste des clients de la pizzaria)

public class View4lc extends JInternalFrame{
	
	Vector<Client> cl;
	
	JLabel n;
	
	JLabel nb;
	
	JLabel s;
	
	public View4lc (Vector<Client> c) {
		cl=c;
		
		this.setTitle("Clients");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		
		JPanel list = new JPanel();
		JPanel pa = new JPanel();
		
		int n=cl.size();
		
		GridLayout gb= new GridLayout(1,3);
		GridLayout g= new GridLayout(n,3,10,10);
		
		list.setLayout(g);
		
		JLabel nume=new JLabel ("NUMERO");
		JLabel nb=new JLabel ("NB_COMMANDE");
		JLabel sol=new JLabel ("SOLDE");
		
		Font f=new Font("SansSerif", Font.BOLD, 12);
		
		nume.setFont(f);
		nb.setFont(f);
		sol.setFont(f);
		
		pa.setLayout(gb);
		
		pa.add(nume);
		pa.add(nb);
		pa.add(sol);
		
		for (int i = 0 ; i < n; i ++ ) {
			nume=new JLabel(cl.get(i).num+"");
			nb=new JLabel(cl.get(i).nbCommande+"");
			sol=new JLabel(cl.get(i).solde+" €");
			list.add(nume);
			list.add(nb);
			list.add(sol);			
		}
		
		this.add(list);
		this.add(BorderLayout.NORTH,pa);
		this.setSize(470,200);
		this.show();
	}
}
