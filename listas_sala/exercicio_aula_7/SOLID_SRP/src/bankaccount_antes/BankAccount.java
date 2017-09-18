package bankaccount_antes;

//Checking and Savings Account
public class BankAccount {
	public double Balance() { return _balance; };
	public void Deposit(double amount) { };
	public void Withdraw(double amount) { };
	public void AddInterest(double amount) { };
	public void Transfer(double amount, BankAccount toAccount) { };
	
	private double _balance;
}