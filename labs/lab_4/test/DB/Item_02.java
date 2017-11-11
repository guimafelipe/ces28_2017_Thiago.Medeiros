package DB;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import DB.API_DB_PS;
import DB.DB_PS;
import DB.IV;
import DB.Produto;
import Exceptions.DBInvalido;
import Exceptions.IVNaoPresenteNoDB;
import Exceptions.QuantidadeInvalida;
import NotaFiscal.NotaFiscal;

// Testes para o requisito 2:
// -> Todo IV deve pertencer a exatamente uma NF.

public class Item_02 {
	private DB_PS DB_prod_serv;
	private API_DB_PS API_prod_serv;
	
	@Before
	public void setUp() {
		this.DB_prod_serv = mock(DB_PS.class);
		this.API_prod_serv = API_DB_PS.getInstance();
		
		Produto itemExemplo = new Produto("nome",10.00,"outros");
		when(DB_prod_serv.isInDB(100)).thenReturn(true);
		when(DB_prod_serv.getItem(100)).thenReturn(itemExemplo);
		
		this.API_prod_serv.setDB(DB_prod_serv);
	}

	@Test (expected = AssertionError.class)
	public void verificacao_da_diferenca_entre_objetos_IV_de_NFs_diferentes() 
		   throws QuantidadeInvalida, IVNaoPresenteNoDB {

		int id_1 = 100,
			qtd_1 = 1;		
		NotaFiscal NF1 = NotaFiscal.create(id_1, qtd_1, "");
		IV item_1 = NF1.getItem(100);
		
		int id_2 = 100,
			qtd_2 = 1;			
		NotaFiscal NF2 = NotaFiscal.create(id_2, qtd_2, "");
		IV item_2 = NF2.getItem(100);
		
		// Uma exceção será gerada (AssertionError), pois embora os objetos tenham sido
		// retirados do mesmo DB e possuam a mesma quantidade, são objetos diferentes.
		// Assim, cada IV pertence à exatamente uma NF. Isto ocorre devido ao tratamento
		// dos IVs pelo código, que utilizam a ideia da DP "Immutable Object" e as vantagens
		// do encapsulamento de classes, primeiramente ao acessarem o BD para adicionar o
		// item à lista de IVs da NF (que recebe uma cópia do objeto salvo no DB) e, em
		// seguida, ao retornar este objeto da lista no método "getItem()", de onde a NF
		// apenas retorna uma cópia do objeto salvo em sua lista interna
		
		assertEquals(item_1, item_2);
	}
	
	@Test (expected = AssertionError.class)
	public void tentativa_de_modificar_os_IVs_na_NF() 
		   throws QuantidadeInvalida, IVNaoPresenteNoDB {

		int id_exemplo = 100,
			qtd_exemplo = 1;				
		NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, "");
		
		IV itemExterno = NF.getItem(100);
		itemExterno.setQuantidade(10);
		
		IV itemInterno = NF.getItem(100);
				
		// A mudança no objeto presente em item não afeta o objeto na lista interna
		// da NF. A asserção causará uma exceção, pois as quantidades são diferentes.
		// Tal comportamento é garantido pelo encapsulamento das classes.
					
		assertEquals(itemExterno.getQuantidade(), itemInterno.getQuantidade());		
	}
	
	@Test
	public void tentativa_de_instanciar_IVs_fora_da_NF() {
		//IV item_de_venda = new IV(); // Esta linha geraria erro de compilação, pois
									   // o construtor de IV tem visibilidade restrita
									   // ao pacote DB
		
		// Este comportamento impede a instanciação de um IV fora da NF 
	}
}