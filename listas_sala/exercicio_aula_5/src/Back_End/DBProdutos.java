package Back_End;

public interface DBProdutos {
	public void addProduto(String nome, String setor, String info, double preco); 
	public void addServico(String nome, String setor, String natureza, double preco);
	public produto getProduto(int id);
	public servico getServico(int id);
}