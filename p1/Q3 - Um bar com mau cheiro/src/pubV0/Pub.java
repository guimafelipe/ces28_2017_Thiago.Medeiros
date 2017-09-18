package pubV0;

public class Pub {
    private DrinkManager DrkManager;
    private IngredientManager IngManager;
    
    Pub() {
    	IngManager = new IngredientManager();    	
    	DrkManager = new DrinkManager(IngManager);
    }
        
    public int computeCost(String drink, boolean student, int amount) {
    	Drink Drk = this.DrkManager.getItem(drink);
        	
        if (Drk.getMax() >= 0 && amount > Drk.getMax())
            throw new RuntimeException("Too many drinks, max " + Drk.getMax() + ".");
        
        int price = Drk.getPrice();        

        if (student && Drk.hasDiscount())
            price = (int) Math.ceil(price - price/10);
        
        return price * amount;
    }
}