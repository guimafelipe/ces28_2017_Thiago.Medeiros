import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import DB.DB_PS;
import DB.IV;
import Exceptions.DBInvalido;
import Exceptions.IVNaoPresenteNoDB;
import Exceptions.QuantidadeInvalida;
import NotaFiscal.NotaFiscal;

public class Item_13 {
private DB_PS DB_prod_serv;
	@Before
	public void setUp() {
		this.DB_prod_serv = DB_PS.getInstance(); // Devem ser substituido por mock !!!
	}
	
	@Test
	public void modificando_adicionando_e_deletando_IVs()
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, DBInvalido {		
		
		NotaFiscal NF = NotaFiscal.create(100, 3, "", this.DB_prod_serv);
		
		IV PS_1 = NF.getItem(100);
		assertEquals(PS_1.getQuantidade(), 3);
		
		NF.setQuantidade(100, 4);

		IV PS_2 = NF.getItem(100);
		assertEquals(PS_2.getQuantidade(), 4);

		NF.mudaQuantidade(100, 2);

		IV PS_3 = NF.getItem(100);
		assertEquals(PS_3.getQuantidade(), 6);

		NF.addIV(200, 3);
		
		IV PS_4 = NF.getItem(200);
		assertTrue(PS_4 != null);

		NF.addIV(300, 1);

		IV PS_5 = NF.getItem(300);
		assertTrue(PS_5 != null);

		NF.removeIV(200);

		IV PS_6 = NF.getItem(200);
		assertTrue(PS_6 == null);
	}
}
