package Exceptions;

public class DBInvalido extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public DBInvalido(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}

	public String getMessage() {
		return this.mensagem;
	}
}