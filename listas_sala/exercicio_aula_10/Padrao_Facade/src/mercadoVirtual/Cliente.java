package mercadoVirtual;

public class Cliente {
	private int id;
	private String nome;
	private Carrinho carrinho;
	
	private Cliente(String nome, int id) {
		this.id = id;
		this.nome = nome;
		this.carrinho = Carrinho.getInstance();		
	}
	 
	public static Cliente create(String nome, int id) {
		return new Cliente(nome, id);
	}
	
	public double getTotal() { return carrinho.getTotal(); }			
	public void adicionar(Produto p) { carrinho.adicionar(p); }
}