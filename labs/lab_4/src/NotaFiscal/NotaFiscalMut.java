package NotaFiscal;

import java.util.HashMap;
import java.util.Map;

import DB.DB_PS;
import DB.IV;

public class NotaFiscalMut extends NotaFiscal {
	private String estado, outros;
	private double valor;
	
	private DB_PS DB_ps;
	private Map<Integer, IV> items;
	
	//IMPOSTOS!!!
	
	private NotaFiscalMut(int id, int quantidade, DB_PS DB_prod_serv) {
		this.estado = "em elaboração";
		this.valor  = 0.0;		
		this.DB_ps  = DB_prod_serv;
		this.items  = new HashMap<Integer, IV>();

		this.addIV(id, quantidade);
	}

	public static NotaFiscalMut create(int id, int quantidade, DB_PS DB_prod_serv) {
									  // Cria a nota fiscal, caso:
		if(DB_prod_serv != null &&    // 1. O DB_PS seja válido
		   quantidade > 0 &&          // 2. A quantidade seja válida
		   DB_prod_serv.isInDB(id)) { // 3. O PS exista no DB_PS
			return new NotaFiscalMut(id, quantidade, DB_prod_serv);             
		}		
		return null;
	}
	
	public String getEstado() {
		return this.estado;
	}

	public IV getItem(int id) {
		if(isInNF(id)) {
			IV newItem = this.DB_ps.getItem(id);			
			newItem.setQuantidade(getQuantidade(id));			
			return newItem;
		}
		
		return null;
	}	
	
	public Map<Integer, IV> getItems() {
		Map<Integer, IV> newItems = new HashMap<Integer, IV>();
		
		for(int k : this.items.keySet()) {
			IV atual = getItem(k);
						
			newItems.put(k, atual);
		}
		
		return newItems;
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

	public int getNFSize() {
		return this.items.size();
	}
				
	public String checkNotaFiscal() {
		String Nota = "-------------------------------------------------------------------\n" + 
					  "Nota Fiscal Paulista :D\n\n";
		
		Nota += "Status: em elaboração\n" + 
				"Id: -----------\n";
		
		Nota += "\nItems de Venda:\n\n" + 		
				"COD.      Nome                Preco (Und.)   Quant.  Preco (Total)\n" + 
				this.checkItems() + 
				"                                                     --------------\n";
		
		if(this.estado.equals("em elaboração")) {
			Nota += "                                              " + 
					"Valor: R$ " + Double.toString(this.valor) + "\n";
		}
		else {
			Nota += "                                              " + 
					"Valor: Não Calculado\n";			
		}
		
		Nota += "-------------------------------------------------------------------\n\n";
					
		return Nota;
	}	
	
	private String checkItems() {
		String list = "";

		for(int item : items.keySet()) {
			IV atual = this.items.get(item);
			
			double preco = atual.getPreco();
			int    quant = atual.getQuantidade();
			double total = preco * quant; 
			
			list += formatString(9, Integer.toString(item)) + " " + formatString(19, atual.getName()) + " " +
			        "R$ " + formatString(11, Double.toString(preco)) + " " + formatString(7, Integer.toString(quant)) + " " +
					"R$ " + formatString(11, Double.toString(total)) + "\n";   
		}
		
		return list;
	}
		
	public boolean mudaQuantidade(int id, int delta) {
		if(!isInNF(id)) { return false; }
		
		IV PS = this.items.get(id);	
		int atual = PS.getQuantidade();		
		if(atual + delta < 0) { return false; }
		
		PS.setQuantidade(atual + delta);
		
		return true;
	}
	
	public boolean setQuantidade(int id, int quantidade) {
		if(!isInNF(id) || quantidade <= 0) { return false; }		
		
		IV PS = this.items.get(id);
		PS.setQuantidade( quantidade);
		
		return true;
	}

	public boolean addIV(int id, int quantidade) {
		if(isInNF(id)) { return false; }
		
		if(isInDB(id)) {			
			IV newPS = this.DB_ps.getItem(id);
			newPS.setQuantidade(quantidade);
			this.items.put(id, newPS);
			return true;
		}
		
		return false;
	}

	public boolean removeIV(int id) {
												   // Não permite a remoção do item, caso:
		if(!isInNF(id) ||                          // 1. O item não esteja presente na NF
		   !this.estado.equals("em elaboração") || // 2. A nota esteja validada
		   getNFSize() == 1) {                     // 3. Seja o único item na nota
			return false;
		}
				
		this.items.remove(id);		
		return true;
	}	

	public boolean isInNF(int id) {
		return !(this.items.get(id) == null);
	}
	
	private boolean isInDB(int id) {
		return this.DB_ps.isInDB(id);
	}
}