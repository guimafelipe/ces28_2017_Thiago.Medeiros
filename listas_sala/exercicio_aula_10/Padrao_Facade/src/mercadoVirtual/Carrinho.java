package mercadoVirtual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carrinho {
	List<Produto> listaDeCompas;
	private static Carrinho instance;
	
	private Carrinho() {
		listaDeCompas = new ArrayList<>();
	}
	
	public static Carrinho getInstance() {
		if(instance == null) {
			instance = new Carrinho();
		}
		return instance;
	}
	
	public void adicionar(Produto p) {
		listaDeCompas.add(p);
	}
	
	public double getTotal() {
		double total = 0;
		for (Iterator<Produto> p = listaDeCompas.iterator(); p.hasNext();) {
			Produto produto = (Produto) p.next();
			System.out.println("Valor do item: " + produto.getPreco());
			total += produto.getPreco();
		}
		return total;
	}
}