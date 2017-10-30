import org.junit.Test;

import DB.DB_PS;
import NotaFiscal.NotaFiscal;

public class testNF {
	@Test
	public void test() {
		DB_PS DB_prod_serv = new DB_PS();
		
		NotaFiscal NF = NotaFiscal.create(100, 1, DB_prod_serv);
		
		NF.addIVtoNF(200, 1);
		NF.addIVtoNF(300, 5);
		NF.addIVtoNF(400, 2);

		System.out.println(NF.checkNotaFiscal());
		
		NF.removeIVfromNF(300);
		
		System.out.println(NF.checkNotaFiscal());		
	}
}