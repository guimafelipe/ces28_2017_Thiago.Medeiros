package DB;

import NotaFiscal.NotaFiscal;

public class DB_NF {
	private int id;
	
	protected DB_NF() {
		this.id = 0;
	}
	
	private String newId() {
		return Integer.toString(this.id++);
	}
	
	public NotaFiscal validateNF(NotaFiscal NF) {
		//pass
		return null;
	}
	
	public boolean checkId(String id) {
		return Integer.parseInt(id) < this.id;
	}
}
