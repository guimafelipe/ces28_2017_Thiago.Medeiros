package Back_End;

import Front_End.item_interface;

public class servico implements item_interface {
	private String nome, setor, natureza;
	private double preco;
	private int id;
	
	public servico(int id, String nome, String setor, String natureza, double preco) {
		this.id = id;
		this.nome = nome;
		this.setor = setor;
		this.natureza = natureza;
		this.preco = preco;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getSetor() {
		return this.setor;
	}

	public double getPreco() {
		return this.preco;
	}	
	
	public int getId() {
		return this.id;
	}
}
