package lab_1;

// Q1 - criar a classe Money
class Money implements abstractMoney {
	public Money(String currency) {
		this._currency = new Currency(currency);
		this.setBRLchange(0);
		this.setAmount(0);
	}
	
	// Q10 - add() retorna um objeto Money se as Currencies combinam e retorna um objeto MoneyBag caso contrário
	public abstractMoney add(Money m) {
		if(m.getCurrency() == this.getCurrency()) {
			Money money = new Money(this.getCurrency());
			money.setAmount(this.getAmount() + m.getAmount());
			money.setBRLchange(this.getBRLchange());
			return money;
		}
		else {
			MoneyBag mbag = new MoneyBag();
			mbag.add(m);
			mbag.add(this);
			return mbag;
		}
	}
	
	public int getAmount()
	{ return _amount; }
		
	public void setAmount(int amount)
	{ this._amount = amount; }
	
	public String getCurrency()
	{ return this._currency.getCurrency(); }

	public void setCurrency(String currency)
	{ this._currency.setCurrency(currency); }
	
	public int getBRLchange()
	{ return this._currency.getBRLchange(); }
	
	public void setBRLchange(int change)
	{ this._currency.setBRLchange(change); }
	
	public int getBRLvalue()
	{ return this.getAmount() * this._currency.getBRLchange(); }
		
	private int _amount;
	private Currency _currency;
}