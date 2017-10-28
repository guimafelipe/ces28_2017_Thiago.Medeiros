package App;

import java.util.ArrayList;

import SubsistemaMercadoVirtual.*;

public class Facade {
	private BancoDeDados banco;
	private static final Facade instance = new Facade();
	
	private Facade() {}
    
	public static Facade getInstance() {
		return instance;
	}
	
	public static void registrar(String nome, int clienteId) {
		BancoDeDados.registrar(nome, clienteId);
	}

	public static void comprar(int prodId, int clienteId) {
		BancoDeDados.comprar(prodId, clienteId);
	}

	public static void fecharCompra(int clienteId) {
		BancoDeDados.fecharCompra(clienteId) ;
	}	
}