package Exceptions;

public class QuantidadeInvalida extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public QuantidadeInvalida(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	public String getMessage() {
		return this.mensagem;
	}
}