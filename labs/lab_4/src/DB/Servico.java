package DB;

final public class Servico extends IV {
	final private String nome, outros;
	final private double preco_und;
	
	protected Servico(String nome, double preco_und, String outros) {
		this.nome = nome;
		this.preco_und = preco_und;
		this.outros = outros;
	}
		
	public String getName()  { return this.nome; }	
	public double getPreco() { return this.preco_und; } 
	public String getOutros() { return this.outros; }
}