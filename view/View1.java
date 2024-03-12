package view;
import controleur.CView1;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.Pizzaria;

// affichage de la page d'acceuil

public class View1 extends JFrame {
	
	JLabel n;
	
	JLabel nam;
	
	JButton p =new JButton("Pizzaria");
	
	JButton c =new JButton("Client");
	
	public Pizzaria pizzaria;
	
public View1 (Pizzaria piz)	{
	pizzaria=piz;
	CView1 m=new CView1(pizzaria);
	
	p.addActionListener(m);
	c.addActionListener(m);
	
	BorderLayout b = new BorderLayout();
	
	GridLayout g = new GridLayout (1,2,50,20);

	JPanel texte = new JPanel ();
	JPanel choix = new JPanel();
	
	texte.setLayout(b);
	choix.setLayout(g);
	
	choix.add(p);
	choix.add(c);
	
	nam = new JLabel(pizzaria.adresse, SwingConstants.CENTER);
	n=new JLabel(pizzaria.nom, SwingConstants.CENTER);

	texte.setBackground(Color.WHITE);
	choix.setBackground(Color.WHITE);
	
	texte.add(BorderLayout.NORTH,n);
	texte.add(BorderLayout.SOUTH,nam);
	texte.add(BorderLayout.CENTER,choix);
	
	choix.setBorder(new EmptyBorder(100, 100, 100, 100));
	n.setBorder(new EmptyBorder(50, 0, 50, 0));
		
	n.setFont(new Font("Arial", Font.PLAIN, 60));
	p.setFont(new Font("Arial", Font.PLAIN, 40));
	c.setFont(new Font("Arial", Font.PLAIN, 40));	
	nam.setFont(new Font ("Sanserif", Font.ITALIC, 20));
	
	this.getContentPane().add(texte);
	this.pack();
	this.show();
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}


}
	









