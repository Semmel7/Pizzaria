package view;
import javax.swing.*;
import controleur.CView5co;
import java.awt.*;
import model.Commande;
import model.Client;

// sous-affichage (recapitulatif de la commande, une fois que le client la passe)

public class View5com extends JInternalFrame{
	
	Commande com;
	
	JDesktopPane frame;
	
	Client client;
	
	CView5co v5;
	
	public View5com(Commande c,JDesktopPane j,Client cl, CView5co vi) {
		com=c;
		frame=j;
		client=cl;
		v5=vi;
		
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
		
		for (int i=0;i<com.lnCom.size();i++) {
			String nom =com.lnCom.get(i).pizza.nom;
			String taille =com.lnCom.get(i).taille;
			int qt =v5.quantite[i];
			double lnPrix=com.lnCom.get(i).calcPrix();
			JLabel list=new JLabel(nom+"  "+taille+"  "+qt+"   "+String.format("%.2f",lnPrix)+" €");
			liste.add(list);
		}
		
		int nb_pizz=0;
		for(int i=0;i<com.lnCom.size();i++) {
			nb_pizz=nb_pizz+v5.quantite[i];
		}
		
		JLabel top=new JLabel(com.client.num+"  "+nb_pizz+" pizzas"+"  "+com.livreur.nom+" "+com.livreur.transport,SwingConstants.CENTER);
				
		double t=com.Prix();
		
		cl.solde=cl.solde-t;
		cl.nbCommande=cl.nbCommande+1;
		cl.points_fidelite=cl.points_fidelite+com.nbPizza();
		
		JLabel total=new JLabel("TOTAL="+String.format("%.2f",t)+" €");
		
		total.setFont(f);
		top.setFont(f);
		
		jp.add(BorderLayout.NORTH,top);
		jp.add(BorderLayout.SOUTH,total);
		jp.add(BorderLayout.CENTER,liste);
		
		this.add(jp);
		
		frame.add(this);		
	}	
}
