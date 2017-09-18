package lab_1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

//Q8 - testar os métodos de MoneyBag
public class JUnitMoneyBag {
	@Before
	public void setUp() {
		mB = new MoneyBag();
		
		Money USD = new Money("USD");
		USD.setAmount(2601);
		USD.setBRLchange(3);

		Money EUR = new Money("EUR");
		EUR.setAmount(300);
		EUR.setBRLchange(4);
		
		Money CHF = new Money("CHF");		
		CHF.setAmount(500);
		CHF.setBRLchange(2);
		
		mB = (MoneyBag) mB.add(USD);
		mB = (MoneyBag) mB.add(EUR);
		mB = (MoneyBag) mB.add(CHF);
	}

	@Test
	public void MoneyInBagIsBiggerThan10000BRL()
	{ assertTrue(mB.totalBRL() > 10000); }
	
	@Test
	public void ChecksIfNumberOfCurrenciesInTheBagIsEqualTo3()
	{ assertTrue(mB.consultSize() == 3); }
	
	@Test
	public void ChecksIfThereIsEURInTheBag() {
		for(int i = 0; i < mB.consultSize(); i++) {
			if(mB.consultIndex(i).getCurrency() == "EUR") {
				assertTrue(mB.consultIndex(i).getCurrency() == "EUR");
				return;
			}
		}
		fail();
	}
		
	private MoneyBag mB;
}