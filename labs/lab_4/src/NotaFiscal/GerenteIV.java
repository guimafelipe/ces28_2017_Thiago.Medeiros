package NotaFiscal;

import java.util.HashMap;
import java.util.Map;

import DB.DB_PS;
import DB.IV;

public class GerenteIV {	
	private DB_PS DB_ps;
	private Map<Integer, IV> items;

	// Construtor
	protected GerenteIV(DB_PS DB_prod_serv) {
		this.DB_ps = DB_prod_serv;
		this.items = new HashMap<Integer, IV>();
	}
	
	// Retorna uma copia do item
	public IV getItem(int id) {
		if(isInNF(id)) {
			IV trueIV = this.items.get(id);
			IV copyIV = this.DB_ps.getItem(id);
			
			copyIV.setDesconto(trueIV.getDesconto());
			copyIV.setQuantidade(trueIV.getQuantidade());
			
			return copyIV;
		}
		
		return null;
	}	

	// Retorna uma copia da lista de items
	public Map<Integer, IV> getItems() {
		Map<Integer, IV> copyItems = new HashMap<Integer, IV>();
		
		for(int k : this.items.keySet()) {
			IV copyIV = getItem(k);
			copyItems.put(k, copyIV);
		}
		
		return copyItems;
	}

	// Retorna a quantidade de items na lista
	public int getNFSize() {
		return this.items.size();
	}
		
	// Adiciona item à lista com a quantidade especificada
	public boolean addIV(int id, int quantidade) {
		if(isInNF(id)) { return false; }			
		
		if(isInDB(id)) {			
			IV newPS = DB_ps.getItem(id);
			newPS.setQuantidade(quantidade);
			this.items.put(id, newPS);
			return true;
		}
		
		return false;
	}
	
	public boolean setQuantidade(int id, int quantidade) {
		if(!isInNF(id)) { return false; }		
		if(quantidade <= 0) { return false; }

		IV PS = this.items.get(id);
		PS.setQuantidade(quantidade);
		this.items.put(id, PS);
		
		return true;
	}
	
	// Muda a quantidade de um item especifico (adiciona ou subtrai)
	public boolean mudaQuantidade(int id, int delta) {
		if(!isInNF(id)) { return false; }

		IV PS = this.items.get(id);		
		
		int atual = PS.getQuantidade();		
		if(atual + delta < 0) { return false; }
		
		PS.setQuantidade(atual + delta);
		this.items.put(id, PS);
		
		return true;
	}
	
	// Remove um item da lista
	public boolean removeIV(int id) {	
												   // Não permite a remoção do item, caso:
		if(!isInNF(id) ||                          // 1. O item não esteja presente na NF
		   getNFSize() == 1) {                     // 2. Seja o único item na nota
			return false;
		}

		this.items.remove(id);		
		return true;

	}	
	
	// Verifica se item pertence à NF
	public boolean isInNF(int id) {
		return !(this.items.get(id) == null);
	}

	// Verifica se item pertence ao BD
	private boolean isInDB(int id) {
		return this.DB_ps.isInDB(id);
	}
}