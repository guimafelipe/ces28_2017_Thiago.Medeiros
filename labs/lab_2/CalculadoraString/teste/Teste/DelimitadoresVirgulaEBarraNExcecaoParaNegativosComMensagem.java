package Teste;

import static org.junit.Assert.*;
import Producao.CalculadoraString;
import org.junit.Test;

//OK

// Testa os delimitadores "," e "\n", Testa entrada com negativos
public class DelimitadoresVirgulaEBarraNExcecaoParaNegativosComMensagem {
	@Test
	public void barra_n() {
		assertEquals(CalculadoraString.add("1\n\n2\n3\n4\n\n"), 1+2+3+4);
	}

	@Test
	public void barra_n_e_virgula() {
		assertEquals(CalculadoraString.add(",,1,2\n,3\n\n,\n4,\n\n"), 1+2+3+4);
	}
	
	@Test
	public void negativos() {
		try {
			CalculadoraString.add("-1,2,\n-3\n,-5\n\n,,");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negativos proibidos [-1 -3 -5]\n");
			return;
		}

		fail();
	}
	
	@Test
	public void menos_zero() {
		assertEquals(CalculadoraString.add("2,1,-0,1,2"), 2+1+1+2);
	}
}