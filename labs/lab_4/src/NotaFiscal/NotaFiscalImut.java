package NotaFiscal;

import PS.GerenteIV;

final public class NotaFiscalImut extends NotaFiscal {
	final private String estado;
	final private double valor;
	final private String outros;
	final private String nota;
	final private int items;
	
	public NotaFiscalImut(GerenteIV gerenteIV, String Id) {
		this.estado = Id;
		this.valor  = 0.0; // calcular
		this.outros = "";
		this.items = gerenteIV.checkItemsSize(); // total? ou apenas dos items principais?

		this.nota = "-------------------------------------------------------------------\n" + 
					"Nota Fiscal Paulista :D" + 
					"\n\nID: " + this.estado +
				    "\n\nItems de Venda:" + 
				    "\n\nCOD.      Nome                Preco (Und.)   Quant.  Preco (Total)\n" +
				    gerenteIV.checkItems() +
				    "                                                     --------------\n" + 
				    "                                              Valor: R$ " + Double.toString(this.valor) + "\n" + 
				    "-------------------------------------------------------------------\n\n";
	}
	
	public int getNumOfIVs() {
		return this.items;
	}
	
	public String checkNotaFiscal() {
		return this.nota;
	}
}