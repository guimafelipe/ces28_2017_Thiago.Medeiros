package SubsistemaMercadoVirtual;

import java.util.ArrayList;

public class Carrinho {
	private double total;
	private ArrayList<Produto> produtos;
	
	private Carrinho() {
		this.total = 0.0;
		this.produtos = new ArrayList<Produto>();
	}
	
	public static Carrinho create() {
		return new Carrinho();
	}
	
	public void adicionar (Produto p) {
		produtos.add(p);
		this.total += p.getPreco();
	}
	
	public double getTotal() {
		return this.total;
	}
}