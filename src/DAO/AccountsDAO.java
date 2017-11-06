/**
 * 
 */
package DAO;

import java.util.LinkedList;
import java.util.List;
import beans.Account;

/**
 * @author iaw21752927
 *
 */
public class AccountsDAO {
	

	
	public static List<Account> getAccounts(String dni) {
		List<Account> list = new LinkedList<>();
		return list;
	}
	
	public boolean insertAccount(Account account) {
		return true;
	}
	
	public boolean deleteAccount(Account account) {
		return true;
	}

}
