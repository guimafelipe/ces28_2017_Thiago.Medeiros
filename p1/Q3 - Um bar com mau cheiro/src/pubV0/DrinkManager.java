package pubV0;

import java.util.ArrayList;

public class DrinkManager implements Manager{
    private ArrayList<Drink> Drinks;
    private IngredientManager IngManager;
    
    DrinkManager(IngredientManager IngManager) {
    	this.IngManager = IngManager;
    	Drinks = new ArrayList<Drink>();
    	this.setItems();
    }
    
    public void setItems() { //Utilizar DataBase
    	this.addItem("hansa", 74, -1, true);        //
    	this.addItem("grans", 103, -1, true);       // "-1" significa "ilimitado"
    	this.addItem("strongbow", 110, -1, true);   //
    	
    	String[] ing_GT = {"green stuff", "tonic water", "gin"};
    	int[] qtt_GT = {1, 1, 1};
    	this.addMix("gt", ing_GT, qtt_GT, 2, false);
    	
    	String[] ing_Bacardi = {"rum", "grenadine", "lime juice", "gin"};
    	int[] qtt_Bacardi = {1, 1, 1, 1};
    	this.addMix("bacardi_special", ing_Bacardi, qtt_Bacardi, 2, false);
    }
    
    public void addItem(String name, int price, int max_allowed, boolean discount) {
    	Drinks.add(new Drink(name, price, max_allowed, discount));
    }
    
    public void remItem(String name) {
    	for(int i = 0; i < this.Drinks.size(); i++)
    		if(Drinks.get(i).getName().equals(name)) {
    			Drinks.remove(i);
    			break;    	
    		}
    }
    
    void addMix(String name, String[] ingredients, int[] quantities, int max_allowed, boolean discount) {
    	int price = 0;
    	for(int i = 0; i < ingredients.length; i++)
    		price += IngManager.getPrice(ingredients[i]) * quantities[i];
    	this.addItem(name, price, max_allowed, discount);
    }
    
    public Drink getItem(String name) {
    	for(int i = 0; i < this.Drinks.size(); i++)
    		if(Drinks.get(i).getName() == name)
    			return Drinks.get(i);
    	throw new RuntimeException("No such drink");
    }
    
    public void setDiscount(String name) {
    	for(int i = 0; i < this.Drinks.size(); i++)
    		if(Drinks.get(i).getName() == name) {
    			Drinks.get(i).setDiscount();
    			return;
    		}
    	throw new RuntimeException("No such drink");    	
    }
    
    public void remDiscount(String name) {
    	for(int i = 0; i < this.Drinks.size(); i++)
    		if(Drinks.get(i).getName() == name) {
    			Drinks.get(i).remDiscount();
    			return;
    		}
    	throw new RuntimeException("No such drink");    	
    }
    
    public void changeMax(String name, int newMax) {
    	for(int i = 0; i < this.Drinks.size(); i++)
    		if(Drinks.get(i).getName() == name) {
    			Drinks.get(i).changeMax(newMax);
    			return;
    		}
    	throw new RuntimeException("No such drink");    	
    }
        
    public int getPrice(String name) {
    	return this.getItem(name).getPrice();
    }
}
