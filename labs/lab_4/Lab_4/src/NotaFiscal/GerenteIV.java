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
	
	protected boolean add(int id, int quantidade) {
		IV newPS = DB_ps.getItem(id);
		
		if(newPS != null) {
			newPS.setQuantidade(quantidade);
			this.items.put(id, newPS);
			return true;
		}
		
		return false;
	}
}
