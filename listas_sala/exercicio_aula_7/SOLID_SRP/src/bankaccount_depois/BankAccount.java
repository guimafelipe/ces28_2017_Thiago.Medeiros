package bankaccount_depois;

public abstract class BankAccount {
	public void setBalance(double amount) {
		_balance = amount;
	}
	
	public double Balance() {
		return _balance;
	};

	public void Deposit(double amount) {
		_balance += amount;
	};

	public void Withdraw(double amount) {
		_balance -= amount;
	};

	private double _balance;
}