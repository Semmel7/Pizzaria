package view;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import model.Ingredient;

//sous-affichage de l'interface gestion pizzas de la pizzaria (afficher liste ingredients)

public class View4pi extends JInternalFrame{
	
	Vector<Ingredient> in;
	
	JLabel nom;
	
	JLabel qut;
	
	public View4pi (Vector<Ingredient> ing) {
		in=ing;
		
		this.setTitle("Ingredients");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);		
		
		JPanel list = new JPanel();
		JPanel pa = new JPanel();

		int n=in.size();
		
		GridLayout gb= new GridLayout(1,2);
		GridLayout g= new GridLayout(n,2,10,10);
				
		Font f=new Font("SansSerif", Font.BOLD, 12);
		
		JLabel name=new JLabel ("NOM");
		JLabel p=new JLabel ("QUANTITE");
		
		name.setFont(f);
		p.setFont(f);
		
		list.setLayout(g);
		pa.setLayout(gb);
		
		pa.add(name);
		pa.add(p);		
		
		for (int i = 0 ; i < n; i ++ ) {
			nom=new JLabel(in.get(i).nom);
			qut=new JLabel(in.get(i).qt+"");
			list.add(nom);
			list.add(qut);		
		}
		
		this.add(list);
		this.add(BorderLayout.NORTH,pa);
		this.setLocation(0,330);
		this.setSize(300,300);
		this.show();	
  }
}
