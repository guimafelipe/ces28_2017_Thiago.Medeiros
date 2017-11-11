package DB;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import DB.API_DB_PS;
import DB.DB_PS;
import DB.Servico;
import Exceptions.IVNaoPresenteNoDB;
import Exceptions.QuantidadeInvalida;
import NotaFiscal.NotaFiscal;

public class Item_20 {
	private DB_PS DB_prod_serv;
	private API_DB_PS API_prod_serv;
	
	@Before
	public void setUp() {
		this.DB_prod_serv = mock(DB_PS.class);
		this.API_prod_serv = API_DB_PS.getInstance();
		Servico itemExemplo1 = new Servico("Serv_1", 1.00, "");
		when(DB_prod_serv.isInDB(100)).thenReturn(true);
		when(DB_prod_serv.getItem(100)).thenReturn(itemExemplo1);
		
		this.API_prod_serv.setDB(DB_prod_serv);
	}
	@Test
	public void exemplificacao_da_possibilidade_de_extensao_do_campo_outros()
		   throws QuantidadeInvalida, IVNaoPresenteNoDB {		
	
		int id_exemplo = 100,
			qtd_exemplo = 3;
		
		NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, "exemplo");
		
		// O campo "outros" pode ser facilmente modificado, facilitando a extensao
		// da classe NotaFiscal. Isso é possível de ser percebido com o uso do 
		// getter "getOutros" e o setter "setOutros", bem como métodos auxiliares
		// que podem ser utilizados dentro da classe em conjunto com atributos extras
		// ou mesmo gerenciadores internos à classe, tal qual a classe GerenteIV

		assertEquals(NF.getOutros(), "exemplo");
		
		// Por exemplo, o campo "outros" ser substituido por uma classe "dataCliente" com diversos
		// dados sobre o cliente associado à NF
		
		NF.setOutros("id_321");
		assertEquals(NF.getOutros(), "id_321");
		
		// Tais dados poderiam ser facilmente tratados dentro da classe NotaFiscal por meio
		// de uma outra classe "gerenteCliente", por exemplo
	}
}