package NotaFiscal;

import DB.DB_PS;

public class NotaFiscal {
	private GerenteIV gerenteIV;
	private String estado;
	private double valor;
	
	private NotaFiscal() {
		this.estado = "em elaboração";
		this.valor  = 0.0;
	}
	
	public NotaFiscal create(int id, int quantidade, DB_PS DB_prod_serv) {
		this.gerenteIV = new GerenteIV(DB_prod_serv);
		
		if(this.gerenteIV.add(id, quantidade)) {      // verifica no BD se item existe
			return new NotaFiscal(); // se existir, cria a nota fiscal
		}
		
		this.gerenteIV = null;            // senao, retorna null
		return null;
	}
	
	public void validate(String id) {
		this.estado = id;
	}
}