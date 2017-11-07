package NotaFiscal;

import java.util.Map;

import DB.DB_PS;
import DB.IV;

import Exceptions.DBInvalido;
import Exceptions.IVNaoPresenteNoDB;
import Exceptions.QuantidadeInvalida;

public abstract class NotaFiscal {
	// Construtor
	protected NotaFiscal() { }
	
	// Factory Method
	public static NotaFiscal create(int id, int quantidade, String outros, DB_PS DB_prod_serv)
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, DBInvalido {
		
		return NFMutavel.create(id, quantidade, outros, DB_prod_serv);
	}
	
	// Retorna a quantidade de elementos na NF
	public abstract int getNFSize();
		
	// Retorna o IV
	public abstract IV getItem(int id);
	// Retorna todos os IVs
	public abstract Map<Integer, IV> getItems();
	
	// Retorna a ID da NF, caso validada
	public String getId() { return ""; }
	// Retorna o Estado da NF ("em elaboração" ou "validada")
	public abstract String getEstado();
	// Retorna uma String para o campo "outros"
	public abstract String getOutros();
	// Modifica o campo "outros"
	public void setOutros(String oturos) { };

	// Retorna uma String com as informações atuais da NF 
	public abstract String checkNotaFiscal();

	// Retorna true se o IV está presente na NF 
	public abstract boolean isInNF(int id);

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