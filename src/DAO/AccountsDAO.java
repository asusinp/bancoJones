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

/**
 * @author iaw21752927
 *
 */
public class AccountsDAO {
	
	static Connection con = null;

	public static List<Account> getAccounts(String dni) throws IOException {
		List<Account> accountsList = new LinkedList<>();		
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
			stmt = con.prepareStatement(prop.getProperty("accounts.cliente.info"));
			stmt.setString(1, dni);
			rs = (ResultSet) stmt.executeQuery();
			while (rs.next()) {
				Account account = new Account(rs.getString("iban"), rs.getString("cliente"), Double.parseDouble(rs.getString("saldo")));
				accountsList.add(account);
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
		System.out.println(accountsList);
		return accountsList;

	}

	public static boolean insertAccount(Account account) {
		boolean insert = false;
		con = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		
		try {
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");	
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}			
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("accounts.cliente.reg"));
			stmt.setString(1, account.getIban());
			stmt.setDouble(2, account.getBalance());
			stmt.setString(3, account.getCliente().getDni());
			stmt.execute();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
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
					insert = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		ConnectionManager.getConnection();
		return insert;
	}

	public static boolean deleteAccount(String iban) {
		boolean delete = false;
		con = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		
		try {
			Properties prop = new Properties();
			InputStream input = ClienteDAO.class.getClassLoader().getResourceAsStream("sql.properties");	
			if (input == null) {
				System.out.println("No se encontró el archivo");
			}
			prop.load(input);
			stmt = con.prepareStatement(prop.getProperty("accounts.cliente.del"));
			stmt.setString(1, iban);
			stmt.execute();
			System.out.println(stmt.toString());
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
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
					delete = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		ConnectionManager.getConnection();
		return delete;
	}

}
