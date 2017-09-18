package lab_1;

import java.util.ArrayList;

// Q7 - criar a classe MoneyBag
public class MoneyBag implements abstractMoney {
	public MoneyBag()
	{ Bag = new ArrayList(); }
	
	public abstractMoney add(Money m) {
		boolean alreadyHere = false;
		MoneyBag mB = new MoneyBag();
		
		for(int i = 0; i < this.consultSize(); i++) {
			if(this.consultIndex(i).getCurrency() == m.getCurrency()) {
				Money aux = new Money(m.getCurrency());
				aux.setAmount(this.consultIndex(i).getAmount() + m.getAmount());
				aux.setBRLchange(m.getBRLchange());
				mB.appendMoney(aux);
				alreadyHere = true;
			}
			else 
			{ mB.appendMoney(this.consultIndex(i)); }
		}
		
		if(!alreadyHere)
		{ mB.appendMoney(m); }
		
		return mB;
	}
	
	public void appendMoney(Money m)
	{ Bag.add(m); }
				
	// Q9 - mostrar as moedas de MoneyBag
	public void showMoney() {
		System.out.println("Money in the Bag:");
		for(int i = 0; i < this.consultSize(); i++)
		{ System.out.println(this.consultIndex(i).getCurrency() + ": " + Integer.toString(this.consultIndex(i).getAmount())); }
	}
	
	// Q11 - criar um método para retornar o valor total em BRL das moedas
	public int totalBRL() {
		int sum = 0;
		for(int i = 0; i < this.consultSize(); i++)
		{ sum += this.consultIndex(i).getBRLvalue(); }		
		return sum;
	}
	
	public Money consultIndex(int i)
	{ return Bag.get(i); }
	
	public int consultSize()
	{ return Bag.size(); }
	
	public ArrayList <Money> Bag;
}