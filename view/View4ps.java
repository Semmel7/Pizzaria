package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import controleur.CView4ps;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Pizzaria;

//sous-affichage de l'interface gestion pizzas de la pizzaria (suppression pizzas)

public class View4ps extends JInternalFrame{
	
	Pizzaria piz;
	
	JLabel j;
	
	JComboBox<String> jbx;
	
	public View4p v;
	
	public View4ps (Pizzaria pi, View4p vi) {
		piz=pi;
		v=vi;
		
		this.setTitle("Supprmer pizzas");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(400,0);
		
		String namePiz[] = new String[piz.cat.liste.size()];
		for(int i = 0 ; i <piz.cat.liste.size();i++) {
			namePiz[i]=piz.cat.liste.get(i).nom;
		}
		jbx= new JComboBox<String>(namePiz);
		
		JPanel p=new JPanel();
		JPanel pa=new JPanel();
		
		GridLayout gb= new GridLayout(1,2);
		GridLayout g= new GridLayout(6,2);
		
		BorderLayout b=new BorderLayout();
		
		JButton jb=new JButton("Select");
		JButton jv=new JButton("Supprimer");
		JButton ja=new JButton("Annuler");
		
		CView4ps a=new CView4ps(jbx,this,piz,p);
		
		jb.addActionListener(a);
		jv.addActionListener(a);
		ja.addActionListener(a);
		
		pa.setLayout(gb);
		p.setLayout(g);
		
		pa.add(jv);
		pa.add(ja);	
		p.add(jbx);
		
		this.setLayout(b);
		this.add(BorderLayout.CENTER,p);
		this.add(BorderLayout.EAST,jb);
		this.add(BorderLayout.SOUTH,pa);
		this.setSize(300,300);
		this.show();
	}
}
