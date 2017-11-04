package NotaFiscal;

import java.util.Map;

import DB.IV;


final public class NotaFiscalImut extends NotaFiscal {
	final private String id, estado, outros, NF, NFItems;
	final private Map<Integer, IV> items;
	final private double valor;
	
	//IMPOSTOS!!!
	
	public NotaFiscalImut(Map<Integer, IV> items, String Id) {
		this.estado = "validada";
		this.id = Id;
		this.valor  = 0.0; // calcular
		this.outros = "";
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
				  "\nStatus: " + this.estado +
				  "\nID: " + this.id +
				  "\n\nItems de Venda:" + 
				  "\n\nCOD.      Nome                Preco (Und.)   Quant.  Preco (Total)\n" +
				  checkItems() +
				  "                                                     --------------\n" + 
				  "                                              Valor: R$ " + Double.toString(this.valor) + "\n" + 
				  "-------------------------------------------------------------------\n\n";
	}

	public String getId() {
		return this.id;
	}
	
	public String getEstado() {
		return this.estado;
	}

	public int getQuantidade(int id) {
		if(isInNF(id)) {
			IV item = this.items.get(id);
			return item.getQuantidade();
		} 
		
		return 0;
	}

	public double getPreco(int id) {
		if(isInNF(id)) {
			IV item = this.items.get(id);
			return item.getPreco();
		} 
		
		return 0;
	}
	
	public double getDesconto(int id) {
		if(isInNF(id)) {
			IV item = this.items.get(id);
			return item.getDesconto();
		} 
		
		return 0.0;
	}
	
	public String getNome(int id) {
		if(isInNF(id)) {
			IV item = this.items.get(id);
			return item.getName();
		} 
		
		return "";		
	}
	
	public String getOutros(int id) {		
		return this.outros;
	}

	public     int getNFSize()  { return this.items.size(); }
	public  String checkNotaFiscal() { return this.NF; }
	private String checkItems() { return this.NFItems; }
	
	public boolean isInNF(int id) {
		return !(this.items.get(id) == null);
	}
}