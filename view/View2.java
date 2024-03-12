package view;
import model.Pizzaria;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import controleur.CView2;

// affichage de la page d'identification de la pizzaria

public class View2 extends JFrame {
	
	Pizzaria piz;
	
	JTextField jt = new JTextField("");
	
	JLabel jl=new JLabel("ENTREZ MOT DE PASSE", SwingConstants.CENTER);
	
	JButton v=new JButton("Valider");
	
	public View2(Pizzaria p) {
		piz=p;
		
		CView2 z=new CView2(jt,piz,this);
		
		JPanel mdp = new JPanel();
		
		GridLayout a=new GridLayout(3,1,50,30);
		
		jt.setBorder(new LineBorder(Color.decode("#eeeeee"),10));
		
		Font f=new Font("SansSerif", Font.BOLD, 20);
		
		jt.setFont(f);
		
		jt.addActionListener(z);		
		v.addActionListener(z);
		
		mdp.setLayout(a);
		
		mdp.add(jl);
		mdp.add(jt);
		mdp.add(v);
		
		this.getContentPane().add(mdp);
		this.setLocation(200,100);
		this.setSize(200,250);
		this.show();
		
	}
	
}
