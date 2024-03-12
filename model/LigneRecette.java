package model;

public class LigneRecette {
	
	public Ingredient ing;
	
	public int qt;
    
	public LigneRecette(int q,Ingredient i) {
    	qt=q;
    	ing = i;
    }   
}