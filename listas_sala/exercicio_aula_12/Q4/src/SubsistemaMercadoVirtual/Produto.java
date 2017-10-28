package SubsistemaMercadoVirtual;

public class Produto {
	private double preco_;
	private String nome_;
	private int id_;
	
	protected Produto(String nome, int id, double Preco) {
		this.preco_ = Preco;
		this.nome_ = nome;
		this.id_ = id;
	}
	
	public static Produto create(String nome, int id, double Preco) {
		return new Produto(nome, id, Preco);
	}
	
	public double getPreco() {
		return this.preco_;
	}
}