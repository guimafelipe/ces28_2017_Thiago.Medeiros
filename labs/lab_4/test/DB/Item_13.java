package DB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import DB.IV;
import Exceptions.IVNaoPresenteNoDB;
import Exceptions.QuantidadeInvalida;
import NotaFiscal.NotaFiscal;

public class Item_13 {
	
	private DB_PS DB_prod_serv;
	private API_DB_PS API_prod_serv;
	
	@Before
	public void setUp() {
		this.DB_prod_serv = mock(DB_PS.class);
		this.API_prod_serv = API_DB_PS.getInstance();

		
		Servico itemExemplo1 = new Servico("Serv_1", 1.00, "");
		Produto itemExemplo2 = new Produto("Prod_1", 3.00, "");
		Servico itemExemplo3 = new Servico("Serv_2", 5.00, "");
		
		when(DB_prod_serv.isInDB(100)).thenReturn(true);
		when(DB_prod_serv.isInDB(200)).thenReturn(true);
		when(DB_prod_serv.isInDB(300)).thenReturn(true);
		
		when(DB_prod_serv.getItem(100)).thenReturn(itemExemplo1);
		when(DB_prod_serv.getItem(200)).thenReturn(itemExemplo2);
		when(DB_prod_serv.getItem(300)).thenReturn(itemExemplo3);
		
		this.API_prod_serv.setDB(DB_prod_serv);
	}
	
	@Test
	public void modificando_adicionando_e_deletando_IVs()
		   throws QuantidadeInvalida, IVNaoPresenteNoDB {		
		
		NotaFiscal NF = NotaFiscal.create(100, 3, ""); // cria NF com item id=100
		
		IV PS_1 = NF.getItem(100);                     // verifica que o item foi 
		assertEquals(PS_1.getQuantidade(), 3);         // adicionado à nota
											   // - - - - - - - - - - - -
		NF.setQuantidade(100, 4);              // muda a quantidade do item id=100 de 3 para 4

		IV PS_2 = NF.getItem(100);             // verifica que a mudança
		assertEquals(PS_2.getQuantidade(), 4); // foi efetivada
		                                       // - - - - - - - - - - - -
		NF.mudaQuantidade(100, 2);             // muda a quantidade do item id=100 de 4 para 2

		IV PS_3 = NF.getItem(100);             // verifica que a mudança foi
		assertEquals(PS_3.getQuantidade(), 6); // efetivada
		                           // - - - - - - - - - - - -
		NF.addIV(200, 3);          // adiciona item id=200
		
		IV PS_4 = NF.getItem(200); // verifica que o item foi
		assertTrue(PS_4 != null);  // adicionado
		                           // - - - - - - - - - - - -
		NF.addIV(300, 1);          // adiciona item id=300

		IV PS_5 = NF.getItem(300); // verifica que o item foi 
		assertTrue(PS_5 != null);  // adicionado
		                           // - - - - - - - - - - - -
		NF.removeIV(200);          // remove item id=200

		IV PS_6 = NF.getItem(200); // verifica que o item
		assertTrue(PS_6 == null);  // foi removido
	}
}
