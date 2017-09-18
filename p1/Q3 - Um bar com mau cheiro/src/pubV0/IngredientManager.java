package pubV0;

import java.util.ArrayList;

public class IngredientManager implements Manager {
    private ArrayList<Ingredient> Ingredients;
    
    IngredientManager() {
    	Ingredients = new ArrayList<Ingredient>();
    	this.setItems();
    }

	public void setItems() { //Utilizar o DataBase
    	this.addItem("rum", 65);
    	this.addItem("grenadine", 10);
    	this.addItem("lime juice", 10);
    	this.addItem("green stuff", 10);
    	this.addItem("tonic water", 20);
    	this.addItem("gin", 85);
    }
    
    public void addItem(String name, int price) {
    	Ingredients.add(new Ingredient(name, price));
    }
    
    public void remItem(String name) {
    	for(int i = 0; i < this.Ingredients.size(); i++)
    		if(Ingredients.get(i).getName() == name) {
    			Ingredients.remove(i);
    			break;    	
    		}
    }
        
    public Ingredient getItem(String name) {    	
    	for(int i = 0; i < this.Ingredients.size(); i++)
    		if(Ingredients.get(i).getName() == name)
    			return Ingredients.get(i);    	
    	throw new RuntimeException("No such ingredient");
    }
    
    public int getPrice(String name) {
    	return this.getItem(name).getPrice();
    }
}