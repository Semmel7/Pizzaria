package view;
import javax.swing.*;
import java.awt.*;
import controleur.CView4;
import model.Pizzaria;

// interface pizzaria

public class View4 extends JFrame {
	
	Pizzaria piz;
	
	JButton a=new JButton("Client");
	
	JButton b=new JButton("Pizza");
	
	JButton c=new JButton("Livreur");
	
	public View4(Pizzaria p) {
		piz=p;
		
		CView4 m=new CView4(piz);
		
		JPanel option=new JPanel();
		
		GridLayout g=new GridLayout(3,4,10,10);
		
		a.addActionListener(m);
		b.addActionListener(m);
		c.addActionListener(m);
		
		option.setLayout(g);
		
		option.add(a);
		option.add(b);
		option.add(c);
				
		this.getContentPane().add(option);
		this.setLocation(230,150);
		this.setSize(100,150);
		this.show();
		
		
	}
}
