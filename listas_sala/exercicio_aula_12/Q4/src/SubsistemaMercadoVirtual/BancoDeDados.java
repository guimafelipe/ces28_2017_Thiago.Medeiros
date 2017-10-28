package SubsistemaMercadoVirtual;

public class BancoDeDados {
	public static void registrar(String nome, int clienteId) {
		//Cliente cliente = Cliente.create(nome, clienteId);		
		//Carrinho car = Carrinho.create();
		//cliente.adicionarCarrinho(car);
	}

	public static Cliente selectCliente(int id) {
		if(id == 123) {
			Cliente cliente = new Cliente("Zé", 123);
			Carrinho car = Carrinho.create();
			cliente.adicionarCarrinho(car);
			return cliente;
		}
		return null;
	}

	public static void comprar(int prodId, int clienteId) {
		Cliente cliente = selectCliente(clienteId);
		Produto produto = selectProduto(prodId);		
		cliente.getCarrinho().adicionar(produto);
	}

	public static Produto selectProduto(int id) {
		if(id == 223) {
			return new Produto("produto_1", 223, 3.50);
		}
		else if(id == 342) {
			return new Produto("produto_2", 342, 1.50);
		}
		return null;
	}
	
	public static void fecharCompra(int id) {
		Cliente cliente = selectCliente(id);
		double valor = cliente.getCarrinho().getTotal();
		processarPagamento(cliente, valor);
	}
	
	public static void processarPagamento(Cliente cliente, double valor) {
		//???
	}
}