package Teste;

import static org.junit.Assert.*;

import org.junit.Test;

import Producao.CalculadoraString;

public class CaracteresEspeciais {
	@Test(expected = IllegalArgumentException.class)
	public void abre_colchetes() {
		CalculadoraString.add("\\[[][[[]\n1,2,3[4\n");
	} // [ nao eh delimitador valido

	@Test(expected = IllegalArgumentException.class)
	public void fecha_colchetes() {
		CalculadoraString.add("\\[]][]]]\n1,2,3]4\n");
	} // ] nao eh delimitador valido

	@Test(expected = IllegalArgumentException.class)
	public void numeros() {
		CalculadoraString.add("\\[2][0]\n1,2,3");
	} // numeros nao sao delimitadores validos
	
	@Test
	public void letras() {
		assertEquals(CalculadoraString.add("\\[a][b][w][z][A][BBBB][Z]\nBBBB1z2Aa3a4b5"), 1+2+3+4+5);
	} // letras sao delimitadores validos (minusculas ou maiusculas)
	
	@Test
	public void outros_caracteres() {
		assertEquals(CalculadoraString.add("\\[\"][\\][#][$][!][%][:][;][<][=][>][&][\'][(][)][`][{][}][|][||][+][.][/][?][@][^][_][~]\n.~.~.^_2__//^/?<1<?++=1+=>>1\"\"&#::;!!2\\3%%(@)@5@(){}''||`"), 1+1+1+2+2+3+5);
	} // \\, #, $, !, %, :, ;, <, =, >, ", ', (, ), `, {, }, |, +, ., /, ?, @, ^, _, ~
	
	@Test
	public void caracteres_especiais() {
		assertEquals(CalculadoraString.add("\\[\b][\t][\r][\0]\n1\t\t\0\0\t\b\b2\b3\f\f5\r\0"), 1+2+3+5);
	} // \b \t \f \r \v \0
}