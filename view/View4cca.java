package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controleur.CView4cca;
import model.Pizzaria;

//sous-affichage de l'interface gestion clients de la pizzaria (affiche ca du client)

public class View4cca extends JInternalFrame {

	Pizzaria piz;
	
	JLabel j;
	
	JComboBox<String> jbx;
	
	public View4cca (Pizzaria pi) {
		piz=pi;
		
		this.setTitle("Calculer CA");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(870,400);
		
		String numCli[] = new String[piz.listClient.size()+1];
		for(int i = 0 ; i <piz.listClient.size();i++) {
			numCli[i]=piz.listClient.get(i).num+"";
		}
		numCli[piz.listClient.size()]="Rapizza";
		
		jbx= new JComboBox<String>(numCli);
		
		JPanel p=new JPanel();
		
		GridLayout g= new GridLayout(6,2);
		
		BorderLayout b=new BorderLayout();
		
		JButton jv=new JButton("Calculer CA");
		
		CView4cca a=new CView4cca(jbx,piz,p);
		
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
