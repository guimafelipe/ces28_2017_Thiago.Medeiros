package mercadoVirtual;

public class Façade {
	private Gerente gerente;
	
	public Façade() {
		gerente = new Gerente(); 
	}
	
	public void addCliente(String name, int id) {
		gerente.addCliente(name, id);
	}
	
	public void buyProduto(int Client_id, int Prod_id) {
		gerente.buyProduto(Client_id, Prod_id);	
	}
	
	public void fecharCompra(int id) {
		gerente.fecharCompra(id);
	}	
}