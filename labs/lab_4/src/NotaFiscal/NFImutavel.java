package NotaFiscal;

import java.util.Map;

import DB.DB_NF;
import DB.IV;
import Exceptions.NFInvalida;

final public class NFImutavel extends NotaFiscal {
	final private String id, outros, NF, NFItems;
	final private Map<Integer, IV> items;
	final private double valor;
	
	// Construtor
	NFImutavel(Map<Integer, IV> items, String outros, String Id)
    throws NFInvalida {
		DB_NF DB_nota_fiscal = DB_NF.getInstance();
				
		if(!DB_nota_fiscal.checkId(Id) || DB_nota_fiscal.getNF(Id) != null) {
			throw new NFInvalida("Nota Fiscal Invalida!\n");
		}
		
		this.id = Id;
		this.valor  = 0.0; // calcular
		this.outros = outros;
		this.items = items;
		
		String aux = "";
		for(int item : items.keySet()) {
			IV atual = items.get(item);
			
			double preco = atual.getPreco();
			int    quant = atual.getQuantidade();
			double total = preco * quant;
			
			aux += formatString(9, Integer.toString(item)) + " " + formatString(19, atual.getName()) + " " +
			       "R$ " + formatString(11, Double.toString(preco)) + " " + formatString(7, Integer.toString(quant)) + " " +
				   "R$ " + formatString(11, Double.toString(total)) + "\n";   
		}
		
		this.NFItems = aux;				
		this.NF = "-------------------------------------------------------------------\n" + 
				  "Nota Fiscal Paulista :D\n" +
				  "\nStatus: validada" +
				  "\nID: " + this.id +
				  "\n\nItems de Venda:" + 
				  "\n\nCOD.      Nome                Preco (Und.)   Quant.  Preco (Total)\n" +
				  checkItems() +
				  "                                                     --------------\n" + 
				  "                                              Valor: R$ " + Double.toString(this.valor) + "\n" + 
				  "-------------------------------------------------------------------\n\n";
	}
	
	// Retorna item
	public IV getItem(int id) {
		if(isInNF(id)) {
			//return this.gerente.getItem(id);
		}
		
		return null;
	}	
	
	public Map<Integer, IV> getItems() {
		//return this.gerente.getItems();
		return null;
	}
	
	public   String getId()     { return this.id; }	
	public   String getEstado() { return "validada"; }	
	public   String getOutros() { return this.outros; }
	public      int getNFSize() { return this.items.size(); }	
	public   String checkNotaFiscal() { return this.NF; }	
	private  String checkItems()   { return this.NFItems; }	
	public  boolean isInNF(int id) { return !(this.items.get(id) == null); }
}