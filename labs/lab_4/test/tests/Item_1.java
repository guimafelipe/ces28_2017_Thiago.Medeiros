package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import DB.DB_PS;
import NotaFiscal.NotaFiscal;
import NotaFiscal.NotaFiscalMut;
import PS.GerenteIV;

// Testes para o requisito 1:
// -> NF não pode ter zero IV. Deve ter 1 ou mais.

public class Item_1 {
	private DB_PS DB_prod_serv;
	
	@Before
	public void setUp() {
		this.DB_prod_serv = new DB_PS();   // Devem ser substituido por mock !!!
	}
	
	@Test
	public void Instancia_objeto_NF_corretamente() {		
		int id_exemplo  = 100,
			qtd_exemplo = 1; 
		
		// A Classe NotaFiscal utiliza o DP "Factory Method" por meio de um método "create"
		// que é a única forma do usuário do pacote NotaFiscal criar um objeto da Classe
		// NotaFiscal. Tal método necessita dos parâmetros "id" e "quantidade" de um PS
		// desejado (bem como um objeto da classe DB_PS, para validação do PS), impedindo
		// que sejam criadas NFs sem IVs.
		NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, this.DB_prod_serv);		
		assertTrue(NF != null);
	}

	@Test // ???
	public void Falha_ao_utilizar_o_construtor_de_NF () {
		//NotaFiscal NF = new NotaFiscal();   // Esta linha causaria erro de compilação, pois
		  									  // NotaFiscal é uma Classe Abstrata.
	}
	
	@Test // Exceção?
	public void Falha_ao_instanciar_NF_com_0_elementos() {		
		int id_exemplo  = 100,
			qtd_exemplo = 0;   // Tentar instanciar uma NF com 0 ou menos elementos 
							   // resulta em um objeto null como retorno de "create"
		
		NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, this.DB_prod_serv);		
		assertTrue(NF == null);
	}
	
	@Test // Exceção?
	public void Falha_ao_instanciar_NF_com_PS_inexistente_no_BD() {
		int id_exemplo  = -100,   // Tentar instanciar uma NF com uma "id" de PS invalida 
			qtd_exemplo = 1;      // resulta em um objeto null como retorno de "create"
			
		NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, this.DB_prod_serv);		
		assertTrue(NF == null);
	}
	
	@Test // Exceção?
	public void Falha_ao_tentar_remover_IV_de_uma_NF_com_apenas_1_IV() {
		int id_exemplo  = 100,   
			qtd_exemplo = 1;
			
		NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, this.DB_prod_serv);		
		NF.removeIVfromNF(100); // Ao tentar remover o único item, o método "removeIVfromNF"
								// não faz nada, deixando a NF inalterada
				
		assertEquals(NF.getNumOfIVs(), 1);
	}
	
	@Test // Exceção?
	public void Falha_ao_instanciar_NF_com_DB_nulo() {
		int id_exemplo  = 100,
			qtd_exemplo = 1; 

			NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, null);
			// A busca de PS dentro da Classe NotaFiscal está restrita ao objeto
			// DB_PS. Caso seja um objeto nulo, o método "create" retorna um objeto
			// nulo
			
			assertTrue(NF == null);
	}
		
	@Test
	public void Falha_ao_tentar_acessar_o_construtor_de_NotaFiscalMut_diretamente() {
		int id_exemplo  = 100,
			qtd_exemplo = 1; 

			//NotaFiscalMut NF = new NotaFiscalMut(id_exemplo, qtd_exemplo, this.DB_prod_serv);
			// Esta linha causaria erro de compilação, pois o construtor de NotaFiscalMut possui 
			// visibilidade restrita à própria classe
	}

	@Test
	public void Outra_forma_de_instanciar_corretamente () {
		int id_exemplo  = 100,
			qtd_exemplo = 1; 

		NotaFiscalMut NF = NotaFiscalMut.create(id_exemplo, qtd_exemplo, this.DB_prod_serv);
		// Uma vez que as verificações de validade de "id" e do "DB" são feitas na Classe
		// "NotaFiscalMut", acessar o Factory Method "create" de "NotaFiscalMut" é equivalente
		// à chamar o método estático "create" da Classe "NotaFiscal".
		
		assertTrue(NF != null);
	}
}