package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controleur.CView3c;
import model.Client;
import model.Pizzaria;

// affichage de l'interface client

public class View3c extends JFrame{
	
	Client c;
	
	JLabel n;
	
	JButton cred = new JButton("solde");
	
	JButton com = new JButton ("commander");

	Pizzaria piz;
	
	public View3c (Client cl,Pizzaria p) {
		piz=p;
		c=cl;
		
		CView3c m=new CView3c(c,piz);
		
		cred.addActionListener(m);
		com.addActionListener(m);
		
		n=new JLabel(cl.num+"",SwingConstants.CENTER);
		
		BorderLayout b = new BorderLayout();
		
		GridLayout g = new GridLayout (1,2,50,20);

		JPanel texte = new JPanel ();
		JPanel choix = new JPanel();
		
		texte.setLayout(b);
		choix.setLayout(g);
		
		choix.add(cred);
		choix.add(com);
		
		choix.setBorder(new EmptyBorder(100, 100, 100, 100));

		texte.setBackground(Color.WHITE);
		choix.setBackground(Color.WHITE);
		
		texte.add(BorderLayout.CENTER,choix);		
		texte.add(BorderLayout.NORTH,n);
		
		n.setBorder(new EmptyBorder(50, 0, 50, 0));
				
		n.setFont(new Font("Arial", Font.PLAIN, 60));
		cred.setFont(new Font("Arial", Font.PLAIN, 40));
		com.setFont(new Font("Arial", Font.PLAIN, 40));
		
		this.getContentPane().add(texte);
		this.pack();
		this.show();
		
		
	}
	
	
}
