package controleur;
import java.awt.Font;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import model.Pizzaria;
import model.LigneRecette;
import model.Pizza;
import view.View4pa;
import view.View4p;

public class CView4pa implements ActionListener {
	
	JTextField j1;
	
	JTextField j2;
	
	JComboBox<String> jbx;
	
	JTextField j4;
	
	JLabel jLabel1;
	
	JLabel jLabel2;
	
	JLabel jLabel3;
	
	JLabel jLabel4;
	
	View4pa v;
	
	JPanel jp;
	
	Vector<LigneRecette> lnRe;
	
	Pizzaria piz;
	
	Vector <JLabel> jla = new Vector <JLabel>();
	
	public CView4pa(JTextField t1,JTextField t2,JComboBox<String> j3,JTextField t4,View4pa vi,JPanel p,Vector<LigneRecette> lr,Pizzaria pi) {
		j1=t1;
		j2=t2;	
		jbx=j3;	
		j4=t4;
		v=vi;
		jp=p;
		lnRe=lr;
		piz=pi;
	}
	
	// cette variable va nous servir lors de l'affichage du nom de la pizza cree (pour l'afficher qu'une seule fois)
	boolean n = true;
	
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals("Ajouter")) {
			if(n) {
				
				// si n est vrai c'est que l'on vient de rentrer le nom pour la premiere fois, on affiche donc le nom et le prix et la premiere ligne recette
				Font f=new Font("SansSerif", Font.BOLD, 12);
				jLabel1=new JLabel(j1.getText()+" "+j2.getText()+" €");
				jLabel3=new JLabel(j1.getText());
				jLabel4=new JLabel(j2.getText());
				jLabel1.setFont(f);
				jp.add(jLabel1);
				
				// on passe n a faux pour ne plus passer par cette etape la prochaine fois
				n=false;
			}
			
			// quantite d'ingredient pour la ligne recette
			int i= Integer.parseInt(j4.getText());
			
			// on cree une ligne recette
			LigneRecette l = new LigneRecette(i,piz.IngredientExiste((String)jbx.getSelectedItem()));
			
			// on l'ajoute au vector lnRe correspondant au vector ligne recette de la pizza que l'on va cree
			lnRe.add(l);
			
			// on ajoute au JLabel la ligne recette que l'on vient d'entrer
			jLabel2=new JLabel(j4.getText()+" "+(String)jbx.getSelectedItem());
			
			// on l'ajoute au vector et on met a jour le panel et son affichage
			jla.add(jLabel2);
			jp.add(jla.get(jla.size()-1));		
			SwingUtilities.updateComponentTreeUI(jp);			
		}
	
		if(((JButton)e.getSource()).getText().equals("Creer")) {
			
			// le prix de la pizza cree
			double d = Double.parseDouble(jLabel4.getText());
			
			// on creee la pizza
			Pizza pizza = new Pizza(jLabel3.getText(),d,lnRe,piz);
			
			// si elle n'exte pas dans le catalogue
			if(piz.cat.byname(pizza.nom)==null) {
				
				// on l'ajoute au catalogue
				piz.cat.ajouterPizza(pizza);
				
				// on met a jour la page avec le nouveau catalogue
				v.v1.dispose();
				View4p vie = new View4p(piz);
				vie.show();
			}else {
				
				// si la  pizza existe on indique un message d'erreur
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame," La pizza "+pizza.nom+" existe deja");
			}
		}
	
		if(((JButton)e.getSource()).getText().equals("Annuler")) {
			if(lnRe.isEmpty()==false) {
				
				// on supprime de lnRe la derniere ligne recette entre
				lnRe.remove(lnRe.get(lnRe.size()-1));
				
				// on supprime du panel le dernier jlabel
				jp.remove(jla.get(jla.size()-1));
				
				// on supprime du vector jlabel le dernier jlabel
				jla.remove(jla.size()-1);
				
				// et si le vector jlabel est vide, on supprime aussi du panel jLabel1 correspondant au nom et prix de la pizza	
				if(jla.size()==0) {
					jp.remove(jLabel1);
				
					// on repasse n a true pour pouvoir rentrer un nouveau nom de Pizza
					n=true;
				}
			
				// on met a jour le panel
				SwingUtilities.updateComponentTreeUI(jp);
			}		
		}	
	}
}
