package Exceptions;

public class NFInvalida extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensagem;

	public NFInvalida(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	public String getMessage() {
		return this.mensagem;
	}
}