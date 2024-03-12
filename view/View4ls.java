package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import controleur.CView4ls;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Pizzaria;

//sous-affichage de l'interface gestion livreurs de la pizzaria (suppression livreur)

public class View4ls extends JInternalFrame{

	Pizzaria piz;
	
	JLabel j;
	
	JComboBox<String> jbx;
	
	public View4l v;
	
	public View4ls (Pizzaria pi, View4l vi) {
		piz=pi;
		v=vi;
		
		this.setTitle("Supprimer livreurs");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(520,0);
		
		String nomLiv[] = new String[piz.listLivreur.size()];
		for(int i = 0 ; i <piz.listLivreur.size();i++) {
			nomLiv[i]=piz.listLivreur.get(i).nom+" "+piz.listLivreur.get(i).transport;
		}
		jbx= new JComboBox<String>(nomLiv);
		
		JPanel p=new JPanel();
		JPanel pa=new JPanel();
		
		GridLayout gb= new GridLayout(1,2);
		GridLayout g= new GridLayout(6,2);
		
		BorderLayout b=new BorderLayout();
		
		JButton jb=new JButton("Select");
		JButton jv=new JButton("Virer");
		JButton ja=new JButton("Annuler");
		
		CView4ls a=new CView4ls(jbx,this,piz, p);
		
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
