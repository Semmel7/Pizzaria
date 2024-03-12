package controleur;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import model.Pizzaria;

public class CView5ing implements ActionListener {
	
	JComboBox<String> pizza;
	
	Pizzaria piz;
	
	JLabel jlabel1;
	
	JLabel jlabel2;
	
	JPanel jp;
	
	public CView5ing(JComboBox<String> p,Pizzaria pi,JPanel j) {
		pizza=p;
		piz=pi;
		jp=j;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals("Get")) {
			Font f=new Font("SansSerif", Font.BOLD, 14);
			
			// on ecrit dans le JLabel le nom de la pizza selectionne
			jlabel1=new JLabel(pizza.getSelectedItem()+"");
			
			// on lui applique une police et on l'ajoute au panel, puis on met a jour le panel
			jlabel1.setFont(f);
			jp.add(jlabel1);
			SwingUtilities.updateComponentTreeUI(jp);
			
			// on parcoure la liste de pizza du catalogue
			for(int i=0; i<piz.cat.liste.size();i++) {
				
				// prend la pizza selectionne
				if(piz.cat.liste.get(i).nom.equals(pizza.getSelectedItem()+"")) {
					
					// on parcoure la liste de ses ingredients
					for(int j=0;j<piz.cat.liste.get(i).getIng().size();j++) {
						
						// on affiche le nom et la quantite utilise pour la recette
						jlabel2=new JLabel(piz.cat.liste.get(i).getIng().get(j).nom+" "+piz.cat.liste.get(i).listRecette.get(j).qt+"");
						jp.add(jlabel2);
						
						// on met a jour le panel
						SwingUtilities.updateComponentTreeUI(jp);
					}
				}
			}
		}
	}
}

