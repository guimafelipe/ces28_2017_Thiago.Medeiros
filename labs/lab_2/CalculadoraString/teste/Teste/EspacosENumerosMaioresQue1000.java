package Teste;

import static org.junit.Assert.*;
import org.junit.Test;
import Producao.CalculadoraString;

//OK

public class EspacosENumerosMaioresQue1000 {
	@Test
	public void ignora_espacos() {
		assertEquals(CalculadoraString.add("    1,\n 2,   \n\n3\n\n \n\n ,, 4    \n"), 1+2+3+4);
	}

	@Test
	public void ignora_espacos_com_negativo() {
		try {
			CalculadoraString.add("    1,\n 2,   \n\n-3\n\n \n\n ,, 4    \n");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negativos proibidos [-3]\n");
			return;
		}
		fail();
	}
	
	@Test
	public void ignora_maiores_que_1000() {
		assertEquals(CalculadoraString.add("1,2,3,1001,2000,3000,4,5\n"), 1+2+3+4+5);		
	}
}