package DB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.Test;

import DB.API_DB_PS;
import DB.DB_PS;
import DB.Produto;
import Exceptions.IVNaoPresenteNoDB;
import Exceptions.QuantidadeInvalida;
import NotaFiscal.NotaFiscal;

// Testes para o requisito 1:
// -> NF não pode ter zero IV. Deve ter 1 ou mais.

public class Item_01 {
	private DB_PS DB_prod_serv;
	private API_DB_PS API_prod_serv;
	
	@Before
	public void setUp() {
		this.DB_prod_serv = mock(DB_PS.class);
		this.API_prod_serv = API_DB_PS.getInstance();
		when(DB_prod_serv.isInDB(-100)).thenReturn(false);
		when(DB_prod_serv.isInDB(100)).thenReturn(true);
		when(DB_prod_serv.getItem(100)).thenReturn(new Produto("nome",10.00,"outros"));
		this.API_prod_serv.setDB(DB_prod_serv);
	}
		
	@Test
	public void Instancia_objeto_NF_corretamente()
		   throws QuantidadeInvalida, IVNaoPresenteNoDB {
		
		int id  = 100,
			qtd = 1; 
		
		// A Classe NotaFiscal utiliza o DP "Factory Method" por meio de um método "create"
		// que é a única forma do usuário do pacote NotaFiscal criar um objeto da Classe
		// NotaFiscal. Tal método necessita dos parâmetros "id" e "quantidade" de um PS
		// desejado (bem como um objeto da classe DB_PS, para validação do PS), impedindo
		// que sejam criadas NFs sem IVs.
		NotaFiscal NF = NotaFiscal.create(id, qtd, "");		
		assertTrue(NF != null);
	}

	@Test
	public void Falha_ao_utilizar_o_construtor_de_NF () {
		//NotaFiscal NF = new NotaFiscal();   // Esta linha causaria erro de compilação, pois
		    								  // NotaFiscal é uma Classe Abstrata
	}
	
	@Test
	public void Falha_ao_instanciar_NF_com_0_elementos()
		   throws QuantidadeInvalida, IVNaoPresenteNoDB {
		
		int id_exemplo  = 100, // Tentar instanciar uma NF com 0 ou menos elementos
			qtd_exemplo = 0;   // resulta em uma exceção
		
		try {
			NotaFiscal.create(id_exemplo, qtd_exemplo, "");
			fail();
		}
		catch (QuantidadeInvalida expect) {
			assertEquals("Quantidade invalida para IV!\n", expect.getMessage());
		}
	}

	@Test
	public void Falha_ao_instanciar_NF_com_PS_inexistente_no_BD() 
		   throws QuantidadeInvalida, IVNaoPresenteNoDB {
		
		int id_exemplo  = -100,   // Tentar instanciar uma NF com uma "id" de PS invalida 
			qtd_exemplo = 1;      // resulta em uma exceção

		try {
			NotaFiscal.create(id_exemplo, qtd_exemplo, "");
			fail();
		}
		catch (IVNaoPresenteNoDB expect) {
			assertEquals("IV nao existe no DB!\n", expect.getMessage());
		}
	}
	
	@Test
	public void Falha_ao_tentar_remover_IV_de_uma_NF_com_apenas_1_IV()
	       throws QuantidadeInvalida, IVNaoPresenteNoDB {
		
		int id_exemplo  = 100,   
			qtd_exemplo = 1;
			
		NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, "");		

		NF.removeIV(100); // Ao tentar remover o único item, o método "removeIVfromNF"
					      // não faz nada, deixando a NF inalterada
				
		assertEquals(NF.getNFSize(), 1);
	}
		
	@Test
	public void Falha_ao_tentar_acessar_o_construtor_de_NotaFiscalMut_diretamente()
		   throws QuantidadeInvalida, IVNaoPresenteNoDB {

		// int id  = 100,
			// qtd = 1; 

		// Esta linha causaria erro de compilação, pois o construtor de NotaFiscalMut possui 
		// visibilidade restrita à própria classe

		//NotaFiscalMut NF = new NotaFiscalMut(id, qtd, this.DB_prod_serv);			
	}
}