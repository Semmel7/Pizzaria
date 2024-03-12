package view;
import model.Client;
import javax.swing.*;
import java.awt.*;
import controleur.CView5s;

// affichage pour crediter le compte du client

public class View5s extends JFrame {
	
	JLabel val;
	
	JTextField jt = new JTextField("0");
	
	JButton cr =new JButton("Crediter");
	
	Client c;
	
	public View5s (Client cl) {
		c=cl;
		
		double solde=c.solde;
		
		val=new JLabel(String.format("%.2f",solde)+" €");
		
		JPanel jp=new JPanel();
		
		BorderLayout b=new BorderLayout();
		
		CView5s o=new CView5s(jt,c,val);
		
		cr.addActionListener(o);
		
		jp.setLayout(b);
		
		jp.add(BorderLayout.NORTH,val);
		jp.add(BorderLayout.CENTER,jt);
		jp.add(BorderLayout.SOUTH,cr);
		
		this.getContentPane().add(jp);
		this.setLocation(270,160);
		this.setSize(200,120);		
	}
}
