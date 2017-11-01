package NotaFiscal;

import DB.DB_PS;
import PS.GerenteIV;

public class NotaFiscalMut extends NotaFiscal {
	private GerenteIV gerenteIV;
	private String estado;
	private double valor;
	private String outros;
	
	private NotaFiscalMut(int id, int quantidade, DB_PS DB_prod_serv) {
		this.estado = "em elaboração";
		this.valor  = 0.0;		
		this.gerenteIV = new GerenteIV(DB_prod_serv); // Singleton?
				
		this.gerenteIV.addIVtoNF(id, quantidade);
	}
	
	public GerenteIV getGerente() {
		return this.gerenteIV.cloneThis();
	}
	
	public int getNumOfIVs() {
		return this.gerenteIV.checkItemsSize();
	}
	
	public static NotaFiscalMut create(int id, int quantidade, DB_PS DB_prod_serv) {
		if(DB_prod_serv != null && quantidade > 0 && DB_prod_serv.checkItem(id)) { // verifica no BD se item existe
			return new NotaFiscalMut(id, quantidade, DB_prod_serv);                // se existir, cria a nota fiscal
		}		
		return null;                                                                // senao, retorna null
	}
			
	public String checkNotaFiscal() {
		String Nota = "-------------------------------------------------------------------\n" + 
					  "Nota Fiscal Paulista :D\n\n";
		
		if(this.estado.equals("em elaboração")) {
			Nota += "Status: em elaboração\n";
		}
		else {
			Nota += "ID: " + this.estado + "\n";
		}
		
		Nota += "\nItems de Venda:\n\n" + 		
				"COD.      Nome                Preco (Und.)   Quant.  Preco (Total)\n" + 
				gerenteIV.checkItems() + 
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
	
	public boolean addIVtoNF(int id, int quantidade) {
		if(!this.estado.equals("em elaboração")) {
			return false;
		}
		
		return this.gerenteIV.addIVtoNF(id, quantidade);
	}
	
	public boolean changeIVonNF(int id, int quantidade) {
		if(!this.estado.equals("em elaboração")) {
			return false;
		}
		
		return this.gerenteIV.changeQuantity(id, quantidade);
	}
	
	public boolean removeIVfromNF(int id) {
		if(!this.estado.equals("em elaboração") || this.gerenteIV.checkItemsSize() == 1) {
			return false;
		}

		return this.gerenteIV.removeIVfromNF(id);
	}
}