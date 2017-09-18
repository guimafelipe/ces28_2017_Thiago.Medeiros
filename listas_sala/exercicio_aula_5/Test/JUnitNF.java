import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import Back_End.DBClientes;
import Back_End.DBProdutos;
import Back_End.cliente;
import Back_End.produto;
import Back_End.servico;
import Front_End.nota_fiscal;

public class JUnitNF {
	DBClientes dBclientes = mock(DBClientes.class);
	DBProdutos dBprodutos = mock(DBProdutos.class);
	nota_fiscal NF;
        
	@Before
	public void setUp() {
		when(dBprodutos.getProduto(10)).thenReturn(new produto(10, "Mockit", "???", "very nice stuff", 1.0));		
		when(dBprodutos.getProduto(11)).thenReturn(new produto(11, "Mockow", "???", "even nicer stuff", 10.0));		
		when(dBprodutos.getProduto(12)).thenReturn(new produto(12, "Mockotto", "???", "the best", 100.0));		
		when(dBprodutos.getProduto(13)).thenReturn(null);		
		
		when(dBprodutos.getServico(69)).thenReturn(new servico(69, "Mockos", "???", "good", 1.0));		
		when(dBprodutos.getServico(70)).thenReturn(new servico(70, "Mockosso", "???", "better", 10.0));		
		when(dBprodutos.getServico(71)).thenReturn(new servico(71, "Mocko", "???", "awesome", 100.0));
		
		cliente novo = new cliente(1111111111, 996966969, "Jose da Silva", "H8B, ap. 233");
		when(dBclientes.getCliente(1111111111)).thenReturn(novo);
		this.NF = new nota_fiscal(dBclientes, 1111111111, dBprodutos, 10, 100, 0.0);
	}
	
	@Test
	public void Teste_d() {
		NF.add_produto(dBprodutos, 12, 1, 0.0);
		NF.deleta_item(10);
		NF.add_produto(dBprodutos, 11, 10, 0.0);
		
		assertTrue(NF.find_item(11) >= 0 && NF.find_item(12) >= 0 && NF.find_item(10) < 0);
		assertEquals(NF.getValor(), 200.0, 0.000001);
	}
	
	@Test
	public void Teste_e() {
		NF.troca_produto(dBprodutos, 10, 12, 1, 0.0);
		assertTrue(NF.getValor() == 100.0 && NF.find_item(12) >= 0 && NF.find_item(10) < 0);
	}

	@Test(expected = NoSuchElementException.class)
	public void Teste_f() {
		NF.add_produto(dBprodutos, 13, 1, 0.0);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void Teste_g() {
		nota_fiscal teste = new nota_fiscal(dBclientes, 1111111111, dBprodutos, 13, 1, 0.0);
	}
	
	@Test
	public void Teste_h() {
		NF.add_produto(dBprodutos, 12, 1, 0.0);
		NF.add_produto(dBprodutos, 11, 10, 0.0);
		
		NF.deleta_item(10);
		NF.deleta_item(11);
		NF.deleta_item(12);
		
		assertTrue(NF.getQtdTipoItem() == 1);
	}
	
	//assertEquals(test.getUniqueId(), 43);
}