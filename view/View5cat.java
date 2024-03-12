package view;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import model.Pizza;

// sous-affichages (affichage du catalogue)

public class View5cat extends JInternalFrame{
	
	Vector<Pizza> pi;
	
	JLabel piz;
	
	JLabel prix;
	
	public View5cat (Vector<Pizza> pizza) {
		pi=pizza;
		
		this.setTitle("Catalogue");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		
		int n=pizza.size();
		
		JPanel list = new JPanel();
		JPanel pa = new JPanel();
		
		GridLayout gb= new GridLayout(1,2);
		GridLayout g= new GridLayout(n,2,10,10);
		
		Font f=new Font("SansSerif", Font.BOLD, 12);
		
		JLabel nom=new JLabel ("NOM");
		JLabel p=new JLabel ("PRIX");
		
		nom.setFont(f);
		p.setFont(f);
		
		list.setLayout(g);
		pa.setLayout(gb);
		
		pa.add(nom);
		pa.add(p);
			
		for (int i = 0 ; i < n; i ++ ) {
			piz=new JLabel(pi.get(i).nom);
			prix=new JLabel(pi.get(i).prix+" €");
			list.add(piz);
			list.add(prix);			
		}
		
		this.add(list);
		this.add(BorderLayout.NORTH,pa);
		this.setLocation(0,0);
		this.setSize(300,300);
		this.show();	
  }
}
