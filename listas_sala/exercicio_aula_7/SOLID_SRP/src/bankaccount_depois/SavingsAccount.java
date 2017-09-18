package bankaccount_depois;

public class SavingsAccount extends BankAccount {
	public void AddInterest(double amount) {
		this.Deposit(amount);
	};
}