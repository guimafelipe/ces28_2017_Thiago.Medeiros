package mercadoVirtual;

import java.util.HashMap;
import java.util.Map;

public class BancoDeDados {
	Map<Integer, Produto> produtosById;
	Map<Integer, Cliente> clientesById;
	
	public BancoDeDados() {
		produtosById = new HashMap<>();
		clientesById = new HashMap<>();
		for (int i = 0; i < 500; i++) {
			produtosById.put(new Integer(i), Produto.create("Produto #" + i, i, (double)(i*3 + 1)));
		}
	}
		
	public void adicionar(int Client_id, int Prod_id) {
		clientesById.get(Client_id).adicionar(produtosById.get(Prod_id));
	}
	
	public double getTotal(int id ) {
		return clientesById.get(id).getTotal();
	}	
	
	public void processarPagamento(int id) {
		double valor = getTotal(id);
		System.out.println("(Pagamento processado) Cliente: " + id + ", Valor: " + valor);
	}
	
	public void registrarCliente(String name, int id) {
		clientesById.put(id, Cliente.create(name, id));
	}
}