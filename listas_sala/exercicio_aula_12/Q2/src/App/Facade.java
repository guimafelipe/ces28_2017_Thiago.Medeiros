package App;

import java.util.ArrayList;

import SubsistemaMercadoVirtual.*;

public class Facade {
	private BancoDeDados banco;
	
	public Facade(BancoDeDados banco_) {
		this.banco = banco_;
	}
	
	public void registrar(String nome, int clienteId) {
		Cliente cliente = Cliente.create(nome, clienteId, this.banco);		
		Carrinho car = Carrinho.create();
		cliente.adicionarCarrinho(car);
	}
	
	public void comprar(int prodId, int clienteId) {
		Cliente cliente = banco.selectCliente(clienteId);
		Produto produto = banco.selectProduto(prodId);		
		cliente.getCarrinho().adicionar(produto);
	}
	
	public void fecharCompra(int clienteId) {
		Cliente cliente = banco.selectCliente(clienteId);
		double valor = cliente.getCarrinho().getTotal();
		banco.processarPagamento(cliente, valor);
	}	
}