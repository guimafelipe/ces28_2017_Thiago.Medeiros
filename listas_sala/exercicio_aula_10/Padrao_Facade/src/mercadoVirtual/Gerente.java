package mercadoVirtual;

public class Gerente {
	private BancoDeDados banco;
	
	public Gerente() {	
		banco = new BancoDeDados();		
	}
	
	// registrar comprador
	public void addCliente(String name, int id) {
		banco.registrarCliente(name, id);
	}

	// realizar compra
	public void buyProduto(int Client_id, int Prod_id) {
		banco.adicionar(Client_id, Prod_id);
	} 
	
	// fechar compra
	public void fecharCompra(int id) {
		banco.processarPagamento(id);
	}
}