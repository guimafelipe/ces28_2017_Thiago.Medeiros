package Back_End;

public class cliente {
	private int CPF, telefone;
	private String nome, endereco;

	public cliente(int CPF, int telefone, String nome, String endereco) {
		this.CPF = CPF;
		this.telefone = telefone;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public int getCPF() {
		return this.CPF;
	}
	
	public int getTelefone() {
		return this.telefone;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
}

// servico
//private String nome, setor, natureza;
//private double preco;

// produto
//private String nome, setor, info;
//private double preco;