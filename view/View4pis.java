package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controleur.CView4pis;
import model.Pizzaria;

//sous-affichage de l'interface gestion pizzas de la pizzaria (supprimerer ingredients)

public class View4pis extends JInternalFrame{
	
	Pizzaria piz;
	
	JLabel j;
	
	JComboBox<String> jbx;
	
	public View4p v;
	
	public View4pis (Pizzaria pi, View4p vi) {
		piz=pi;
		v=vi;
		
		this.setTitle("Supprimer ingredients");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(400,330);
		
		String nameIng[] = new String[piz.listIngredient.size()];
		for(int i = 0 ; i <piz.listIngredient.size();i++) {
			nameIng[i]=piz.listIngredient.get(i).nom;
		}
		jbx= new JComboBox<String>(nameIng);
		
		JPanel p=new JPanel();
		JPanel pa=new JPanel();
		
		GridLayout gb= new GridLayout(1,2);
		GridLayout g= new GridLayout(6,2);
		
		BorderLayout b=new BorderLayout();
		
		JButton jb=new JButton("Select");
		JButton jv=new JButton("Supprimer");
		JButton ja=new JButton("Annuler");
		
		CView4pis a=new CView4pis(jbx,this,piz,p);
		
		jb.addActionListener(a);
		jv.addActionListener(a);
		ja.addActionListener(a);
		
		p.setLayout(g);
		pa.setLayout(gb);
		
		p.add(jbx);		
		pa.add(jv);
		pa.add(ja);
		
		this.setLayout(b);
		this.add(BorderLayout.CENTER,p);
		this.add(BorderLayout.EAST,jb);
		this.add(BorderLayout.SOUTH,pa);
		this.setSize(300,300);
		this.show();
	}
}
