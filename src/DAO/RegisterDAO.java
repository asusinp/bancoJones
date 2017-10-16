package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;

import bbdd.ConnectionManager;
import beans.Cliente;

public class RegisterDAO {

	static Connection con = null;

	public static Cliente loginValid(String dni, String pass, String surname, String birthday, char sex, String password, String address, String name, String phone) throws IOException {
		Cliente c = new Cliente();

		con = ConnectionManager.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try {
			//System.out.println("SELECT * FROM clientes WHERE contraseña=md5('" + pass + "')" + " and dni='" + user + "'");
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");			
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}			
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("cliente.register"));
			stmt.setString(1, dni);
			stmt.setString(2, name);
			stmt.setString(3, surname);
			stmt.setString(4, birthday);
			stmt.setString(5, String.valueOf(sex));
			stmt.setString(6, address);
			stmt.setString(7, phone);
			stmt.setString(8, password);
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
