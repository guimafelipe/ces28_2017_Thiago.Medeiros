package lab_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class JUnitMoney {
	// Q4 - usar Before e extrair fixture de um método setUp
	@Before
	public void setUp() {
		Wallet_1 = new Money("USD");
		Wallet_1.setAmount(4000);
		Wallet_1.setBRLchange(3);

		Wallet_2 = new Money("EUR");
		Wallet_2.setAmount(3000);
		Wallet_2.setBRLchange(4);

		Wallet_3 = new Money("EUR");
		Wallet_3.setAmount(1000);
		Wallet_3.setBRLchange(4);
}
	
	// Q2 - criar o test para add() com base em assertTrue
	@Test
	public void whenAddingCheckIfAmountIsBiggerThan1000() {
		if(Wallet_2.add(Wallet_3) instanceof Money) {
			Money Wallet = (Money) Wallet_2.add(Wallet_3);
			assertTrue(Wallet.getAmount() > 1000);
			return;
		}
		fail();
	}
	
	// Q3 - criar o test para add() com base em assertEquals
	@Test
	public void whenAddingChecksIfThereIsEURCorrency() {
		if(Wallet_1.add(Wallet_2) instanceof MoneyBag) {
			MoneyBag Wallet = (MoneyBag) Wallet_1.add(Wallet_2);
			for(int i = 0; i < Wallet.consultSize(); i++)
			{ assertEquals(Wallet.consultIndex(i).getCurrency(), "EUR"); }
		}
		else {
			Money Wallet = (Money) Wallet_1.add(Wallet_2);
			assertEquals(Wallet.getCurrency(), "EUR"); 
		}
	}
	
	@Test
	public void checksIfBRLValueIsBiggerThan10000()
	{ assertTrue(Wallet_1.getBRLvalue() > 10000); }
	
	@Test
	public void checksIfBRLValuesAreEqual()
	{ assertEquals(Wallet_1.getBRLvalue(), Wallet_2.getBRLvalue()); }
		
	private Money Wallet_1, Wallet_2, Wallet_3;
}

// Q6 - refatorar os testes (OK)