package SubsistemaMercadoVirtual;

public class BancoDeDados {
	public Cliente selectCliente(int id) {
		if(id == 123) {
			Cliente cliente = new Cliente("Zé", 123);
			Carrinho car = Carrinho.create();
			cliente.adicionarCarrinho(car);
			return cliente;
		}
		return null;
	}
	
	public Produto selectProduto(int id) {
		if(id == 223) {
			return new Produto("produto_1", 223, 3.50);
		}
		else if(id == 342) {
			return new Produto("produto_2", 342, 1.50);
		}
		return null;
	}
	
	public void processarPagamento(Cliente cliente, double valor) {
		//???
	}
}