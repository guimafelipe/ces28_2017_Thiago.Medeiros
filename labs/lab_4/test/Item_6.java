import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DB.DB_NF;
import DB.DB_PS;
import NotaFiscal.NotaFiscal;

//Testes para o requisito 6:
//-> Validação da NF

public class Item_6 {
	private DB_PS DB_prod_serv;
	private DB_NF DB_nota_fiscal;
	
	@Before
	public void setUp() {
		this.DB_prod_serv = new DB_PS(); // Devem ser substituido por mock !!!
		this.DB_nota_fiscal = new DB_NF();
	}
	
	@Test
	public void criacao_de_NF_mutavel() {
		int id_1  = 100, qtd_1 = 3, 
		    id_2  = 200, qtd_2 = 5; 
			
		NotaFiscal NF = NotaFiscal.create(id_1, qtd_1, this.DB_prod_serv);		
		NF.addIV(id_2, qtd_2);
		
		// O status "em elaboração" está presente na nota
		
		String expected_NF = "-------------------------------------------------------------------\n" + 
							 "Nota Fiscal Paulista :D\n" +
							 "\n" + 
							 "Status: em elaboração\n" +
							 "Id: -----------\n" + 
							 "\n" +							 
							 "Items de Venda:\n" + 
							 "\n" + 
							 "COD.      Nome                Preco (Und.)   Quant.  Preco (Total)\n" + 
							 "100       Serv_1              R$ 1.0         3       R$ 3.0        \n" + 
							 "200       Prod_1              R$ 3.0         5       R$ 15.0       \n" +        
				             "                                                     --------------\n" + 
				             "                                              Valor: R$ 0.0\n" + 
				             "-------------------------------------------------------------------\n\n";
				
		assertEquals(NF.checkNotaFiscal(), expected_NF);		
	}
	
	@Test
	public void validacao_de_NF_pelo_DB_NF() {
		int id_1  = 100, qtd_1 = 3, 
			id_2  = 200, qtd_2 = 5; 
				
		NotaFiscal NF = NotaFiscal.create(id_1, qtd_1, this.DB_prod_serv);		
		NF.addIV(id_2, qtd_2);		
				
		NotaFiscal NF_validada = DB_nota_fiscal.validateNF(NF);
		
		// A nota validada possui um ID e é imutável
		
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
		
		assertEquals(NF_validada.checkNotaFiscal(), expected_NF);		
	}
	
	@Test
	public void a_NF_eh_armazenada_no_DB_NF() {
		int id_1  = 100, qtd_1 = 3, 
			id_2  = 200, qtd_2 = 5; 
				
		NotaFiscal NF = NotaFiscal.create(id_1, qtd_1, this.DB_prod_serv);		
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
		
		// A nota foi armazenada no DB como um objeto imutável
		
		NotaFiscal NF_no_BD = DB_nota_fiscal.getNF(NF_validada.getId());
		
		assertEquals(NF_no_BD.checkNotaFiscal(), expected_NF);
	}
	
	@Test
	public void DB_NF_nao_valida_nota_inconsistente() {
		int id_1  = 100, qtd_1 = 3, 
			id_2  = 200, qtd_2 = 5; 
				
		NotaFiscal NF = NotaFiscal.create(id_1, qtd_1, this.DB_prod_serv);		
		NF.addIV(id_2, qtd_2);		
				
		NotaFiscal NF_validada = DB_nota_fiscal.validateNF(NF);
		
		// Ao tentar validar uma NF inconsistente, o DB_NF retorna um objeto null
		
		assertTrue(DB_nota_fiscal.validateNF(NF_validada) == null);
	}
}