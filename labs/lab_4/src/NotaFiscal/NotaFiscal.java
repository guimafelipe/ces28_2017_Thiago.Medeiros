package NotaFiscal;

import java.util.Map;

import DB.DB_PS;
import DB.IV;

public abstract class NotaFiscal {
	public static NotaFiscal create(int id, int quantidade, DB_PS DB_prod_serv) {
		return NotaFiscalMut.create(id, quantidade, DB_prod_serv);
	}
	
	// Retorna a quantidade de elementos na NF
	public int getNFSize() { return 0; }
	
	// Retorna o IV
	public IV getItem(int id) { return null; }
	// Retorna todos os IVs
	public Map<Integer, IV> getItems() { return null; }
	// Retorna a quantidade do IV
	public int getQuantidade(int id) { return 0; }
	// Retorna o desconto associado ao IV
	public double getDesconto(int id) { return 0.0; }
	// Retorna o preco do IV
	public double getPreco(int id) { return 0.0; }
	// Retorna o nome do IV
	public String getNome(int id) { return ""; }
	// Retorna os dados salvos no atributo Outros do IV
	public String getOutros(int id) { return ""; }
	
	// Retorna a ID da NF, caso validada
	public String getId() { return ""; }
	// Retorna o Estado da NF ("em elaboração" ou "validada")
	public String getEstado() { return ""; }

	// Retorna uma String com as informações atuais da NF 
	public String checkNotaFiscal() { return ""; }

	// Retorna true se o IV está presente na NF 
	public boolean isInNF(int id) { return false; }

	// Os métodos abaixo retornam true se a operação for bem sucedida
	
	// Muda a quantidade do IV por delta unidades
	public boolean mudaQuantidade(int id, int delta) { return false; }
	// Seta a quantidade do IV
	public boolean setQuantidade(int id, int quantidade) { return false; }
	// Insere o IV na NF com a quantidade especificada
	public boolean addIV(int id, int quantidade) { return false; }
	// Remove o IV da NF, se possível
	public boolean removeIV(int id) { return false; }
	
	// Todas as iterações com IVs são realizadas por meio da id dos mesmos
	
	protected static String formatString(int spaces, String str) {
		return String.format("%-" + Integer.toString(spaces) + "s", str);
	}	
}