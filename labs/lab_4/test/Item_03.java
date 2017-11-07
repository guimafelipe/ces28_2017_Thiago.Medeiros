
import org.junit.Before;
import org.junit.Test;

//import DB.DB_PS;
//import DB.Servico;

//Testes para o requisito 3:
//-> Todo PS deve pertencer a exatamente um IV.

public class Item_03 {
	//private DB_PS DB_prod_serv;
	
	@Before
	public void setUp() {
		//this.DB_prod_serv = new DB_PS(); // Devem ser substituido por mock !!!
	}
		
	@Test
	public void tentativa_de_instanciar_IVs_ou_PSs_isoladamente() {
		//IV item_de_venda = new IV(); // Esta linha geraria erro de compilação, pois
									   // o construtor tem visibilidade restrita ao pacote
									   // NotaFiscal
		
		//IV item_de_venda = new Produto("", 0.0, ""); // Estas linha gerariam erro de compilação, pois
		//IV item_de_venda = new Servico("", 0.0, ""); // os construtores de Produto e Servico tem visibilidade
											           // restrita ao pacote PS
				
		// Este comportamento impede a instanciação de PSs isoladamente 
	}
	
	// A classe NotaFiscal se limita a buscar informações no BD, não sendo possível
	// criar objetos da classe PS ou IVs
}