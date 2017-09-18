package Front_End;

import Back_End.DBProdutos;

public class item_venda {
	private int quantidade; //de produtos na NF
	private double desconto;
	private item_interface item;
	
	item_venda() {
		this.quantidade = 0;
		this.desconto = 0.0;
	}
	
	public int getId() {
		return item.getId();
	}
	
	public int getQuant() {
		return this.quantidade;
	}
	
	public double getDesc() {
		return this.desconto;
	}
	
	public double getPreco() {
		return (this.quantidade * this.item.getPreco()) - this.desconto;
	}
		
	public void set_produto(DBProdutos DB, int id, int quantidade, double desconto) {
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.item = DB.getProduto(id);
	}
	
	public void set_servico(DBProdutos DB, int id, int quantidade, double desconto) {
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.item = DB.getServico(id);
	}	
}