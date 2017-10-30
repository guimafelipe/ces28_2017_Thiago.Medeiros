package DB;

public class DB_PS {
	public void addItem(IV newItem) {
		//pass
	}
	
	public boolean checkItem(int id) {
		//pass
			
		//test:
		if(id == 100 || id == 200 || id == 300 || id == 400) {
			return true;
		}
		
		return false;
	}
		
	public IV getItem(int id) {
		//pass
		
		//test:
		if(id == 100) {
			return new Servico("Serv_1", 1.00, "");
		}
		else if(id == 200) {
			return new Produto("Prod_1", 1.00, "");
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
		//pass
		return null;
	}
}