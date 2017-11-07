package NotaFiscal;

import java.util.Map;

import DB.DB_PS;
import DB.IV;
import Exceptions.DBInvalido;
import Exceptions.IVNaoPresenteNoDB;
import Exceptions.QuantidadeInvalida;

public class NFMutavel extends NotaFiscal {
	private double valor;
	private String outros;
	
	private GerenteIV gerente;
	
	// Construtor
	private NFMutavel(int id, int quantidade, String outros, DB_PS DB_prod_serv) {
		this.valor   = 0.0;
		this.outros  = outros;
		this.gerente = new GerenteIV(DB_prod_serv); 
	
		this.gerente.addIV(id, quantidade);
	}

	// Factory Method
	public static NFMutavel create(int id, int quantidade, String outros, DB_PS DB_prod_serv)
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, DBInvalido {

		if  (DB_prod_serv == null)   { throw new DBInvalido("DB_PS invalido!\n"); }
		if(!DB_prod_serv.isInDB(id)) { throw new IVNaoPresenteNoDB("IV nao existe no DB!\n"); }
		if    (quantidade <= 0)      { throw new QuantidadeInvalida("Quantidade invalida para IV!\n"); }
				
		return new NFMutavel(id, quantidade, outros, DB_prod_serv);
	}
	
	// Retorna o estado da nota
	public String getEstado() { return "em elaboração"; }
	
	// Retorna uma String com o campo "outros"
	public String getOutros() { return this.outros; }
	// Seta o campo "outros"
	public void setOutros(String outros) { this.outros = outros; }
	
	// Retorna uma copia do item
	public IV getItem(int id) {
		if(isInNF(id)) { return this.gerente.getItem(id); }		
		return null;
	}	
	
	// Retorna uma copia da lista de items
	public Map<Integer, IV> getItems() { return this.gerente.getItems(); }
	
	// Retorna quantidade de IVs na NF
	public int getNFSize() { return this.gerente.getNFSize(); }
				
	// Retorna uma String com as informações da NF
	public String checkNotaFiscal() {
		return "-------------------------------------------------------------------\n" + 
			   "Nota Fiscal Paulista :D\n" + 
			   "\n" + 
			   "Status: em elaboração\n" + 
			   "Id: -----------\n" + 
			   "\n" + 
			   "Items de Venda:\n" + 
			   "\n" +
			   "COD.      Nome                Preco (Und.)   Quant.  Preco (Total)\n" + 
			   this.checkItems() + 
			   "                                                     --------------\n" +
			   "                                              " + 
			   "Valor: R$ " + Double.toString(this.valor) + "\n" + 
			   "-------------------------------------------------------------------\n" + 
			   "\n";
	}
	
	// Retorna uma String com informações dos IVs na NF
	private String checkItems() {
		String list = "";
		
		Map <Integer, IV> items = this.gerente.getItems();

		for(int item : items.keySet()) {
			IV atual = items.get(item);
			
			double preco = atual.getPreco();
			int    quant = atual.getQuantidade();
			double total = preco * quant; 
			
			list += formatString(9, Integer.toString(item)) + " " + formatString(19, atual.getName()) + " " +
			        "R$ " + formatString(11, Double.toString(preco)) + " " + formatString(7, Integer.toString(quant)) + " " +
					"R$ " + formatString(11, Double.toString(total)) + "\n";   
		}
		
		return list;
	}
			
	// Altera a quantidade do IV
	public boolean mudaQuantidade(int id, int delta) {
		if(!isInNF(id)) { return false; }		
		return this.gerente.mudaQuantidade(id, delta);
	}
	
	public boolean setQuantidade(int id, int quantidade) {
		if(!isInNF(id) || quantidade <= 0) { return false; }				
		return this.gerente.setQuantidade(id, quantidade);			
	}

	public boolean addIV(int id, int quantidade) { return this.gerente.addIV(id, quantidade); }

	public boolean removeIV(int id) {
		if(!getEstado().equals("em elaboração")) { return false; }
		return this.gerente.removeIV(id);
	}	

	public boolean isInNF(int id) { return this.gerente.isInNF(id); }	
}