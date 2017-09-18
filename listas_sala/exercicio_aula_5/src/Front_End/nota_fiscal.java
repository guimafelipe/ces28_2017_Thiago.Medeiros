package Front_End;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import Back_End.DBClientes;
import Back_End.DBProdutos;
import Back_End.cliente;
import Back_End.produto;
import Back_End.servico;

public class nota_fiscal {
	private double valor; //soma dos valores dos itens
	private cliente dados_do_cliente;
	public ArrayList <item_venda> item;
	
	public nota_fiscal(DBClientes DBc, int CPF, DBProdutos DBp, int id,
			int quantidade, double desconto) throws NoSuchElementException {
		
		this.valor = 0.0;
		this.dados_do_cliente = DBc.getCliente(CPF);
		this.item = new ArrayList();
	
		item_interface aux = DBp.getProduto(id);
		
		if(aux == null)
			throw new NoSuchElementException();
		
		if(aux instanceof produto)
			this.add_produto(DBp, id, quantidade, desconto);
		else if(aux instanceof servico)
			this.add_servico(DBp, id, quantidade, desconto);  
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public int getQtdTipoItem() {
		return this.item.size();
	}
		
	public void add_produto(DBProdutos DB, int id, int quantidade,
			double desconto) throws NoSuchElementException {
		
		if(DB.getProduto(id) == null)
			throw new NoSuchElementException();
		
		item_venda aux = new item_venda();
		aux.set_produto(DB, id, quantidade, desconto);
		this.valor += aux.getPreco();
		this.item.add(aux);
	}
	
	public void add_servico(DBProdutos DB, int id, int quantidade,
			double desconto) throws NoSuchElementException {
		
		if(DB.getServico(id) == null)
			throw new NoSuchElementException();
		
		item_venda aux = new item_venda();
		aux.set_servico(DB, id, quantidade, desconto);
		this.valor += aux.getPreco();
		this.item.add(aux);
	}
	
	public void troca_produto(DBProdutos DB, int id_troca, int id,
			int quantidade, double desconto) {

		item_venda aux = new item_venda();
		aux.set_produto(DB, id, quantidade, desconto);
		this.valor += aux.getPreco();
		this.item.add(aux);
		
		this.deleta_item(id_troca);
	}

	public void troca_servico(DBProdutos DB, int id_troca, int id,
			int quantidade, double desconto) {

		item_venda aux = new item_venda();
		aux.set_servico(DB, id, quantidade, desconto);
		this.valor += aux.getPreco();
		this.item.add(aux);
		
		this.deleta_item(id_troca);
	}

	public int find_item(int id) {
		for(int i = 0; i < this.item.size(); i++)
			if(this.item.get(i).getId() == id)
				return i;
		return -1;
	}
	
	public boolean deleta_item(int id) {
		if(this.item.size() <= 1)
			return false;				
		
		int idx = this.find_item(id); 
		if(idx >= 0) {
			this.valor -= this.item.get(idx).getPreco();
			this.item.remove(idx);
			return true;
		}
		
		return false;
	}
}