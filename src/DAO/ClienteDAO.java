package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bbdd.ConnectionManager;
import beans.Cliente;

public class ClienteDAO {

	static Connection con = null;

	public static Cliente loginValid(String user, String pass) {
		Cliente c = new Cliente();

		con = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try {
			System.out.println("SELECT * FROM clientes WHERE contraseña=md5('" + pass + "')" + " and dni='" + user + "'");
			stmt = con.prepareStatement("SELECT * FROM clientes WHERE contraseña=md5('" + pass + "')" + " and dni='" + user + "'");			
			rs = (ResultSet) stmt.executeQuery();
			if (rs.next()) {
				c.setNombre(rs.getString("nombre"));
				c.setDni(rs.getString("dni"));
				c.setValid(true);
			} else {
				c.setValid(false);
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

		ConnectionManager.getConnection();
		return c;
	}

}
