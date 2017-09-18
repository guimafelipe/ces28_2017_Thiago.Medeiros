package labmock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServicoDB implements IServicoDB {
	private Connection conn;
	
	public void getDBConnection() {
		try {
			Class.forName("com.mysql.jdbk.Driver");
			conn = DriverManager.getConnection("djbc:mysql://localhost:8066/busca", "admin", "senha");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int persisteProcesso(IProcesso proc) {
		try {
			String statement = "INSERT INTO PROCESSO (id, nomeReclamante, telefone, email)" + "VALUES ('" + proc.getID()
				+ "', '" + proc.getNomeReclamante() + "', '" + proc.getTelefone() + "', '" + proc.getEmail()
				+ "');";
			return conn.createStatement().executeUpdate(statement);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}