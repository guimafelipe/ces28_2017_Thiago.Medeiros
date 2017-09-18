package Back_End;

public class cadastro {
	private DBClientes DB;
	
	public cadastro(DBClientes DB) {
		this.DB = DB;
	}
		
	public void add_cliente(int CPF, String nome, String endereco, int telefone) {
		if(this.DB.verificaCPF(CPF))
			DB.addCliente(CPF, nome, endereco, telefone);
		else {
			//nao faz nada
		}
	}
	
	public cliente find_cliente(int CPF) {
		return DB.getCliente(CPF);
	}
}