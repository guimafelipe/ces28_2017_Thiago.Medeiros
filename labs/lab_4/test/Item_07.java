import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import DB.DB_NF;
import Exceptions.IVNaoPresenteNoDB;
import Exceptions.NFInvalida;
import Exceptions.QuantidadeInvalida;
import NotaFiscal.NotaFiscal;

//Testes para o requisito 7:
//-> Cada NF validada deve ter um identificador único

public class Item_07 {
	private DB_NF DB_nota_fiscal;
	
	@Before
	public void setUp() {
		this.DB_nota_fiscal = DB_NF.getInstance();
	}
		
	@Test
	public void verificacao_de_id_unico() 
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, NFInvalida {
		this.DB_nota_fiscal = DB_NF.cleanDB();
		
		int id_1 = 100, qtd_1 = 3, 
			id_2 = 200, qtd_2 = 5,
			id_3 = 300, qtd_3 = 1; 
				
		NotaFiscal NF = NotaFiscal.create(id_1, qtd_1, "");		
		NF.addIV(id_2, qtd_2);
				
		// NF_validada_1 recebe a id de validacao "0"
		NotaFiscal NF_validada_1 = DB_nota_fiscal.validateNF(NF);
		
		String expected_NF_1 = "-------------------------------------------------------------------\n" + 
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

		NF.addIV(id_3,  qtd_3);
		
		// NF_validada_2 recebe a id de validacao "1"
		NotaFiscal NF_validada_2 = DB_nota_fiscal.validateNF(NF);

		String expected_NF_2 = "-------------------------------------------------------------------\n" + 
				   "Nota Fiscal Paulista :D\n" +
				   "\n" + 
				   "Status: validada\n" +
				   "ID: 1\n" + 
				   "\n" +							 
				   "Items de Venda:\n" + 
				   "\n" + 
				   "COD.      Nome                Preco (Und.)   Quant.  Preco (Total)\n" + 
				   "100       Serv_1              R$ 1.0         3       R$ 3.0        \n" + 
				   "200       Prod_1              R$ 3.0         5       R$ 15.0       \n" +        
				   "300       Serv_2              R$ 5.0         1       R$ 5.0        \n" +        
	               "                                                     --------------\n" + 
	               "                                              Valor: R$ 0.0\n" + 
	               "-------------------------------------------------------------------\n\n";
		
		String NF_1_list = NF_validada_1.checkNotaFiscal();
		String NF_2_list = NF_validada_2.checkNotaFiscal();		
		String expected = expected_NF_1 + expected_NF_2;
		
		assertEquals(NF_1_list + NF_2_list, expected);		
	}
	
	@Test
	public void verificando_IDs_nao_validadas() 
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, NFInvalida {
		this.DB_nota_fiscal = DB_NF.cleanDB();
		
		int id_1 = 100, qtd_1 = 3, 
			id_2 = 200, qtd_2 = 5,
			id_3 = 300, qtd_3 = 1;
					
		NotaFiscal NF = NotaFiscal.create(id_1, qtd_1, "");							
		DB_nota_fiscal.validateNF(NF);
		
		assertTrue(DB_nota_fiscal.checkId("0"));
		assertFalse(DB_nota_fiscal.checkId("1"));
		assertFalse(DB_nota_fiscal.checkId("2"));
		assertFalse(DB_nota_fiscal.checkId("3"));
		
		NF.addIV(id_2, qtd_2);
		DB_nota_fiscal.validateNF(NF);
				
		assertTrue(DB_nota_fiscal.checkId("0"));
		assertTrue(DB_nota_fiscal.checkId("1"));
		assertFalse(DB_nota_fiscal.checkId("2"));
		assertFalse(DB_nota_fiscal.checkId("3"));		
				
		NF.addIV(id_3, qtd_3);
		DB_nota_fiscal.validateNF(NF);

		assertTrue(DB_nota_fiscal.checkId("0"));
		assertTrue(DB_nota_fiscal.checkId("1"));
		assertTrue(DB_nota_fiscal.checkId("2"));		
		assertFalse(DB_nota_fiscal.checkId("3"));
	}
}