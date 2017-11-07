package DB;

//import java.util.HashMap;

public abstract class IV {
	private int quantidade;  // sao atributos de IV,
	private double desconto; // nao dos PS
	//private HashMap<Integer, Integer> sub_PS; // (id, quantidade) dos subprod/subserv
	
	protected IV() {
		this.quantidade = 0;
		this.desconto = 0.0;
	}
		
	public void setQuantidade(int quant) {
		if(quant > 0) {	this.quantidade = quant; }
	}
	
	public int getQuantidade() { return this.quantidade; }
	
	public void setDesconto(double desc) {
		if(desc >= 0.0) { this.desconto = desc; }
	}
	
	public double getDesconto() { return this.desconto; }

	public abstract String getName();
	public abstract double getPreco();
	public abstract String getOutros();
}