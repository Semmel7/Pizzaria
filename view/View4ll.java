package view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Livreur;

//sous-affichage de l'interface gestion livreurs de la pizzaria (affiche la liste des livreurs de la pizzaria)

public class View4ll extends JInternalFrame{
	
	Vector<Livreur> liv;
	
	JLabel nom;
	
	JLabel trans;
	
	public View4ll (Vector<Livreur> l) {
		liv=l;
		
		this.setTitle("Livreurs");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		
		int n=liv.size();
		
		JPanel list = new JPanel();
		JPanel pa = new JPanel();
		
		GridLayout gb= new GridLayout(1,2);
		GridLayout g= new GridLayout(n,2,10,10);
		
		list.setLayout(g);
		
		JLabel nom=new JLabel ("NOM");
		JLabel p=new JLabel ("TRANSPORT");
		
		Font f=new Font("SansSerif", Font.BOLD, 12);
		
		nom.setFont(f);
		p.setFont(f);
		
		pa.setLayout(gb);
		
		pa.add(nom);
		pa.add(p);
		
		for (int i = 0 ; i < n; i ++ ) {
			nom=new JLabel(liv.get(i).nom);
			trans=new JLabel(liv.get(i).transport);
			list.add(nom);
			list.add(trans);			
		}
		
		this.add(list);
		this.add(BorderLayout.NORTH,pa);
		this.setSize(450, 300);
		this.show();		
	}
}
