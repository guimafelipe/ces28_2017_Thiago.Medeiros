package DB;

public class DB_PS {
	static private DB_PS instance = null;
	
	private DB_PS() { }
	
	// Singleton
	public static DB_PS getInstance() {
		if(instance == null) { return new DB_PS(); }
		return instance;
	}
	
	public void addItem(IV newItem) {
		//
	}
	
	public boolean isInDB(int id) {
		//test:
		if(id == 100 || id == 200 || id == 300 || id == 400) {
			return true;
		}
		
		return false;
	}
		
	public IV getItem(int id) {
		//test:
		if(id == 100) {
			return new Servico("Serv_1", 1.00, "");
		}
		else if(id == 200) {
			return new Produto("Prod_1", 3.00, "");
		}
		else if(id == 300) {
			return new Servico("Serv_2", 5.00, "");
		}
		else if(id == 400) {
			return new Produto("Prod_2", 100.0, "");
		}
		
		return null;
	}
	
	public IV removeItem(int id) {
		return null;
	}
}