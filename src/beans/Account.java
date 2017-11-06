/**
 * 
 */
package beans;

/**
 * @author iaw21752927
 *
 */
public class Account {
	public String date;
	public Cliente cliente;
	public double balance;
	
	public Account(String date, Cliente cliente, double balance) {
		this.date = date;
		this.cliente = cliente;
		this.balance = balance;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [date=" + date + ", cliente=" + cliente + ", balance=" + balance + "]";
	}
	
	
	
	
}
