package pubV0;

public class Drink extends Item {
	private int max_allowed;
	private boolean discount;
	
	Drink(String name, int price, int max_allowed, boolean discount) {
		this.price = price;
		this.name = name;
		this.max_allowed = max_allowed;
		this.discount = discount;
	}
	
	public int getMax() { return this.max_allowed; }
	public boolean hasDiscount() { return this.discount; }
	public void setDiscount() { this.discount = true; }
	public void remDiscount() { this.discount = false; }
	public void changeMax(int newMax) { this.max_allowed = newMax; }
}