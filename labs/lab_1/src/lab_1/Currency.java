package lab_1;

// Q5 - criar a classe Currency
public class Currency {	
	public Currency(String currency)
	{ _currency = currency;	}
	
	public String getCurrency()
	{ return _currency; }

	public void setCurrency(String currency)
	{ this._currency = currency; }
	
	public int getBRLchange()
	{ return this._toBRL;}
	
	public void setBRLchange(int change)
	{ this._toBRL = change; }

	private String _currency;
	private int _toBRL;
}