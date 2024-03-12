package view;
import javax.swing.*;
import java.awt.*;
import model.Commande;

// vue de l'affichage des n dernieres commandes d'un client

public class Vie5comm extends JInternalFrame{
	
	Commande com;
	
	JDesktopPane frame;
	
	public Vie5comm(Commande c,JDesktopPane j) {
		com=c;
		frame=j;
		
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setSize(300,300);
		this.setLocation(370,0);
		
		Font f=new Font("SansSerif", Font.BOLD, 12);
		
		JPanel jp=new JPanel();
		JPanel liste=new JPanel();
		
		GridLayout g=new GridLayout(com.lnCom.size(),1);
		
		BorderLayout b=new BorderLayout();
		
		jp.setLayout(b);
		liste.setLayout(g);
		
		// affichage du num client, du nombre de pizza et du nom du livreur
		JLabel top=new JLabel(com.client.num+"  "+com.nbPizza()+" pizzas"+"  "+com.livreur.nom+" "+com.livreur.transport,SwingConstants.CENTER);
				
		// affichage de chaque ligne de commande
		for (int i=0;i<com.lnCom.size();i++) {
			String nom =com.lnCom.get(i).pizza.nom;
			String taille =com.lnCom.get(i).taille;
			int qt =com.lnCom.get(i).qt;
			double lnPrix=com.lnCom.get(i).calcPrix();
			JLabel list=new JLabel(nom+"  "+taille+"  "+qt+"   "+String.format("%.2f",lnPrix)+" €");
			liste.add(list);
		}
		
		double t=com.Prix();
		
		// affichage du prix total de la commande
		JLabel total=new JLabel("TOTAL="+String.format("%.2f",t)+" €");
		
		top.setFont(f);
		total.setFont(f);
		
		jp.add(BorderLayout.NORTH,top);
		jp.add(BorderLayout.SOUTH,total);
		jp.add(BorderLayout.CENTER,liste);
		
		this.add(jp);
		frame.add(this);		
	}	
}
