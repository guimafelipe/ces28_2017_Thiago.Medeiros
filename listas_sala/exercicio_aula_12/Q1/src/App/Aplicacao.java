package App;

import SubsistemaMercadoVirtual.*;

public class Aplicacao {
	private static Produto produto;
	
	public static void main(String[] args) {
		BancoDeDados banco = new BancoDeDados();
		
		// registrar comprador
		Cliente cliente = Cliente.create("Zé", 123, banco);
		Carrinho car = Carrinho.create();
		cliente.adicionarCarrinho(car);
	
		// realizar uma compra
		produto = banco.selectProduto(223);
		cliente.getCarrinho().adicionar(produto);
	
		// realizar outra compra
		produto = banco.selectProduto(342);
		cliente.getCarrinho().adicionar(produto);

		// fechar compra
		double valor = cliente.getCarrinho().getTotal();
		banco.processarPagamento(cliente, valor);
				
		produto = null;
	}
}