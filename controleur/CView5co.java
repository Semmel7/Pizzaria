package controleur;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import model.Pizzaria;
import model.Client;
import model.Commande;
import model.LigneCommande;
import model.Pizza;
import view.View5com;
import view.View5co;

public class CView5co implements ActionListener {
	
	JComboBox<String> jt;
	
	JComboBox<String> jb;
	
	JTextField jf;
	
	View5co v;
	
	JPanel jp;
	
	Vector<LigneCommande> lnCom;
	
	Pizzaria piz;
	
	Client client;
	
	Commande com;
	
	JDesktopPane frame;
	
	Vector <JLabel> jla = new Vector <JLabel>();
	
	public int[]quantite;
	
	int pts;
	
	public CView5co(JComboBox<String> j,JComboBox<String> j1,JTextField jF,View5co v5c,JPanel p,Vector<LigneCommande> lc,Pizzaria pi,Client cl,JDesktopPane f) {
		lnCom=lc;
		jf=jF;
		jb=j1;
		jt=j;
		jp=p;
		v=v5c;
		piz=pi;
		client = cl;
		com=new Commande (client,piz,lnCom);
		frame=f;
		pts = client.points_fidelite;
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if(((JButton)e.getSource()).getText().equals("Add")) {
			
			// on recupere la quantite de pizzas de la ligne commande(que le client a tape)
			int i= Integer.parseInt(jf.getText());
			
			// on recupere la pizza que le client a selectionne
			Pizza pizza=piz.cat.byname(jt.getSelectedItem()+"");
			
			// on recupere la taille
			String s=(String)jb.getSelectedItem();
			
			// et on cree la ligne de commande corespondante
			LigneCommande ln=new LigneCommande(i,s,pizza,com);

			// on l'ajoute a la liste des lignes commandes de la commande
			lnCom.add(ln);
			
			// on calcule le prix de la ligne de commande
			double prix = ln.calcPrix();
			
			// on ecrit le recapitulatif de la ligne commande 
			JLabel jl=new JLabel(jt.getSelectedItem()+"  "+s+"  "+i+"  "+String.format("%.2f",prix)+" €");
			
			// on ajoute ce JLabel au vector JLabel et au panel, puis on actualise le panel
			jla.add(jl);
			jp.add(jla.get(jla.size()-1));			
			SwingUtilities.updateComponentTreeUI(jp);		
		}
	
		if(((JButton)e.getSource()).getText().equals("Valider")) {
			
			// on verifie que la commande n'est pas vide
			if(com.lnCom.size()>0){
				
				// on stock dans un tableau la quantite d'ingredient de chaque ingredient de la pizzaria avant commande
				int[] restore = new int[piz.listIngredient.size()];
				for(int i=0;i<piz.listIngredient.size();i++) {
					restore[i]=piz.listIngredient.get(i).qt;
				}
				
				// on verifie que la commande est faisable 
				if(com.Faisable().equals("oui")) {
					
					// on initialise le tableau quantite qui va contenir le nombre de pizza de chaque ligne de commande
					quantite=new int[com.lnCom.size()];
					for(int i=0;i<com.lnCom.size();i++) {
						quantite[i]=com.lnCom.get(i).qt;
					}
					
					// si le client est eligible a une ou plusieurs pizza gratuite
					if(piz.fidelite(client)>0) {
						
						// on parcoure les listes de commandes
						for(int i=0;i<com.lnCom.size();i++) {
							
							// on cree une nouvelle ligne commande correspondante a la i eme ligne commande
							LigneCommande l=com.lnCom.get(i);
							
							// on cree un entier corrrespondant au nombre de pizza gratuite que le client a droit
							int gratuit = piz.fidelite(client);
							
							// si le nb de pizza gratuite est superieur a la quantite de pizza de la ligne commande
							if(gratuit>l.qt) {
								
								// on decremente les points_fidelite du client
								client.points_fidelite=client.points_fidelite-10*l.qt;
								
								// ainsi que le nombre de pizza gratuite dont il a le droit
								gratuit=gratuit-l.qt;
								
								// on met la quantite de pizza de la ligne commande a 0
								l.qt=0;
								
								// et on met cette ligne commande a la place de la i eme ligne commande de base
								com.lnCom.set(i, l);
							}else {
								
								// on decremente de la quantite de pizza de la ligne commande le nombre de pizza gratuite du client
								l.qt=l.qt-gratuit;
								
								// et on met cette ligne commande a la place de la i eme ligne commande de base
								com.lnCom.set(i, l);
								
								// on decremente les points_fidelite du client
								client.points_fidelite=client.points_fidelite-10*gratuit;			
							}	
						}
					}
					
					// on verifie que le client a un solde suffisant pour passer la commande (apres deduction des pizzas gratuites si il y en avait)
					if(com.solde()) {
						
						// on affiche le recapitulatif de la commande a la place de la page pour afficher commande
						View5com valide=new View5com(com,frame,client,this);
						
						// on ajoute cette commande a la liste commande du client ainsi que celle du livreur	
						client.listCom.add(com);
						com.livreur.ajouterCommande(com);
						v.dispose();		
						valide.show();			
					}
					else {
						
						// la commande etait faisable mais le client n'a pas un solde suffisant, on lui restaure ses points de fidelite enleve au moment de la verification
						client.points_fidelite=pts;
						
						// et on affiche un message comme quoi le solde est insuffisant
						JFrame jFrame = new JFrame();
						JOptionPane.showMessageDialog(jFrame," Solde insuffisant ");
					}
				}else {
					
					// la commande n'est pas faisable on affiche un message d'erreur
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame," Commande infaisable :"+com.Faisable());
			        
			        // on restaure les ingredients de la pizzaria (car au moment de verifier on decrementait les quantites d'ingredient)
			        for(int i=0;i<piz.listIngredient.size();i++) {
						piz.listIngredient.get(i).qt=restore[i];
					}
				}
			}
		}
	
		if(((JButton)e.getSource()).getText().equals("Retirer")) {
			if(com.lnCom.size()>0){
				
				// on retire de la commande la derniere ligne commande
				com.retirerLigneCommande(com.lnCom.get(com.lnCom.size()-1));
				
				// on retire du jpanel et du vector JLabel le dernier JLabel
				jp.remove(jla.get(jla.size()-1));
				jla.remove(jla.size()-1);
				
				// on actualise le panel
				SwingUtilities.updateComponentTreeUI(jp);
			}
		}		
	}
}
