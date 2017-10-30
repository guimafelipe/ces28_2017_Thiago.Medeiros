package DB;

final public class Produto extends IV{
	final private String nome;
	final private double preco_hora;
	final private String outros;
	
	protected Produto(String nome, double preco_hora, String outros) {
		this.nome = nome;
		this.preco_hora = preco_hora;
		this.outros = outros;
	}

	public String getName()  { return this.nome; }	
	public double getPreco() { return this.preco_hora; } 
}