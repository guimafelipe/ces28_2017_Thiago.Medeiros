package PS;

import java.util.HashMap;

import DB.DB_PS;

public abstract class IV {
	private int quantidade;  // sao atributos de IV,
	private double desconto; // nao dos PS
	private HashMap<Integer, Integer> sub_PS; // (id, quantidade) dos subprodutos/subserviços

	public static IV create(int id, DB_PS DB_prod_serv) {
		if(DB_prod_serv.checkItem(id)) {
			return DB_prod_serv.getItem(id); // not sure if it's going to work
		}
		return null;		
	}
	
	public String getName()  { return ""; }
	public double getPreco() { return 0.0; }
	
	public void setQuantidade(int quant) { this.quantidade = quant; }
	public int getQuantidade()  { return this.quantidade; }
	
	public void setDesconto(double desc) { this.desconto = desc; }
	public double getDesconto() { return this.desconto; }
}