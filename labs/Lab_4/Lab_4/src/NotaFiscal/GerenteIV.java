package NotaFiscal;

import java.util.HashMap;
import java.util.Map;

import DB.DB_PS;
import DB.IV;

public class GerenteIV {	
	private DB_PS DB_ps;
	private Map<Integer, IV> items;
	
	protected GerenteIV(DB_PS DB_prod_serv) {
		this.DB_ps = DB_prod_serv;
		this.items = new HashMap<Integer, IV>();
	}
	
	protected int checkItemsSize() {
		return this.items.size();
	}
	
	private static String formatString(int spaces, String str) {
		return String.format("%-" + Integer.toString(spaces) + "s", str);
	}
	
	protected String checkItems() {
		String list = "";

		for(int item : items.keySet()) {
			IV atual = this.items.get(item);
			
			double preco = atual.getPreco();
			int    quant = atual.getQuantidade();
			double total = preco * quant; 
			
			list += formatString(9, Integer.toString(item)) + " " + formatString(19, atual.getName()) + " " +
			        "R$ " + formatString(11, Double.toString(preco)) + " " + formatString(7, Integer.toString(quant)) + " " +
					"R$ " + formatString(14, Double.toString(total)) + "\n";   
		}
		
		return list;
	}
	
	protected boolean addIVtoNF(int id, int quantidade) {
		if(isInNF(id)) { return false; }
				
		IV newPS = DB_ps.getItem(id);
		
		if(newPS != null) {
			newPS.setQuantidade(quantidade);
			this.items.put(id, newPS);
			return true;
		}
		
		return false;
	}
	
	protected boolean changeQuantity(int id, int quantidade) {
		IV PS = this.items.get(id);		
		if(!isInNF(id)) { return false; }
		
		int atual = PS.getQuantidade();		
		if(atual + quantidade < 0) { return false; }
		
		PS.setQuantidade(atual + quantidade);
		
		return true;
	}
	
	protected boolean removeIVfromNF(int id) {	
		if(!isInNF(id)) { return false; }
		
		this.items.remove(id);		
		return true;
	}	
	
	protected boolean isInNF(int id) {
		return !(this.items.get(id) == null);
	}
}