import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Exceptions.IVNaoPresenteNoDB;
import Exceptions.QuantidadeInvalida;
import NotaFiscal.NotaFiscal;

public class Item_20 {
	@Before
	public void setUp() {
		// mocks
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