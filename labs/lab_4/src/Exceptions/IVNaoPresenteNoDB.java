package Exceptions;

public class IVNaoPresenteNoDB extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensagem;

	public IVNaoPresenteNoDB(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	public String getMessage() {
		return this.mensagem;
	}
}