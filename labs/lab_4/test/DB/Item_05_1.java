package DB;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import Exceptions.IVNaoPresenteNoDB;
import Exceptions.QuantidadeInvalida;
import NotaFiscal.NotaFiscal;

//Testes para o requisito 5:
//-> Só podem ser adicionados a uma nota fiscal produtos pu serviços que estejam
//   cadastrados no BD:P/S

//O outro teste relacionado teste está no package

public class Item_05_1 {
	
	private DB_PS DB_prod_serv;
	private API_DB_PS API_prod_serv;

	@Before
	public void setup()
	{
		this.DB_prod_serv = mock(DB_PS.class);
		this.API_prod_serv = API_DB_PS.getInstance();
		when(DB_prod_serv.isInDB(568)).thenReturn(false); //O item de id 568 não está na DB.
		when(DB_prod_serv.isInDB(100)).thenReturn(true);
		when(DB_prod_serv.getItem(100)).thenReturn(new Produto("nome",10.00,"outros"));
		this.API_prod_serv.setDB(DB_prod_serv);
	}
	
	@Test
	public void Falha_ao_instanciar_NF_com_PS_inexistente_no_BD() 
		   throws QuantidadeInvalida, IVNaoPresenteNoDB {
		
		int id_exemplo  = 568,   // Tentar instanciar uma NF com a "id" de um PS que não está no BD
			qtd_exemplo = 1;      // resulta em uma exceção.

		try {
			NotaFiscal.create(id_exemplo, qtd_exemplo, "");
			fail();
		}
		catch (IVNaoPresenteNoDB expect) {
			assertEquals("IV nao existe no DB!\n", expect.getMessage());
		}
	}
	
	@Test
	public void Falha_ao_adicionar_PS_inexistente_a_uma_NF_já_criada() 
		   throws QuantidadeInvalida, IVNaoPresenteNoDB {
		
		int id_exemplo1  = 100,
			qtd_exemplo1 = 1;
		int id_exemplo2  = 568,
			qtd_exemplo2 = 1;
		
		NotaFiscal NF = NotaFiscal.create(id_exemplo1, qtd_exemplo1, "");
		
		try {
			NF.addIV(id_exemplo2, qtd_exemplo2);
			fail();
		}
		catch (IVNaoPresenteNoDB expect) {
			assertEquals("IV nao existe no DB!\n", expect.getMessage());
		}
	}
}
