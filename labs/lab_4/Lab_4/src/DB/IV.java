package DB;

import java.util.ArrayList;

public abstract class IV {
	private int quantidade; // sao atributos de IV,
	private double desconto; // nao dos PS
	private ArrayList<Integer> sub_PS; // ids dos subprodutos/subserviços
	
	public void setQuantidade(int quant) { this.quantidade = quant; }
	public int getQuantidade()  { return this.quantidade; }
	
	public void setDesconto(double desc) { this.desconto = desc; }
	public double getDesconto() { return this.desconto; }
}