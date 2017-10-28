package SubsistemaMercadoVirtual;

import java.util.ArrayList;

public class Cliente {
	private String nome_;
	private int id_;
	private Carrinho car;
	
	protected Cliente(String nome, int id) {
		this.nome_ = nome;
		this.id_ = id;
		this.car = null;
	}
	
	public static Cliente create(String nome, int id, BancoDeDados banco) {
		Cliente cliente = banco.selectCliente(id);
		if(cliente != null) {
			return cliente;
		}
		return null;
	}
	
	public void adicionarCarrinho(Carrinho c) { this.car = c; }
	public Carrinho getCarrinho() { return this.car; }
}
