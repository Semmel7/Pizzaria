package view;
import javax.swing.*;
import java.awt.*;
import model.Pizzaria;
import controleur.CView5ing;

// sous-affichage pour consulter les ingredients d'une pizza

public class View5ing extends JInternalFrame {
	
	Pizzaria piz;
	
	JComboBox<String> pizza;
	
	public View5ing(Pizzaria pi) {
		piz=pi;
		
		this.setTitle("Consulter ingredients");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setLocation(750,0);
		
		String nomPiz[]=new String[piz.cat.liste.size()];
		for(int i = 0 ; i <piz.cat.liste.size();i++) {
			nomPiz[i]=piz.cat.liste.get(i).nom;
		}
		pizza= new JComboBox<String>(nomPiz);
		
		JButton v=new JButton("Get");
		
		JPanel p=new JPanel();
		JPanel top=new JPanel();
		JPanel bot=new JPanel();
		
		GridLayout gb=new GridLayout(1,2);
		GridLayout topg=new GridLayout(1,2);
		GridLayout g= new GridLayout(0,1);
		
		bot.setLayout(gb);		
		top.setLayout(topg);
		p.setLayout(g);
		
		CView5ing a=new CView5ing(pizza,piz,p);
		
		v.addActionListener(a);
		
		top.add(pizza);
		top.add(v);
		
		this.add(BorderLayout.NORTH,top);
		this.add(BorderLayout.CENTER,p);
		this.setSize(300,600);
		this.show();
	}
}
