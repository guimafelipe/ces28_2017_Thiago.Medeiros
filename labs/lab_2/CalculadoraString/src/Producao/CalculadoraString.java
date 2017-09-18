package Producao;

import java.util.regex.Pattern;

public class CalculadoraString {
	private static int i;      //indice para percorrer "numbers"
	private static boolean dl; //indica se existem novas definicoes de delimitadores
	
	public static int add(String numbers) throws IllegalArgumentException {		
		int     sum = 0;           //resultado da soma;
		boolean negatives = false; //verifica se existem negativos;
		String  ExceptMessage = "negativos proibidos [", //mensagem de erro quando negativo eh lido;
			    RegEx = ""; //caracteres a serem considerados delimitadores;
		
		if(numbers.length() > 0) {
		 	i  = 1; dl = false;
			RegEx = delimiters(numbers); //leitura dos novos delimitadores, se existirem;
			
			//remocao do inicio de numbers, caso hajam definicoes de novos delimitadores;
			if(dl) numbers = numbers.substring(i, numbers.length()); 
		}
						
		String[] splt = numbers.split(",|\\n|\\s" + RegEx); //quebra de numbers nos delimitadores;
		
	//tratamento dos caracteres restantes apos remocao dos delimitadores; - - - - - - - - - - - - - - -
		try {
			for(String w:splt) {
				if(w.length() == 0) //string vazia, desconsiderar;
					continue;

				else if(Integer.parseInt(w) < 0) { //numero negativo, joga excecao + mensagem de erro;
					if(negatives)
						ExceptMessage += " "; //realiza espaçamento correto na mensagem de erro;

					ExceptMessage += w;
					negatives = true;
					
					continue; //impede processamento do numero negativo na soma;
				}
				
				int par = Integer.parseInt(w); //converte a string em numero;
				
				if(par > 1000) //desconsidera numeros maiores que 1000;
					continue;
				
				sum += par; //se tudo der certo, atualiza a soma;
			}
		}
		catch (NumberFormatException e) { throw new IllegalArgumentException(); }
	//fim do tratamento dos caracteres; - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		if(negatives) { //se houverem numeros negativos, joga excecao apos registrar os negativos na entrada;
			ExceptMessage += "]\n";
			throw new IllegalArgumentException(ExceptMessage);
		}
		
		return sum; //se der tudo certo, retorna a soma dos numeros em numbers;
	}
	
	static private String delimiters(String numbers) throws IllegalArgumentException {
		String RegEx = "",
			   aux = ""; //auxilia na construcao da RegEx
		boolean invalid_delimiter; //verifica se delimitador eh valido;
		
		if(numbers.charAt(0) == '\\') { //espera o formato "\\[del_1][del_2]...[del_N]\n<numbers>"
			while(i < numbers.length() && numbers.charAt(i) == '[') {
				i += 1;
				invalid_delimiter = true;
				
				for(;i < numbers.length(); i++) {
					if(numbers.charAt(i) != ']' && numbers.charAt(i) != '[' &&
					   !(numbers.charAt(i) >= '0' && numbers.charAt(i) <= '9')) {
						if(numbers.charAt(i) != ' ')  //' ' eh delimitador padrao tanto quanto ',' e '\n'
							aux += numbers.charAt(i); //devido as restricoes no enunciado do problema							
						invalid_delimiter = false;
					}
					else {
						i += 1;
						break;
					}
				}
				
				if(invalid_delimiter)
					throw new IllegalArgumentException();	
				else if(aux != "") {
					RegEx += "|" + Pattern.quote(aux); //Pattern.quote() trata os caracteres especiais;
					aux = "";
				}
			}
		}
		
		if(RegEx.length() != 0) //existem novos delimitadores;
			dl = true;		
		
		return RegEx;
	}	
}