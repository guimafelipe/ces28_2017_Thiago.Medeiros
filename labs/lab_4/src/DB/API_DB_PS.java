package DB;

public class API_DB_PS {
	
	// Singleton
	static private API_DB_PS instance = null;
	private API_DB_PS() {
	}
	public static API_DB_PS getInstance() {
		if(instance == null) { instance = new API_DB_PS(); }
		return instance;
	}
	
	private DB_PS database_ps;
	
	public boolean isInDB(int id) {
		if(database_ps == null)
		{
			System.out.println("nulo");
		}
		return database_ps.isInDB(id);
	}
	
	public void addItem(IV newItem) {
		database_ps.addItem(newItem);
	}
	
	public IV getItem(int id) {
		return database_ps.getItem(id);
	}
	
	public Produto createProduto(String nome, double preco_hora, String outros)
	{
		return database_ps.createProduto(nome, preco_hora, outros);
	}
	
	public Servico createServico(String nome , double preco_und, String outros)
	{
		return database_ps.createServico(nome, preco_und, outros);
	}
	
	protected void setDB (DB_PS db) // metodo necessário para Mockar a DB, não existiria no programa real.
	{
		database_ps = db;
	}
}
