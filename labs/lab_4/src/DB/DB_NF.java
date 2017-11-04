package DB;

import java.util.HashMap;
import java.util.Map;

import NotaFiscal.NotaFiscal;
import NotaFiscal.NotaFiscalImut;

public class DB_NF {
	private int id;
	private Map<String, NotaFiscalImut> NFs;
	
	public DB_NF() {
		this.id = 0;
		this.NFs = new HashMap<String, NotaFiscalImut>();
	}
	
	private String newId() {
		return Integer.toString(this.id++);
	}

	public boolean checkConsistencia(NotaFiscal NF) {
		return (NF.getEstado() == "em elaboração");
	}

	public NotaFiscal validateNF(NotaFiscal NF) {
		if(!checkConsistencia(NF)) {
			return null;
		}
		
		String newId = newId();
		NotaFiscalImut newNF = new NotaFiscalImut(NF.getItems(), newId);
		
		NFs.put(newId, newNF);
		
		return newNF;
	}
	
	// Retorna um objeto imutável com os dados da NF com ID correspondente
	public NotaFiscal getNF(String id) {
		if(checkId(id)) {
			return NFs.get(id);
		}
		
		return null;
	}
	
	// verifica se ID existe no BD
	public boolean checkId(String id) {
		return (this.NFs.get(id) != null);
	}
	
	// verifica se NF pertence ao BD
	public boolean checkNF(NotaFiscal NF) {
		String id = NF.getId();
		
		if(!checkId(id) || NF.getEstado() != "validada") {
			return false;
		}
		
		NotaFiscal NF_do_BD = getNF(id);
		
		if(NF_do_BD.getNFSize() != NF.getNFSize()) {
			return false;
		}
		
		return true;
	}
}