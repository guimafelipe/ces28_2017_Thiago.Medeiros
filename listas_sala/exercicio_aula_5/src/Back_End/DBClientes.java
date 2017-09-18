package Back_End;

public interface DBClientes {  
	public cliente getCliente(int CPF);
	public void addCliente(int CPF, String nome, String endereco, int telefone);
	public boolean verificaCPF(int CPF);
}