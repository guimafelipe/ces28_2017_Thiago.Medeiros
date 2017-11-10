import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import DB.DB_NF;
import Exceptions.IVNaoPresenteNoDB;
import Exceptions.NFInvalida;
import Exceptions.QuantidadeInvalida;
import NotaFiscal.NotaFiscal;

//Testes para o requisito 21:
//-> Deve imprimir explicitamente a NF (ID, IVs, PSs, valores, impostos, soma dos
//   valores e soma dos impostos   

public class Item_21 {
	private DB_NF DB_nota_fiscal;
	
	@Before
	public void setUp() {
		this.DB_nota_fiscal = DB_NF.getInstance();
	}
		
	@Test
	public void imprimindo_NF_validada() 
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, NFInvalida {

		int id_1  = 100, qtd_1 = 3, 
			id_2  = 200, qtd_2 = 5; 
		
		// COLOCAR OS CAMPOS DOS IMPOSTOS!
		
		NotaFiscal NF = NotaFiscal.create(id_1, qtd_1, "");		
		NF.addIV(id_2, qtd_2);		
				
		NotaFiscal NF_validada = DB_nota_fiscal.validateNF(NF);
				
		String expected_NF = "-------------------------------------------------------------------\n" + 
						 	 "Nota Fiscal Paulista :D\n" +
						 	 "\n" + 
						 	 "Status: validada\n" +
						 	 "ID: 0\n" + 
						 	 "\n" +							 
						 	 "Items de Venda:\n" + 
						 	 "\n" + 
						 	 "COD.      Nome                Preco (Und.)   Quant.  Preco (Total)\n" + 
						 	 "100       Serv_1              R$ 1.0         3       R$ 3.0        \n" + 
						 	 "200       Prod_1              R$ 3.0         5       R$ 15.0       \n" +        
						 	 "                                                     --------------\n" + 
						 	 "                                              Valor: R$ 0.0\n" + 
						 	 "-------------------------------------------------------------------\n\n";
				
		NotaFiscal NF_no_BD = DB_nota_fiscal.getNF(NF_validada.getId());
		
		assertEquals(NF_no_BD.checkNotaFiscal(), expected_NF);
	}
}