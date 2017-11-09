package DB;

import java.util.HashMap;
import java.util.Map;

import Exceptions.DBInvalido;
import Exceptions.IVNaoPresenteNoDB;
import Exceptions.NFInvalida;
import Exceptions.QuantidadeInvalida;
import NotaFiscal.NotaFiscal;

public class DB_NF {
	private int id;
	private Map<String, NotaFiscal> NFs;
	static private DB_NF instance = null;
	
	private DB_NF() {
		this.id = 0;
		this.NFs = new HashMap<String, NotaFiscal>();
	}
	
	// Possivelmente nao seria implementado na versão final, mas é necessário para rodar os testes corretamente 
	static public DB_NF cleanDB() {
		instance = null;
		return DB_NF.getInstance();
	}
	
	// Singleton
	static public DB_NF getInstance() {
		if(instance == null) {
			instance = new DB_NF();
		}
		return instance;
	}
	
	// Retorna a próxima ID possível
	private String newId() {
		return Integer.toString(this.id);
	}
	
	// Valida a ID
	private void updateId() {
		this.id++;
	}

	public boolean checkConsistencia(NotaFiscal NF) {
		return (NF.getEstado() == "em elaboração");
	}

	public NotaFiscal validateNF(NotaFiscal NF)
		   throws QuantidadeInvalida, IVNaoPresenteNoDB, DBInvalido, NFInvalida {
	
		if(!checkConsistencia(NF)) { return null; }
		
		String newId = newId();
		NFs.put(newId, null); // cria um 'slot' para a NF
				
		NotaFiscal newNF = NotaFiscal.create(NF.getItems(), NF.getOutros(), newId);		
		NFs.put(newId, newNF);
		
		//System.out.println(newId);
		
		this.updateId();
		return newNF;
	}
	
	// Retorna um objeto imutável com os dados da NF com ID correspondente
	public NotaFiscal getNF(String id) {
		if(checkId(id)) { return this.NFs.get(id); }
		return null;
	}
	
	// verifica se ID existe no BD
	public boolean checkId(String id) {
		return this.NFs.containsKey(id);
	}
	
	// verifica se NF pertence ao BD
	public boolean checkNF(NotaFiscal NF) {
		String id = NF.getId();
		
		if(!checkId(id) || NF.getEstado() != "validada") {
			return false;
		}
		
		NotaFiscal NF_do_BD = this.getNF(id);
		
		if(NF_do_BD.getNFSize() != NF.getNFSize()) {
			return false;
		}
		
		return true;
	}
}