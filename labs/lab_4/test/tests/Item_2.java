package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DB.DB_PS;
import NotaFiscal.*;

// Testes para o requisito 2:
// -> Todo IV deve pertencer a exatamente uma NF.

public class Item_2 {
	private DB_PS DB_prod_serv;
	
	@Before
	public void setUp() {
		this.DB_prod_serv = new DB_PS();   // Devem ser substituido por mock !!!
	}
	
	/*
	@Test
	public void Instancia_objeto_NF_corretamente() {		
		int id_exemplo  = 100,
			qtd_exemplo = 1; 
		
		NotaFiscal NF = NotaFiscal.create(id_exemplo, qtd_exemplo, this.DB_prod_serv);		
		assertTrue(NF != null);
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
	*/
}