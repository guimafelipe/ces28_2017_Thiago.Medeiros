package bankaccount_depois;

public class Transfer {
	static public void transfer(BankAccount Payer, BankAccount Receiver,double amount) {
		Payer.Withdraw(amount);
		Receiver.Deposit(amount);
	};
}