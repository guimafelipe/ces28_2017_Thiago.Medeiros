package Back_End;

import Front_End.item_interface;

public class produto implements item_interface {
	private String nome, setor, info;
	private double preco;
	private int id;
	
	public produto(int id, String nome, String setor, String info, double preco) {
		this.id = id;
		this.nome = nome;
		this.setor = setor;
		this.info = info;
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
