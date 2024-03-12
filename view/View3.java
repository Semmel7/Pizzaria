package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import controleur.CView3;
import model.Pizzaria;

// affichage page identifiacation client

public class View3 extends JFrame {
	
	JTextField jt = new JTextField("");
	
	JLabel jl=new JLabel("ENTREZ VOTRE NUMERO DE TELEPHONE", SwingConstants.CENTER);
	
	JButton v=new JButton("Valider");
	
	Pizzaria piz;
	
	public View3(Pizzaria p) {
		piz=p;
		
		CView3 z=new CView3(jt,piz,this);
		
		JPanel num = new JPanel();
		
		GridLayout a=new GridLayout(3,1,50,30);
		
		jt.setBorder(new LineBorder(Color.decode("#eeeeee"),10));
		
		Font f=new Font("SansSerif", Font.BOLD, 20);
		
		jt.setFont(f);
		
		jt.addActionListener(z);
		v.addActionListener(z);
		
		num.setLayout(a);
		
		num.add(jl);
		num.add(jt);
		num.add(v);
		
		this.getContentPane().add(num);
		this.setLocation(160,100);
		this.setSize(270,240);
		this.show();
	}
		

}
