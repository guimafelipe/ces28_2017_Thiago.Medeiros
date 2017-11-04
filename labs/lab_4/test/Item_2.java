import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import DB.DB_PS;
import DB.IV;
import NotaFiscal.NotaFiscal;

// Testes para o requisito 2:
// -> Todo IV deve pertencer a exatamente uma NF.

public class Item_2 {
	private DB_PS DB_prod_serv;
	
	@Before
	public void setUp() {
		this.DB_prod_serv = new DB_PS(); // Devem ser substituido por mock !!!
	}

	@Test (expected = AssertionError.class)
	public void verificacao_da_diferenca_entre_objetos_IV_de_NFs_diferentes() {
		int id_exemplo_1 = 100,
			qtd_exemplo_1 = 1;		
		NotaFiscal NF1 = NotaFiscal.create(id_exemplo_1, qtd_exemplo_1, this.DB_prod_serv);
		IV item_1 = NF1.getItem(100);
		
		int id_exemplo_2 = 100,
			qtd_exemplo_2 = 1;			
		NotaFiscal NF2 = NotaFiscal.create(id_exemplo_2, qtd_exemplo_2, this.DB_prod_serv);
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
	public void tentativa_de_modificar_os_IVs_na_NF() {
		int id_exemplo = 100,
			qtd_exemplo = 1;				
		NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, this.DB_prod_serv);
		
		IV item = NF.getItem(100);
		item.setQuantidade(10);
				
		// A mudança no objeto presente em item não afeta o objeto na lista interna
		// da NF. A asserção causará uma exceção, pois as quantidades são diferentes.
		// Tal comportamento é garantido pelo encapsulamento das classes.
		assertEquals(item.getQuantidade(), NF.getQuantidade(100));		
	}
	
	@Test
	public void tentativa_de_instanciar_IVs_fora_da_NF() {
		//IV item_de_venda = new IV(); // Esta linha geraria erro de compilação, pois
									   // o construtor de IV tem visibilidade restrita
									   // ao pacote DB
		
		// Este comportamento impede a instanciação de um IV fora da NF 
	}
}