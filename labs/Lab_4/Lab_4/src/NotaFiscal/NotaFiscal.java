package NotaFiscal;

import DB.DB_PS;

public class NotaFiscal {
	private GerenteIV gerenteIV;
	private String estado;
	private double valor;
	private String outros;
	
	private NotaFiscal(int id, int quantidade, DB_PS DB_prod_serv) {
		this.estado = "em elaboração";
		this.valor  = 0.0;		
		this.gerenteIV = new GerenteIV(DB_prod_serv);
		
		this.gerenteIV.addIVtoNF(id, quantidade);
	}
	
	public String checkNotaFiscal() {
		String Nota = "Nota Fiscal Paulista :D\n\n";
		
		if(this.estado.equals("em elaboração")) {
			Nota += "Status: em elaboração\n";
		}
		else {
			Nota += "ID: " + this.estado + "\n";
		}
		
		Nota += "\nItems de Venda:\n\n";
		
		Nota += "COD.      Nome                Preco (Und.)   Quant.  Preco (Total)\n";
		Nota += gerenteIV.checkItems();
		
		if(this.estado.equals("em elaboração")) {
			Nota += "\n                                              Valor: R$ " + Double.toString(this.valor) + "\n";
		}
		else {
			Nota += "\n                                              Valor: Não Calculado\n";			
		}
					
		return Nota;
	}
	
	public static NotaFiscal create(int id, int quantidade, DB_PS DB_prod_serv) {
		if(DB_prod_serv.checkItem(id)) {                         // verifica no BD se item existe
			return new NotaFiscal(id, quantidade, DB_prod_serv); // se existir, cria a nota fiscal
		}		
		return null;                                             // senao, retorna null
	}
	
	public void validate(String id) {
		this.estado = id;
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