import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import DB.DB_PS;
import Exceptions.DBInvalido;
import Exceptions.IVNaoPresenteNoDB;
import Exceptions.QuantidadeInvalida;
import NotaFiscal.NotaFiscal;

public class Item_20 {
	private DB_PS DB_prod_serv;
	
	@Before
	public void setUp() {
		this.DB_prod_serv = new DB_PS(); // Devem ser substituido por mock !!!
	}
	@Test
	public void exemplificacao_da_possibilidade_de_extensao_do_campo_outros()
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, DBInvalido {		
	
		int id_exemplo = 100,
			qtd_exemplo = 3;
		
		NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, "exemplo", this.DB_prod_serv);
		
		// O campo "outros" pode ser facilmente modificado, facilitando a extensao
		// da classe NotaFiscal. Isso é possível de ser percebido com o uso do 
		// getter "getOutros" e o setter "setOutros", bem como métodos auxiliares
		// que podem ser utilizados dentro da classe em conjunto com atributos extras
		// ou mesmo gerenciadores internos à classe, tal qual a classe GerenteIV

		assertEquals(NF.getOutros(), "exemplo");
		
		// Por exemplo, o campo "outros" poderia se referir ao ID do cliente a ser associado
		// à NF em sua criação
		
		NF.setOutros("id_321");
		assertEquals(NF.getOutros(), "id_321");
		
		// Tais dados poderiam ser facilmente tratados dentro da classe NotaFiscal por meio
		// de uma outra classe "gerenteCliente", por exemplo
	}
}