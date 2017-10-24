package bbdd;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {

	static Connection connection;

	public static Connection getConnection() {
		
		InitialContext ctx;
		try {
			ctx = new javax.naming.InitialContext();
			DataSource ds = (javax.sql.DataSource)ctx.lookup("jdbc/banco");
			connection = ds.getConnection();
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
//		Connection connection = null;
//		try {
//			Class.forName("org.postgresql.Driver");
//			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/training", "alex", "maquina");
//		} catch (Exception e) {
//			System.out.println("falló la conexión");
//			e.printStackTrace();
//		}

		return connection;
	}

}
