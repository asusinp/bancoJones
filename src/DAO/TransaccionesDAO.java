/**
 * 
 */
package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import bbdd.ConnectionManager;
import beans.Account;
import beans.Transaccion;

/**
 * @author iaw21752927
 *
 */
public class TransaccionesDAO {
	
	static Connection con = null;
	
	public boolean realizaTransaccion(String origen, String destino) {
		return true;
	}
	
	public List<Transaccion> listaTransacciones(String iban) throws IOException {
		List<Transaccion> transactionsList = new LinkedList<>();		
		con = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;

		try {
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("transactions"));
			stmt.setString(1, iban);
			rs = (ResultSet) stmt.executeQuery();
			while (rs.next()) {
				Transaccion tr = new Transaccion(Integer.parseInt(rs.getString("id")), rs.getString("fecha"), Double.parseDouble(rs.getString("cantidad")), rs.getString("origen"), rs.getString("destino"));
				transactionsList.add(tr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}		
		return transactionsList;
	}
}
