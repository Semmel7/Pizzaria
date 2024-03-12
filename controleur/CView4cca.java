package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.Pizzaria;

public class CView4cca implements ActionListener{
	
	JComboBox<String> jt;
	
	JLabel j1;
	
	JLabel j2;
	
	JPanel jp;
	
	Pizzaria piz;
	
	public CView4cca (JComboBox<String> co, Pizzaria p, JPanel j) {
		jt=co;
		piz=p;
		jp=j;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()).getText().equals("Calculer CA")) {
			j1=new JLabel(jt.getSelectedItem()+"");
			
			// si on a selectionne le nom de la pizzaria
			if(j1.getText().equals(piz.nom)) {
				
				// on calcul le ca de la pizzaria, on me le resultat dans j2
				j2=new JLabel(jt.getSelectedItem()+"   "+(piz.CA())+" €");		
			}else {
				
				// sinon on calcule le ca du client selectionne, on me le resultat dans j2
				String ca=new String ((piz.ClientExiste(Integer.parseInt(jt.getSelectedItem()+"")).getchiffreAffaire())+"");
				j2=new JLabel(jt.getSelectedItem()+"   "+ca+" €");
			}
			
			// on met a jour le panel
			jp.add(j2);
			SwingUtilities.updateComponentTreeUI(jp);
		}
	}
}
