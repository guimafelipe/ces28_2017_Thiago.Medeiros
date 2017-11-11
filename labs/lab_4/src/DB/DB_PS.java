package DB;

public class DB_PS {

	public DB_PS() { }
		
	protected void addItem(IV newItem) {
	}
	
	protected boolean isInDB(int id) {
		return false;
	}
		
	protected IV getItem(int id) {
		return null;
	}
	
	protected IV removeItem(int id) {
		return null;
	}
	
	protected Produto createProduto(String nome, double preco_hora, String outros)
	{
		return new Produto(nome, preco_hora, outros);
	}
	
	protected Servico createServico(String nome, double preco_und, String outros)
	{
		return new Servico(nome , preco_und, outros);
	}

}