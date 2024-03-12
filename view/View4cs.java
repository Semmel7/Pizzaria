package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controleur.CView4cs;
import model.Pizzaria;

//sous-affichage de l'interface gestion clients de la pizzaria (suppression client)

public class View4cs extends JInternalFrame {

	Pizzaria piz;
	
	JLabel j;
	
	JComboBox<String> jbx;
	
	public View4c v;
	
	public View4cs (Pizzaria pi, View4c vi) {
		piz=pi;
		v=vi;
		
		this.setTitle("Supprimer clients");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(520,0);
		
		String numCli[] = new String[piz.listClient.size()];
		for(int i = 0 ; i <piz.listClient.size();i++) {
			numCli[i]=piz.listClient.get(i).num+"";
		}
		jbx= new JComboBox<String>(numCli);
		
		JPanel p=new JPanel();
		JPanel pa=new JPanel();
		
		GridLayout gb= new GridLayout(1,2);
		GridLayout g= new GridLayout(6,2);
		
		BorderLayout b=new BorderLayout();
		
		JButton jb=new JButton("Select");
		JButton jv=new JButton("Supprimer");
		JButton ja=new JButton("Annuler");
		
		CView4cs a=new CView4cs(jbx,this,piz,p);
		
		jb.addActionListener(a);
		jv.addActionListener(a);
		ja.addActionListener(a);
				
		p.add(jbx);
		p.setLayout(g);
		pa.setLayout(gb);
		
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
