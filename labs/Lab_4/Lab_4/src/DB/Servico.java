package DB;

final public class Servico extends IV {
	final private String nome;
	final private double preco_und;
	final private String outros;
	
	protected Servico(String nome, double preco_und, String outros) {
		this.nome = nome;
		this.preco_und = preco_und;
		this.outros = outros;
	}
	
	public String getName()  { return this.nome; }	
	public double getPreco() { return this.preco_und; } 
}