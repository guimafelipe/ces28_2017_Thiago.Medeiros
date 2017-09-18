package Teste;

import static org.junit.Assert.*;

import org.junit.Test;

import Producao.CalculadoraString;

//OK

public class DefinindoNovosDelimitadoresSeEntradaIntratavelThrowException {
	@Test
	public void novo_delimitador() {
		assertEquals(CalculadoraString.add("\\[k]\n1,2k3"), 1+2+3);
	}
	
	@Test
	public void multiplos_delimitadores() {
		assertEquals(CalculadoraString.add("\\[k][ ][*][p]\n1,2k***kk \n,ppp3"), 1+2+3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void delimitador_nao_definido() {
		assertEquals(CalculadoraString.add("\\[k][][*][p]\n1,2k***"), 1+2);
	}
		
	@Test
	public void delimitador_de_tamanho_arbitrario() {
		assertEquals(CalculadoraString.add("\\[kk][**][****]\n1  \n2,kk4****3******"), 1+2+3+4);
	}
	
	@Test
	public void usando_hifen_como_delimitador() {
		assertEquals(CalculadoraString.add("\\[-]1-,-2,--3---"), 1+2+3);
	}
}