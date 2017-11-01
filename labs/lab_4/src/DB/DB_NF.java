package DB;

import NotaFiscal.*;

public class DB_NF {
	private int id;
	
	public DB_NF() {
		this.id = 0;
	}
	
	private String newId() {
		return Integer.toString(this.id++);
	}
	
	public NotaFiscal validateNF(NotaFiscal NF) {
		return new NotaFiscalImut(NF.getGerente(), newId());
	}
	
	public boolean checkId(String id) {
		return Integer.parseInt(id) < this.id;
	}
}
