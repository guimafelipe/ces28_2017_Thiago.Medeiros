package NotaFiscal;

import DB.DB_PS;
import PS.GerenteIV;

public abstract class NotaFiscal {
	public static NotaFiscalMut create(int id, int quantidade, DB_PS DB_prod_serv) {
		return NotaFiscalMut.create(id, quantidade, DB_prod_serv);
	}

	public int getNumOfIVs() { return 0; }
	public GerenteIV getGerente()   { return null; }
	public String checkNotaFiscal() { return ""; }		
	public boolean addIVtoNF(int id, int quantidade)    { return false; }
	public boolean changeIVonNF(int id, int quantidade) { return false; }
	public boolean removeIVfromNF(int id) { return false; }
}