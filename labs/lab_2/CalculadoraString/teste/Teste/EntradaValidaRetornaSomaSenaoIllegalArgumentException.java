package Teste;

import static org.junit.Assert.*;
import org.junit.Test;
import Producao.CalculadoraString; 

//OK

// Testa apenas numeros positivos com delimitador ","
public class EntradaValidaRetornaSomaSenaoIllegalArgumentException {
	@Test
	public void string_vazia() {
		assertEquals(CalculadoraString.add(""), 0);
	}

	@Test
	public void um_numero() {
		assertEquals(CalculadoraString.add("1"), 1);
	}
	
	@Test
	public void dois_numeros() {
		assertEquals(CalculadoraString.add("1,2"), 1+2);
	}
	
	@Test
	public void cinco_numeros() {
		assertEquals(CalculadoraString.add("1,2,3,4,5"), 1+2+3+4+5);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void entrada_invalida_delimitador() {
		assertEquals(CalculadoraString.add("1;2"), 1+2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void entrada_invalida_numero_e_naonumeros() {
		assertEquals(CalculadoraString.add("1,2a"), 1+2);		
	}
}