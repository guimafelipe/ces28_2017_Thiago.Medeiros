import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import DB.DB_PS;
import Exceptions.DBInvalido;
import Exceptions.IVNaoPresenteNoDB;
import Exceptions.QuantidadeInvalida;
import NotaFiscal.NFMutavel;
import NotaFiscal.NotaFiscal;

// Testes para o requisito 1:
// -> NF não pode ter zero IV. Deve ter 1 ou mais.

public class Item_01 {
	private DB_PS DB_prod_serv;
	
	@Before
	public void setUp() {
		this.DB_prod_serv = DB_PS.getInstance(); // Devem ser substituido por mock !!!
	}
	
	@Test
	public void Instancia_objeto_NF_corretamente()
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, DBInvalido {		
		
		int id_exemplo  = 100,
			qtd_exemplo = 1; 
		
		// A Classe NotaFiscal utiliza o DP "Factory Method" por meio de um método "create"
		// que é a única forma do usuário do pacote NotaFiscal criar um objeto da Classe
		// NotaFiscal. Tal método necessita dos parâmetros "id" e "quantidade" de um PS
		// desejado (bem como um objeto da classe DB_PS, para validação do PS), impedindo
		// que sejam criadas NFs sem IVs.
		NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, "", this.DB_prod_serv);		
		assertTrue(NF != null);
	}

	@Test
	public void Falha_ao_utilizar_o_construtor_de_NF () {
		//NotaFiscal NF = new NotaFiscal();   // Esta linha causaria erro de compilação, pois
		    								  // NotaFiscal é uma Classe Abstrata.
	}
	
	@Test
	public void Falha_ao_instanciar_NF_com_0_elementos()
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, DBInvalido {
		
		int id_exemplo  = 100, // Tentar instanciar uma NF com 0 ou menos elementos
			qtd_exemplo = 0;   // resulta em uma exceção
		
		try {
			NFMutavel.create(id_exemplo, qtd_exemplo, "", this.DB_prod_serv);
			fail();
		}
		catch (QuantidadeInvalida expect) {
			assertEquals("Quantidade invalida para IV!\n", expect.getMessage());
		}
	}

	@Test
	public void Falha_ao_instanciar_NF_com_PS_inexistente_no_BD() 
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, DBInvalido {

		int id_exemplo  = -100,   // Tentar instanciar uma NF com uma "id" de PS invalida 
			qtd_exemplo = 1;      // resulta em uma exceção

		try {
			NFMutavel.create(id_exemplo, qtd_exemplo, "", this.DB_prod_serv);
			fail();
		}
		catch (IVNaoPresenteNoDB expect) {
			assertEquals("IV nao existe no DB!\n", expect.getMessage());
		}
	}
	
	@Test
	public void Falha_ao_tentar_remover_IV_de_uma_NF_com_apenas_1_IV()
	       throws QuantidadeInvalida, IVNaoPresenteNoDB, DBInvalido {
		
		int id_exemplo  = 100,   
			qtd_exemplo = 1;
			
		NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, "", this.DB_prod_serv);		

		NF.removeIV(100); // Ao tentar remover o único item, o método "removeIVfromNF"
					      // não faz nada, deixando a NF inalterada
				
		assertEquals(NF.getNFSize(), 1);
	}
	
	@Test
	public void Falha_ao_instanciar_NF_com_DB_nulo() 
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, DBInvalido {
		
		int id_exemplo  = 100,
			qtd_exemplo = 1; 

		// A busca de PS dentro da Classe NotaFiscal está restrita ao objeto DB_PS.
		// A passagem de um DB invalido gera exceção

		try {
			NFMutavel.create(id_exemplo, qtd_exemplo, "", null);
			fail();
		}
		catch (DBInvalido expect) {
			assertEquals("DB_PS invalido!\n", expect.getMessage());
		}
}
		
	@Test
	public void Falha_ao_tentar_acessar_o_construtor_de_NotaFiscalMut_diretamente()
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, DBInvalido {

		// int id_exemplo  = 100,
			// qtd_exemplo = 1; 

		// Esta linha causaria erro de compilação, pois o construtor de NotaFiscalMut possui 
		// visibilidade restrita à própria classe

		//NotaFiscalMut NF = new NotaFiscalMut(id_exemplo, qtd_exemplo, this.DB_prod_serv);			
	}
}