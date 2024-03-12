package model;

public class Ingredient {

    public String nom;
   
    public int qt;
    
    public Ingredient(String n,int q) {
    nom = n;
    qt=q;
    }
    
	public void suppqt(int quant) {
	//retire une quantite d ingredient 
	
		if(quant<=qt){
	    qt=qt-quant;
		}else{
	    qt=0;
		}
	}
}